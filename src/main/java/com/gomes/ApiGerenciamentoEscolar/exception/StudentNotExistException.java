package com.gomes.ApiGerenciamentoEscolar.exception;

public class StudentNotExistException extends RuntimeException {

    public StudentNotExistException() {super("Aluno não cadastrado");}

    public StudentNotExistException(String menssage){super(menssage);}
}
