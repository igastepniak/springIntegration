package pl.stepniak.example.exceptions;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(value = org.springframework.http.HttpStatus.UNAUTHORIZED)
public class Unauthorized extends RuntimeException{

    public Unauthorized(String exceptionMessage) {
        super(exceptionMessage);
    }

}