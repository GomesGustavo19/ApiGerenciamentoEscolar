package com.gomes.ApiGerenciamentoEscolar.domain.student;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idStudent")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_student", length = 100)
    private String idStudent;
    @Column(name = "name" , length = 70)
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "datebirth")
    private String dateBirth;
    @CPF
    @Column(name = "cpf" , length = 11)
    private String cpf;
    @Version
    private Long version;


    public Student(String name, String dateBirth, String cpf) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.cpf = cpf;
    }

}
