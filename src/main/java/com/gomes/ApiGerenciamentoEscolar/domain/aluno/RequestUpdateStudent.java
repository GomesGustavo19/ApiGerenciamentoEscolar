package com.gomes.ApiGerenciamentoEscolar.domain.aluno;

import java.util.Date;

public record RequestUpdateStudent(String nome, Date dataNascimento, String cpf) { }
