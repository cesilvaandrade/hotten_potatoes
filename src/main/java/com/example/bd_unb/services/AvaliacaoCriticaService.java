package com.example.bd_unb.services;

import com.example.bd_unb.domain.AvaliacaoCritica;
import com.example.bd_unb.repositories.AvaliacaoCriticaRepository;
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


    public AvaliacaoCritica insert(AvaliacaoCritica obj) {
        AvaliacaoCritica newObj = AvaliacaoCritica.builder()
                .descricao(obj.getDescricao())
                .nota(obj.getNota())
                .revista(obj.getRevista())
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
        obj.setId(id);
        AvaliacaoCritica newObj = AvaliacaoCritica.builder()
                .id(id)
                .descricao(obj.getDescricao())
                .nota(obj.getNota())
                .revista(obj.getRevista())
                .build();
        return repository.save(newObj);
    }
    
}
