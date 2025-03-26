package com.gomes.ApiGerenciamentoEscolar.domain.user;

public enum UserRole {

    DIRETOR("role_diretor"),
    SECRETARIO("role_secretario"),
    PROFESSOR("role_professor"),
    ALUNO("role_aluno");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
