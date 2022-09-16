package com.example.bd_unb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Critico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String bibliografia;

    private String nome;

    @Temporal(TemporalType.DATE)
    private Date aniversario;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "critico")
    private AvaliacaoCritica avaliacao;

}
