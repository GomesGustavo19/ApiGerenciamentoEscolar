package com.gomes.ApiGerenciamentoEscolar.domain.aluno;

import java.util.Date;

public record CreateStudentDTO(String nome, String cpf, Date dataNascimento) { }
