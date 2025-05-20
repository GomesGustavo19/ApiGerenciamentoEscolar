package com.gomes.ApiGerenciamentoEscolar.domain.matter;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "matter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idMatter")
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_matter", unique = true)
    private String idMatter;
    @Column(name = "name", length = 50)
    private String name;
    @Version
    private Long version;

}
