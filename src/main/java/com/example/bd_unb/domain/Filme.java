package com.example.bd_unb.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String paisDeOrigem;

    private String sinopse;

    private String titulo;

    private Integer anoEstreia;

    private String classificao;

    @Temporal(TemporalType.TIME)
    private Date duracao;

    private String bilheteria;

    @ManyToOne
    @JoinColumn(name="ID_DIRETOR", nullable=false)
    private Diretor diretor ;

    @OneToMany(mappedBy = "filme")
    private List<AvaliacaoCritica> avaliacaoCriticas = new ArrayList<>();

    @ManyToMany(mappedBy = "filmes")
    private List<Ator> atores = new ArrayList();

    @ManyToOne
    @JoinColumn(name="ID_ESTUDIO", nullable=false)
    private Estudio estudio;


}
