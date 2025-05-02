package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.aluno.*;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentExistException;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentNotExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    public ResponseEntity createStudent(RequestCreateStudentDTO requestCreateStudentDTO) {

        if (alunoRepository.findByCpf(requestCreateStudentDTO.cpf()).isPresent()) {
            throw new StudentExistException("Student with " +  requestCreateStudentDTO.cpf() +  " already registered ");
        }

        Aluno newAluno = new Aluno(requestCreateStudentDTO.nome() ,requestCreateStudentDTO.dataNascimento()
                ,requestCreateStudentDTO.cpf());

        alunoRepository.save(newAluno);

        return ResponseEntity.status(HttpStatus.CREATED).build();


    }

    public ResponseEntity<ResponseStudentDTO> findByStudent(RequestFinByStudentDTO requestFinByStudentDTO) {

        Aluno studentFound = alunoRepository.findByCpf(requestFinByStudentDTO.cpf())
                .orElseThrow(()-> new StudentNotExistException("Student with " + requestFinByStudentDTO.cpf() + " not found"));

        ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO(studentFound.getNome(),studentFound.getCpf(),studentFound.getDatanascimento());

        return ResponseEntity.ok(responseStudentDTO);

    }

    public ResponseEntity<ResponseStudentDTO> updateStudent(RequestUpdateStudent requestUpdateStudent) {

        Aluno existingStudent = alunoRepository.findByCpf(requestUpdateStudent.cpf())
                .orElseThrow(()-> new StudentNotExistException("Student with " + requestUpdateStudent.cpf() + " not found"));

        existingStudent.setNome(requestUpdateStudent.nome());
        existingStudent.setDatanascimento(requestUpdateStudent.dataNascimento());
        existingStudent.setCpf(requestUpdateStudent.cpf());

        Aluno saveUpdateStudent = alunoRepository.save(existingStudent);

        ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO(saveUpdateStudent.getNome(),
                saveUpdateStudent.getCpf(), saveUpdateStudent.getDatanascimento());

        return ResponseEntity.ok(responseStudentDTO);

    }
}