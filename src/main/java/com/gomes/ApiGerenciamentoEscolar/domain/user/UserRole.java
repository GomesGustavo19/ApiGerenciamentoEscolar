package com.gomes.ApiGerenciamentoEscolar.domain.user;

public enum UserRole {

    DIRETOR("diretor"),
    SECRETARIO("secretario"),
    PROFESSOR("professor"),
    ALUNO("aluno");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
