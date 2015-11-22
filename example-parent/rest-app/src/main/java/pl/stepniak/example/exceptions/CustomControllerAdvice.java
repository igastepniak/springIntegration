package pl.stepniak.example.exceptions;

import lombok.extern.log4j.Log4j;
import org.jooq.exception.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Log4j
@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage companyProductNotFound(Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(value = DataAccessException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorMessage recordAlreadyExistsInDatabase(Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorMessage(HttpStatus.CONFLICT.value(), e.getMessage());
    }
}
