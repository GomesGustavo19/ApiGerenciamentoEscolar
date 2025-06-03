package com.gomes.ApiGerenciamentoEscolar.domain.classroom;

import com.gomes.ApiGerenciamentoEscolar.domain.teacher.MaterialTaught;

public record ResponseUpdateClassroomDTO(String nameTeacher, String registerTeacher, String matter
                                    , MaterialTaught materialTaught, String classdescription) {
}
