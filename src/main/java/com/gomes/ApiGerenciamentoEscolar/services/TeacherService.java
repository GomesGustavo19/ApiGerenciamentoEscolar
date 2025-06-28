package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import com.gomes.ApiGerenciamentoEscolar.domain.teacher.*;
import com.gomes.ApiGerenciamentoEscolar.exception.PersonExistException;
import com.gomes.ApiGerenciamentoEscolar.exception.PersonNotExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.MatterRepository;
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

    @Autowired
    private MatterRepository matterRepository;

    @Transactional
    public Teacher create(RequestCreateTeacher requestCreateTeacher){

        Optional<Teacher> existingTeacher = teacherRepository.findByCpf(requestCreateTeacher.cpf());

        if (existingTeacher.isPresent()){
            throw new PersonExistException("Teacher with " + requestCreateTeacher.cpf()
                    + " already registered");
        }

        Optional<Matter> optionalMatter = matterRepository.findById(requestCreateTeacher.matter());

        if (optionalMatter.isEmpty()){
            throw new RuntimeException("Error not found matter");
        }

        Teacher data = new Teacher(requestCreateTeacher.name(),requestCreateTeacher.dateBirth(),
                requestCreateTeacher.cpf(), requestCreateTeacher.registerTeacher(), optionalMatter.get()
        ,requestCreateTeacher.materialTaught());

        teacherRepository.save(data);

        return data;
    }

    public Teacher findByTeacher(RequestFindByTeacher requestFindByTeacher){

        Optional<Teacher> optionalTeacher = teacherRepository.findByCpf(requestFindByTeacher.cpf());

        if (optionalTeacher.isEmpty()){
            throw new PersonNotExistException("Teacher with " + requestFindByTeacher.cpf()
                    + " not found");
        }

        var teacher = optionalTeacher.get();

        return teacher;

    }

    @Transactional
    public Teacher update(RequestUpdateTeacher requestUpdateTeacher){

        Optional<Teacher> optionalTeacher = teacherRepository.findById(requestUpdateTeacher.id());

        if (optionalTeacher.isEmpty()){
            throw new PersonNotExistException("Teacher with " + requestUpdateTeacher.cpf()
                                                + " not found");
        }

        Optional<Matter> optionalMatter = matterRepository.findById(requestUpdateTeacher.matter());

        if (optionalMatter.isEmpty()){
            throw new RuntimeException("Error not found matter");
        }

        Teacher teacher = optionalTeacher.get();
        teacher.setName(requestUpdateTeacher.name());
        teacher.setDateBirth(requestUpdateTeacher.dateBirth());
        teacher.setCpf(requestUpdateTeacher.cpf());
        teacher.setRegisterTeacher(requestUpdateTeacher.registerTeacher());
        teacher.setMatter(optionalMatter.get());
        teacher.setMaterialTaught(requestUpdateTeacher.materialTaught());

        teacherRepository.save(teacher);

        return teacher;

    }

    public ResponseEntity<Teacher> delete(RequestDeleteTeacher requestDeleteTeacher){

        teacherRepository.deleteById(requestDeleteTeacher.id());

        return ResponseEntity.ok().build();

    }



}