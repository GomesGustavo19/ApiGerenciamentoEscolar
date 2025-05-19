package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.teacher.RequestCreateTeacher;
import com.gomes.ApiGerenciamentoEscolar.domain.teacher.Teacher;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public ResponseEntity<Teacher> create(RequestCreateTeacher requestCreateTeacher){
        Optional<Teacher> existing = teacherRepository.findByCpf(requestCreateTeacher.cpf());

        if (existing.isPresent()){
            throw new StudentExistException("Teacher with " + requestCreateTeacher.cpf()
                    + " already registered");
        }

        Teacher data = new Teacher(requestCreateTeacher.name(),requestCreateTeacher.dateBirth(),
                requestCreateTeacher.cpf(), requestCreateTeacher.registerTeacher(), requestCreateTeacher.matter()
        ,requestCreateTeacher.materialTaught());

        teacherRepository.save(data);

        return ResponseEntity.ok().build();
    }

}
