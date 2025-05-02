package com.gomes.ApiGerenciamentoEscolar.domain.aluno;

import jakarta.validation.constraints.NotNull;

public record RequestFinByStudentDTO(@NotNull String cpf) { }
