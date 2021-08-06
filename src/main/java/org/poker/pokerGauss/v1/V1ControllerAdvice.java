package org.poker.pokerGauss.v1;

import org.poker.pokerGauss.v1.exceptions.DefaultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestControllerAdvice
public class V1ControllerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DefaultException handleNotFoundException(NoHandlerFoundException e, WebRequest request) {
        return new DefaultException(404, "La ruta no existe");
    }
}
