package com.gomes.ApiGerenciamentoEscolar.infra.handler;

import com.gomes.ApiGerenciamentoEscolar.exception.StudentExistException;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentExistException.class)
    private ResponseEntity<RestErrorMenssage> studentExistHandler(StudentExistException studentExistException){
        RestErrorMenssage treatResponse = new RestErrorMenssage(HttpStatus.valueOf(400),studentExistException.getMessage());
        return ResponseEntity.status(HttpStatus.valueOf(400)).body(treatResponse);
    }

    @ExceptionHandler(StudentNotExistException.class)
    private ResponseEntity<RestErrorMenssage> studentNotExistHandler(StudentNotExistException studentNotExistException){
        RestErrorMenssage treatResponse = new RestErrorMenssage(HttpStatus.NOT_FOUND,studentNotExistException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(treatResponse);
    }

}
