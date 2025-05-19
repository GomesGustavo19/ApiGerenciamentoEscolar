package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.student.RequestCreateStudentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.student.RequestFinByStudentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.student.RequestUpdateStudent;
import com.gomes.ApiGerenciamentoEscolar.domain.student.Student;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentExistException;
import com.gomes.ApiGerenciamentoEscolar.exception.StudentNotExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<Student> createStudent(RequestCreateStudentDTO requestCreateStudentDTO) {

        if (studentRepository.findByCpf(requestCreateStudentDTO.cpf()).isPresent()) {
            throw new StudentExistException("Student with " + requestCreateStudentDTO.cpf() + " already registered ");
        }

        Student newStudent = new Student(requestCreateStudentDTO.name(), requestCreateStudentDTO.dateBirth(), requestCreateStudentDTO.cpf());

        studentRepository.save(newStudent);

        return ResponseEntity.status(HttpStatus.CREATED).build();


    }

    public ResponseEntity<Student> findByStudent(RequestFinByStudentDTO requestFinByStudentDTO) {

        Student studentFound = studentRepository.findByCpf(requestFinByStudentDTO.cpf())
                .orElseThrow(() -> new StudentNotExistException("Student with " + requestFinByStudentDTO.cpf() + " not found"));

        return ResponseEntity.ok(studentFound);

    }

    @Transactional
    public ResponseEntity<Student> updateStudent(RequestUpdateStudent requestUpdateStudent) {


        Optional<Student> existingStudent = studentRepository.findById(requestUpdateStudent.id_student());

        if (existingStudent.isPresent()) {

            Student studentFound = existingStudent.get();

            studentFound.setName(requestUpdateStudent.name());
            studentFound.setCpf(requestUpdateStudent.cpf());
            studentFound.setDateBirth(requestUpdateStudent.dateBirth());

            studentRepository.save(studentFound);

            return ResponseEntity.ok(studentFound);

        } else {
            throw new StudentNotExistException("Student with " + requestUpdateStudent.id_student() + " not found");
        }

    }

}