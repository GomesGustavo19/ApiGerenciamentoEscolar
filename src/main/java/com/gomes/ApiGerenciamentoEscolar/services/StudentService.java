package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.assessment.StudentAssessment;
import com.gomes.ApiGerenciamentoEscolar.domain.student.*;
import com.gomes.ApiGerenciamentoEscolar.exception.PersonExistException;
import com.gomes.ApiGerenciamentoEscolar.exception.PersonNotExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public Student create(RequestCreateStudentDTO requestCreateStudentDTO) {

        if (studentRepository.findByCpf(requestCreateStudentDTO.cpf()).isPresent()) {
            throw new PersonExistException("Student with " + requestCreateStudentDTO.cpf() + " already registered ");
        }

        Student newStudent = new Student(requestCreateStudentDTO.name(), requestCreateStudentDTO.dateBirth(), requestCreateStudentDTO.cpf());

        studentRepository.save(newStudent);

        return newStudent;


    }

    public Student findByStudent(RequestFinByStudentDTO requestFinByStudentDTO) {

        Student studentFound = studentRepository.findByCpf(requestFinByStudentDTO.cpf())
                .orElseThrow(() -> new PersonNotExistException("Student with " + requestFinByStudentDTO.cpf() + " not found"));

        return studentFound;

    }

    @Transactional
    public Student update(RequestUpdateStudent requestUpdateStudent) {


        Optional<Student> existingStudent = studentRepository.findById(requestUpdateStudent.id_student());

        if (existingStudent.isPresent()) {

            Student studentFound = existingStudent.get();

            studentFound.setName(requestUpdateStudent.name());
            studentFound.setCpf(requestUpdateStudent.cpf());
            studentFound.setDateBirth(requestUpdateStudent.dateBirth());

            studentRepository.save(studentFound);

            return studentFound;

        } else {
            throw new PersonNotExistException("Student with " + requestUpdateStudent.id_student() + " not found");
        }

    }

    public List<StudentAssessment> assessments(String idStudent){
        var student = studentRepository.findById(idStudent);
        var assessment = student.get().getAssessments();

        return assessment;
    }

}