package pl.stepniak.example.exceptions;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(value = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
public class CipherException extends RuntimeException {

    public CipherException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
