package com.gomes.ApiGerenciamentoEscolar.domain.teacher;

import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_teacher", length = 100)
    private UUID idTeacher;
    @Column(name = "nome", length = 70)
    private String name;
    @Column(name = "datebirth")
    private Date dateBirth;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "registerteacher", length = 5)
    private String registerTeacher;
    @ManyToOne
    @JoinColumn(name = "id_matter", referencedColumnName = "id_matter")
    private Matter matter;

    @Column(name = "materialtaught", length = 2)
    private MaterialTaught materialTaught;

    public Teacher() {}

    public Teacher(String name, Date dateBirth, String cpf, String registerTeacher, Matter matter, MaterialTaught materialTaught) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.cpf = cpf;
        this.registerTeacher = registerTeacher;
        this.matter = matter;
        this.materialTaught = materialTaught;
    }

    public UUID getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(UUID idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegisterTeacher() {
        return registerTeacher;
    }

    public void setRegisterTeacher(String registerTeacher) {
        this.registerTeacher = registerTeacher;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

    public MaterialTaught getMaterialTaught() {
        return materialTaught;
    }

    public void setMaterialTaught(MaterialTaught materialTaught) {
        this.materialTaught = materialTaught;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(cpf, teacher.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
