package com.gomes.ApiGerenciamentoEscolar.services;

import com.gomes.ApiGerenciamentoEscolar.domain.assessment.RequestCreateStudentAssessmentDTO;
import com.gomes.ApiGerenciamentoEscolar.domain.assessment.RequestUpdateStudentAssessmentDTO;
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
    public ResponseEntity<StudentAssessment> update(RequestUpdateStudentAssessmentDTO requestUpdateStudentAssessmentDTO){

        Optional<StudentAssessment> optionalStudentAssessment = studentAssessmentRepository.findById(requestUpdateStudentAssessmentDTO.id());
        if (optionalStudentAssessment.isEmpty())
            throw new RuntimeException("Student Assessment not found");

        Optional<Student> optionalStudent = studentRepository.findByCpf(requestUpdateStudentAssessmentDTO.documentStudent());
        if (optionalStudent.isEmpty())
            throw new PersonNotExistException("Student with " + requestUpdateStudentAssessmentDTO.documentStudent() + " not exist");

        Optional<ClassRoom> optionalClassRoom = classRoomRepository.findById(requestUpdateStudentAssessmentDTO.classroom());
        if (optionalClassRoom.isEmpty())
            throw new RuntimeException("Classroom not found");

        var calculateFinalGrade = calculateFinalGrade(requestUpdateStudentAssessmentDTO.gradeFirst(),
                requestUpdateStudentAssessmentDTO.gradeSecond(), requestUpdateStudentAssessmentDTO.gradeThird());

        var updateStudentAssessment = optionalStudentAssessment.get();
        updateStudentAssessment.setClassroom(optionalClassRoom.get());
        updateStudentAssessment.setStudent(optionalStudent.get());
        updateStudentAssessment.setGradeFirst(requestUpdateStudentAssessmentDTO.gradeFirst());
        updateStudentAssessment.setGradeSecond(requestUpdateStudentAssessmentDTO.gradeSecond());
        updateStudentAssessment.setGradeThird(requestUpdateStudentAssessmentDTO.gradeThird());
        updateStudentAssessment.setFinalGrade(calculateFinalGrade);
        updateStudentAssessment.setAbsences(requestUpdateStudentAssessmentDTO.absences());
        updateStudentAssessment.setAcademicYear(requestUpdateStudentAssessmentDTO.academicYear());

        studentAssessmentRepository.save(updateStudentAssessment);

        return ResponseEntity.ok(updateStudentAssessment);

    }

}