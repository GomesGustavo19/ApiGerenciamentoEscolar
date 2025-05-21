package com.gomes.ApiGerenciamentoEscolar.domain.teacher;

import jakarta.validation.constraints.NotBlank;

public record RequestFindByTeacher(@NotBlank(message = "Mandatory field cpf") String cpf) {
}
