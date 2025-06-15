package com.gomes.ApiGerenciamentoEscolar.domain.classroom;

import com.gomes.ApiGerenciamentoEscolar.domain.teacher.Teacher;
import jakarta.persistence.*;
import lombok.*;

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
    private Teacher teacher;

    @Column(name = "class_description")
    private String classDescription;

    @Version
    private Long version;

    public ClassRoom(Teacher teacher, String classDescription) {
        this.teacher = teacher;
        this.classDescription = classDescription;
    }
}
