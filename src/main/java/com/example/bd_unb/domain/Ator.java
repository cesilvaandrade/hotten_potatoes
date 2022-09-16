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
@Table
public class Ator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Date aniversario;


    private String naturalidade;

    private String biografia;

    private BigDecimal altura;

    @JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ator_filme", joinColumns = @JoinColumn(name = "id_filme"), inverseJoinColumns = @JoinColumn(name = "id_ator"))
    private List<Filme> filmes = new ArrayList<>();
}
