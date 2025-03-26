package com.gomes.ApiGerenciamentoEscolar.domain.user;

public record RegisterDTO(String email, String password, UserRole role) {
}
