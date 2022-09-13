package com.example.bd_unb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Date aniversario;

    private BigDecimal altura;

    private String naturalidade;

    private String biografia;

    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "ATOR_FILME", joinColumns = @JoinColumn(name = "ID_AUTHOR"), inverseJoinColumns = @JoinColumn(name = "ID_ATOR"))
    private List<Filme> filmes = new ArrayList<>();

}
