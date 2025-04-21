package com.gomes.ApiGerenciamentoEscolar.exception;

public class StudentExistException extends RuntimeException{

    public StudentExistException() {super("Aluno já existe cadastrado");}

    public StudentExistException(String menssage){super(menssage);}
}
