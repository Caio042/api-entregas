package com.caiolima.apientrega.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    private Long id;

    @NotBlank
    @Column
    @Size (max = 50)
    private String nome;

    @NotBlank
    @Column
    @Email
    @Size (max = 255)
    private String email;

    @NotBlank
    @Column
    @Size (max = 14)
    private String telefone;
}
