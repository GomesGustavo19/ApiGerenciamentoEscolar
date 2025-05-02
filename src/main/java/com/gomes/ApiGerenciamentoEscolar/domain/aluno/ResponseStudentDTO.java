package com.gomes.ApiGerenciamentoEscolar.domain.aluno;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ResponseStudentDTO(@NotNull String nome, @NotNull String cpf, @NotNull Date dataNascimento) {}
