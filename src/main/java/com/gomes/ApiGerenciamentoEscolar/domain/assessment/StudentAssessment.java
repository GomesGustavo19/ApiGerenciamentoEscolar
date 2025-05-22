package com.gomes.ApiGerenciamentoEscolar.domain.assessment;

import com.gomes.ApiGerenciamentoEscolar.domain.classroom.ClassRoom;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import com.gomes.ApiGerenciamentoEscolar.domain.student.Student;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_assessment")
@Getter
@Setter
@EqualsAndHashCode(of = "idStudentAssement")
public class StudentAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idStudentAssement;

    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private ClassRoom fkClassroom;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student fkStudent;

    @ManyToOne
    @JoinColumn(name = "id_matter")
    private Matter fkMatter;

    @Column(name = "grade_first")
    private Double grandeFirst;

    @Column(name = "grade_second")
    private Double grandeSecond;

    @Column(name = "grade_third")
    private Double grandeThird;

    @Column(name = "absences")
    private Integer absences;

    @Column(name = "academic_year")
    private String academicYear;

    @Version
    private Long version;
}
