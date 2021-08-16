package com.caiolima.apientrega.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table (name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Cliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String telefone;
}
