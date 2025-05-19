package com.gomes.ApiGerenciamentoEscolar.domain.student;

import java.util.UUID;

public record RequestUpdateStudent(String id_student, String name, String cpf, String dateBirth) {

    public RequestUpdateStudent (Student update){
        this(update.getIdStudent(), update.getName(), update.getCpf(),update.getDateBirth());
    }
}
