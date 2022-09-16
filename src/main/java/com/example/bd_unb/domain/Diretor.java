package com.example.bd_unb.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Diretor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String naturalidade;

    @Temporal(TemporalType.DATE)
    private Date aniversario;

    @JsonIgnore
    @OneToMany(mappedBy = "diretor" , cascade = CascadeType.ALL)
    private List<Filme> filmes= new ArrayList<>();

}
