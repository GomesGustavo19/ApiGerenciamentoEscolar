package com.gomes.ApiGerenciamentoEscolar.domain.classroom;

import com.gomes.ApiGerenciamentoEscolar.domain.student.Student;
import com.gomes.ApiGerenciamentoEscolar.domain.matter.Matter;
import com.gomes.ApiGerenciamentoEscolar.domain.teacher.Teacher;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "classroom")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_classroom")
    private UUID idClassRoom;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher fkTeacher;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student fkStudent;

    @ManyToOne
    @JoinColumn(name = "id_matter")
    private Matter fkMatter;

    @Column(name = "classDescription")
    private String classDescription;

    public ClassRoom() {}

    public ClassRoom(Teacher fkTeacher, Student fkStudent, Matter fkMatter, String classDescription) {
        this.fkTeacher = fkTeacher;
        this.fkStudent = fkStudent;
        this.fkMatter = fkMatter;
        this.classDescription = classDescription;
    }

    public UUID getIdClassRoom() {
        return idClassRoom;
    }

    public void setIdClassRoom(UUID idClassRoom) {
        this.idClassRoom = idClassRoom;
    }

    public Teacher getFkTeacher() {
        return fkTeacher;
    }

    public void setFkTeacher(Teacher fkTeacher) {
        this.fkTeacher = fkTeacher;
    }

    public Student getFkStudent() {
        return fkStudent;
    }

    public void setFkStudent(Student fkStudent) {
        this.fkStudent = fkStudent;
    }

    public Matter getFkMatter() {
        return fkMatter;
    }

    public void setMatter(Matter fkMatter) {
        this.fkMatter = fkMatter;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClassRoom classRoom = (ClassRoom) o;
        return Objects.equals(idClassRoom, classRoom.idClassRoom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idClassRoom);
    }
}
