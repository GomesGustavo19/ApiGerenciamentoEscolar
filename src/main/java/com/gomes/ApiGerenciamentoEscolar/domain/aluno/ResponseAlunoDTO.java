package com.gomes.ApiGerenciamentoEscolar.domain.aluno;

import java.util.Date;

public record ResponseAlunoDTO(String nome, String cpf, Date dataNascimento) { }
