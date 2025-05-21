package com.gomes.ApiGerenciamentoEscolar.domain.teacher;

import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;

public record ResponseTeacherDto(String name, String dateBirth, String cpf, String registerTeacher, Matter matter,
                                 MaterialTaught materialTaught) {


    public ResponseTeacherDto(Teacher teacher) {
        this(teacher.getName(),teacher.getDateBirth(), teacher.getCpf(), teacher.getRegisterTeacher(),
                teacher.getMatter(), teacher.getMaterialTaught());
    }
}
