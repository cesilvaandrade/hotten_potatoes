package com.example.bd_unb.services;

import com.example.bd_unb.domain.Ator;
import com.example.bd_unb.domain.Filme;
import com.example.bd_unb.repositories.AtorRepository;
import com.example.bd_unb.repositories.FilmeRepository;
import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

    @Autowired
    private FilmeRepository filmeRepository;

    public Ator insert( Ator obj , Integer idFilme) {

        Filme filme = filmeRepository.findById(idFilme).orElse(null);


        Ator newObj = Ator.builder()
                .altura(obj.getAltura())
                .aniversario(obj.getAniversario())
                .biografia(obj.getBiografia())
                .naturalidade(obj.getNaturalidade())
                .nome(obj.getNome())
                .biografia(obj.getBiografia())
                .filmes(new ArrayList<>())
                .build();

        newObj.getFilmes().add(filme);
        Ator ator = repository.save(newObj);

        return ator;

    }

    public List<Ator> findAll() {
        return repository.findAll();
    }

    public Ator findById(Integer id) {
        Optional<Ator> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
                "Object not found! Id: " + id + ", Type: " + Ator.class.getName()));
    }

//    public List<Ator> findByFilmes(Integer id) {
//        return repository.findByFilme(id);
//    }

    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.example.bd_unb.services.exceptions.DataIntegrityViolationException("Error to delete Ator");
        }
    }

    public Ator update(Integer id, Ator obj) {
        obj.setId(id);
        Ator newObj = Ator.builder()
                .id(id)
                .altura(obj.getAltura())
                .aniversario(obj.getAniversario())
                .biografia(obj.getBiografia())
                .naturalidade(obj.getNaturalidade())
                .nome(obj.getNome())
                .biografia(obj.getBiografia())
                .build();
        return repository.save(newObj);
    }
    
}
