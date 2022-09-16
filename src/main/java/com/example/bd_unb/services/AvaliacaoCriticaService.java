package com.example.bd_unb.services;

import com.example.bd_unb.domain.AvaliacaoCritica;
import com.example.bd_unb.repositories.AvaliacaoCriticaRepository;
import com.example.bd_unb.repositories.CriticoRepository;
import com.example.bd_unb.repositories.FilmeRepository;
import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoCriticaService {


    @Autowired
    private AvaliacaoCriticaRepository repository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CriticoRepository criticoRepository;


    public AvaliacaoCritica insert(AvaliacaoCritica obj, Integer idFilme) {

        AvaliacaoCritica newObj = AvaliacaoCritica.builder()
                .descricao(obj.getDescricao())
                .nota(obj.getNota())
                .filme(filmeRepository.findById(idFilme).orElse(null))
                .critico(obj.getCritico() == null ? null : criticoRepository.findById(obj.getCritico().getId()).orElse(null))
                .build();
        return repository.save(newObj);
    }

    public List<AvaliacaoCritica> findAll() {
        return repository.findAll();
    }

    public AvaliacaoCritica findById(Integer id) {
        Optional<AvaliacaoCritica> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
                "Object not found! Id: " + id + ", Type: " + AvaliacaoCritica.class.getName()));
    }

//    public List<AvaliacaoCritica> findByFilmes(Integer id) {
//        return repository.findByFilmes(id);
//    }

    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.example.bd_unb.services.exceptions.DataIntegrityViolationException("Error to delete AvaliacaoCritica");
        }
    }

    public AvaliacaoCritica update(Integer id, AvaliacaoCritica obj) {
        AvaliacaoCritica avaliacaoCritica = repository.findById(id).orElse(null);
        AvaliacaoCritica newObj = AvaliacaoCritica.builder()
                .id(id)
                .descricao(obj.getDescricao())
                .nota(obj.getNota())
                .filme(avaliacaoCritica.getFilme())
                .critico(avaliacaoCritica.getCritico())
                .build();
        return repository.save(newObj);
    }
    
}
