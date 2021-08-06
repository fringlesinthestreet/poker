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
    /*
    @ExceptionHandler({ HttpClientErrorException.BadRequest.class })
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public DefaultException handleBadRequestException() {
        return new DefaultException(400, "Request mal hecha");
    }
    */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DefaultException handleNotFoundException(NoHandlerFoundException e, WebRequest request) {
        return new DefaultException(404, "La ruta no existe");
    }
    /*
    @ExceptionHandler({ InternalError.class })
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
    public DefaultException handleInternalErrorException() {
        return new DefaultException(500, "Lo sentimos! Estamos trabajando para ud..");
    }*/
}
