package com.gomes.ApiGerenciamentoEscolar.domain.teacher;

import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;

public record RequestCreateTeacher(String name, String dateBirth, String cpf, String registerTeacher, Matter matter, MaterialTaught materialTaught) {
}
