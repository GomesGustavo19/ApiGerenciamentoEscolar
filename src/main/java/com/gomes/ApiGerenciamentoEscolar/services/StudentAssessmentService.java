package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.assessment.RequestCreateStudentAssessmentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.assessment.RequestUpdateStudentAssessment;
import com.gomes.ApiGerenciamentoEscolar.domain.assessment.StudentAssessment;
import com.gomes.ApiGerenciamentoEscolar.domain.classroom.ClassRoom;
import com.gomes.ApiGerenciamentoEscolar.domain.student.Student;
import com.gomes.ApiGerenciamentoEscolar.exception.PersonNotExistException;
import com.gomes.ApiGerenciamentoEscolar.repository.ClassRoomRepository;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentAssessmentRepository;
import com.gomes.ApiGerenciamentoEscolar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentAssessmentService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentAssessmentRepository studentAssessmentRepository;

    @Transactional
    public ResponseEntity<StudentAssessment> create(RequestCreateStudentAssessmentDTO requestCreateStudentAssessment){

        Optional<ClassRoom> optionalClassRoom = classRoomRepository.findById(requestCreateStudentAssessment.classroom());
        if (optionalClassRoom.isEmpty())
            throw new RuntimeException("Classroom not Exist");

        Optional<Student> optionalStudent = studentRepository.findByCpf(requestCreateStudentAssessment.studentDocument());
        if (optionalStudent.isEmpty())
            throw new PersonNotExistException("Student not exist, Please insert student document valid");

        StudentAssessment saveStudentAssessment = new StudentAssessment(optionalClassRoom.get(),optionalStudent.get());

        studentAssessmentRepository.save(saveStudentAssessment);

        return ResponseEntity.ok().build();

    }

    public static Double calculateFinalGrade(Double gradeFirst, Double gradeSecond, Double gradeThird){

        var sumGrade = gradeFirst + gradeSecond + gradeThird;
        var gradeFinal = sumGrade / 3;

        return gradeFinal;
    }

    @Transactional
    public ResponseEntity<StudentAssessment> update(RequestUpdateStudentAssessment requestUpdateStudentAssessment){

        Optional<StudentAssessment> optionalStudentAssessment = studentAssessmentRepository.findById(requestUpdateStudentAssessment.id());
        if (optionalStudentAssessment.isEmpty())
            throw new RuntimeException("Student Assessment not found");

        Optional<Student> optionalStudent = studentRepository.findByCpf(requestUpdateStudentAssessment.documentStudent());
        if (optionalStudent.isEmpty())
            throw new PersonNotExistException("Student with " + requestUpdateStudentAssessment.documentStudent() + " not exist");

        Optional<ClassRoom> optionalClassRoom = classRoomRepository.findById(requestUpdateStudentAssessment.classroom());
        if (optionalClassRoom.isEmpty())
            throw new RuntimeException("Classroom not found");

        var calculateFinalGrade = calculateFinalGrade(requestUpdateStudentAssessment.gradeFirst(),
                requestUpdateStudentAssessment.gradeSecond(), requestUpdateStudentAssessment.gradeThird());

        var updateStudentAssessment = optionalStudentAssessment.get();
        updateStudentAssessment.setClassroom(optionalClassRoom.get());
        updateStudentAssessment.setStudent(optionalStudent.get());
        updateStudentAssessment.setGradeFirst(requestUpdateStudentAssessment.gradeFirst());
        updateStudentAssessment.setGradeSecond(requestUpdateStudentAssessment.gradeSecond());
        updateStudentAssessment.setGradeThird(requestUpdateStudentAssessment.gradeThird());
        updateStudentAssessment.setFinalGrade(calculateFinalGrade);
        updateStudentAssessment.setAbsences(requestUpdateStudentAssessment.absences());
        updateStudentAssessment.setAcademicYear(requestUpdateStudentAssessment.academicYear());

        studentAssessmentRepository.save(updateStudentAssessment);

        return ResponseEntity.ok(updateStudentAssessment);

    }

}