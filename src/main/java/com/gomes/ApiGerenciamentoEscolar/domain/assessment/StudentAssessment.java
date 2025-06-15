package com.gomes.ApiGerenciamentoEscolar.domain.assessment;

import com.gomes.ApiGerenciamentoEscolar.domain.classroom.ClassRoom;
import com.gomes.ApiGerenciamentoEscolar.domain.student.Student;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_assessment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idStudentAssessment")
public class StudentAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String idStudentAssessment;

    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private ClassRoom classroom;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @Column(name = "grade_first")
    private Double gradeFirst;

    @Column(name = "grade_second")
    private Double gradeSecond;

    @Column(name = "grade_third")
    private Double gradeThird;

    @Column(name= "final_grade")
    private Double finalGrade;

    @Column(name = "absences")
    private Integer absences;

    @Column(name = "academic_year")
    private String academicYear;

    @Version
    private Long version;

    public StudentAssessment(ClassRoom classroom, Student student, Double gradeFirst, Double gradeSecond,
                             Double gradeThird, Double finalGrade, Integer absences, String academicYear) {
        this.classroom = classroom;
        this.student = student;
        this.gradeFirst = gradeFirst;
        this.gradeSecond = gradeSecond;
        this.gradeThird = gradeThird;
        this.finalGrade = finalGrade;
        this.absences = absences;
        this.academicYear = academicYear;
    }

    public StudentAssessment(ClassRoom classroom, Student student) {
        this.classroom = classroom;
        this.student = student;
    }
}
