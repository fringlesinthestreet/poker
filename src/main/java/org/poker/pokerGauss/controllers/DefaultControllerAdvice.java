package org.poker.pokerGauss.controllers;

import org.poker.pokerGauss.utils.exceptions.IncorrectNumberOfPlayersException;
import org.poker.pokerGauss.controllers.exceptions.DefaultException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DefaultException handleNotFoundException(NoHandlerFoundException e, WebRequest request) {
        return new DefaultException(404, "La ruta no existe");
    }

    @ExceptionHandler(IncorrectNumberOfPlayersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DefaultException handleIncorrectNumberOfPlayersException() {
        return new DefaultException(400, "Número de jugadores debe ser entre 1 y 10");
    }
}
