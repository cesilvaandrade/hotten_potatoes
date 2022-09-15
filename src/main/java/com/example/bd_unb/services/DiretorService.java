package com.example.bd_unb.services;

import com.example.bd_unb.domain.Diretor;
import com.example.bd_unb.repositories.DiretorRepository;
import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;


    public Diretor insert(Diretor obj) {
        Diretor newObj = Diretor.builder()
                .naturalidade(obj.getNaturalidade())
                .aniversario(obj.getAniversario())
                .nome(obj.getNome())
                .build();
        return repository.save(newObj);
    }

    public List<Diretor> findAll() {
        return repository.findAll();
    }

    public Diretor findById(Integer id) {
        Optional<Diretor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
                "Object not found! Id: " + id + ", Type: " + Diretor.class.getName()));
    }

//    public List<Diretor> findByFilmes(Integer id) {
//        return repository.findByFilmes(id);
//    }

    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.example.bd_unb.services.exceptions.DataIntegrityViolationException("Error to delete Diretor");
        }
    }

    public Diretor update(Integer id, Diretor obj) {
        obj.setId(id);
        Diretor newObj = Diretor.builder()
                .id(id)
                .naturalidade(obj.getNaturalidade())
                .aniversario(obj.getAniversario())
                .nome(obj.getNome())
                .build();
        return repository.save(newObj);
    }
    
}
