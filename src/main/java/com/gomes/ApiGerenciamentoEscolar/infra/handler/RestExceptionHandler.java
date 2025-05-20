package com.gomes.ApiGerenciamentoEscolar.infra.handler;

import com.gomes.ApiGerenciamentoEscolar.exception.PersonExistException;
import com.gomes.ApiGerenciamentoEscolar.exception.PersonNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonExistException.class)
    private ResponseEntity<RestErrorMenssage> personExistHandler(PersonExistException studentExistException){
        RestErrorMenssage treatResponse = new RestErrorMenssage(HttpStatus.valueOf(400),studentExistException.getMessage());
        return ResponseEntity.status(HttpStatus.valueOf(400)).body(treatResponse);
    }

    @ExceptionHandler(PersonNotExistException.class)
    private ResponseEntity<RestErrorMenssage> personNotExistHandler(PersonNotExistException studentNotExistException){
        RestErrorMenssage treatResponse = new RestErrorMenssage(HttpStatus.NOT_FOUND,studentNotExistException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(treatResponse);
    }

}
