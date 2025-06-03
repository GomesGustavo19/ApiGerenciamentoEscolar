package com.gomes.ApiGerenciamentoEscolar.domain.assessment;

import com.gomes.ApiGerenciamentoEscolar.domain.classroom.ClassRoom;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
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
    private String idStudentAssessment;

    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private ClassRoom fkClassroom;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student fkStudent;

    @Column(name = "grade_first")
    private Double grandeFirst;

    @Column(name = "grade_second")
    private Double grandeSecond;

    @Column(name = "grade_third")
    private Double grandeThird;

    @Column(name= "final_grade")
    private Double finalGrade;

    @Column(name = "absences")
    private Integer absences;

    @Column(name = "academic_year")
    private String academicYear;

    @Version
    private Long version;

    public StudentAssessment(ClassRoom fkClassroom, Student fkStudent, Double grandeFirst, Double grandeSecond,
                             Double grandeThird, Double finalGrade, Integer absences, String academicYear) {
        this.fkClassroom = fkClassroom;
        this.fkStudent = fkStudent;
        this.grandeFirst = grandeFirst;
        this.grandeSecond = grandeSecond;
        this.grandeThird = grandeThird;
        this.finalGrade = finalGrade;
        this.absences = absences;
        this.academicYear = academicYear;
    }
}
