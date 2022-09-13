package com.example.bd_unb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Diretor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String naturalidade;

    @Temporal(TemporalType.DATE)
    private Date aniversario;

    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmes= new ArrayList<>();

}
