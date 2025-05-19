package com.gomes.ApiGerenciamentoEscolar.domain.matter;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "matter")
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_matter", unique = true)
    private UUID idMatter;

    @Column(name = "name", length = 50)
    private String name;

    public Matter() {
    }

    public Matter(String name, UUID idMatter) {
        this.name = name;
        this.idMatter = idMatter;
    }

    public UUID getIdMatter() {
        return idMatter;
    }

    public void setIdMatter(UUID idMatter) {
        this.idMatter = idMatter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Matter matter = (Matter) o;
        return Objects.equals(idMatter, matter.idMatter);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idMatter);
    }
}
