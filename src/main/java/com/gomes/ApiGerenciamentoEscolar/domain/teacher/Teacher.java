package com.gomes.ApiGerenciamentoEscolar.domain.teacher;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idTeacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_teacher", length = 100)
    private String idTeacher;
    @Column(name = "name", length = 70)
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "datebirth")
    private String dateBirth;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "registerteacher", length = 5)
    private String registerTeacher;
    @ManyToOne
    @JoinColumn(name = "id_matter", referencedColumnName = "id_matter")
    private Matter matter;
    @Column(name = "materialtaught", length = 2)
    private MaterialTaught materialTaught;
    @Version
    private Long version;

    public Teacher(String name, String dateBirth, String cpf, String registerTeacher, Matter matter
            ,MaterialTaught materialTaught) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.cpf = cpf;
        this.registerTeacher = registerTeacher;
        this.matter = matter;
        this.materialTaught = materialTaught;
    }
}
