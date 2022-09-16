package com.example.bd_unb.domain;

import io.swagger.models.auth.In;
import lombok.*;
import org.hibernate.annotations.Cascade;

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

    @Column(name = "pais_de_origem")
    private String paisDeOrigem;

    private String sinopse;

    private String titulo;

    @Column(name = "ano_estreia")
    private Integer anoEstreia;

    private String classificacao;

    private Integer duracao;

    private String bilheteria;

    @ManyToOne()
    @JoinColumn(name="id_diretor", nullable=false)
    private Diretor diretor ;

    @OneToMany(mappedBy = "filme" , cascade = CascadeType.ALL)
    private List<AvaliacaoCritica> avaliacoesCriticas = new ArrayList<>();


    @ManyToMany(mappedBy = "filmes", cascade = CascadeType.ALL)
    private List<Ator> atores = new ArrayList();

    @ManyToOne()
    @JoinColumn(name="id_estudio", nullable=false)
    private Estudio estudio;


}
