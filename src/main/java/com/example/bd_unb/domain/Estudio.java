package com.example.bd_unb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String pais;

    private String presidente;

    private Integer anoFundacao;

    @OneToMany(mappedBy = "estudio")
    private List<Filme> filmes= new ArrayList<>();

}
