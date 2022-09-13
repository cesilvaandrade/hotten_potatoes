package com.example.bd_unb.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@NamedQueries({
})
public class Seriado {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String paisDeOrigem;

    private String sinopse;

    private String titulo;

    private Integer anoEstreia;

    private String classificao;

    private Integer temporadas;

}
