package com.gomes.ApiGerenciamentoEscolar.domain.classroom;

import com.gomes.ApiGerenciamentoEscolar.domain.assessment.StudentAssessment;
import com.gomes.ApiGerenciamentoEscolar.domain.teacher.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "classroom")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idClassRoom")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_classroom")
    private String idClassRoom;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher fkTeacher;

    @OneToMany(mappedBy = "fkClassroom", cascade = CascadeType.ALL)
    private List<StudentAssessment> assessments;

    @Column(name = "classDescription")
    private String classDescription;

    @Version
    private Long version;

    public ClassRoom(Teacher fkTeacher, String classDescription) {
        this.fkTeacher = fkTeacher;
        this.classDescription = classDescription;
    }
}
