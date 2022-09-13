package com.example.bd_unb.domain;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NamedQueries({
})
public class AvaliacaoCritica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String revista;

    private String descricao;

    private Integer nota;

    @OneToOne(mappedBy = "avaliacao")
    private Critico critico;

    @ManyToOne
    @JoinColumn(name="ID_FILME", nullable=false)
    private Filme filme;

}
