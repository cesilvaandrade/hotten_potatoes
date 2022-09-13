package com.example.bd_unb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Critico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String publicacoes;

    private String bibliografia;

    private String nome;

    @Temporal(TemporalType.DATE)
    private Date aniversario;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AVALIACAO" , referencedColumnName = "ID")
    private AvaliacaoCritica avaliacao;

}
