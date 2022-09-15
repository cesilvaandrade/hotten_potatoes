package com.example.bd_unb.services;

import com.example.bd_unb.domain.Critico;
import com.example.bd_unb.repositories.CriticoRepository;
import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriticoService {

    @Autowired
    private CriticoRepository repository;


    public Critico insert(Critico obj) {
        Critico newObj = Critico.builder()
                .nome(obj.getNome())
                .aniversario(obj.getAniversario())
                .avaliacao(obj.getAvaliacao())
                .bibliografia(obj.getBibliografia())
                .publicacoes(obj.getPublicacoes())
                .build();
        return repository.save(newObj);
    }

    public List<Critico> findAll() {
        return repository.findAll();
    }

    public Critico findById(Integer id) {
        Optional<Critico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
                "Object not found! Id: " + id + ", Type: " + Critico.class.getName()));
    }

//    public List<Critico> findByFilmes(Integer id) {
//        return repository.findByFilmes(id);
//    }

    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.example.bd_unb.services.exceptions.DataIntegrityViolationException("Error to delete Critico");
        }
    }

    public Critico update(Integer id, Critico obj) {
        obj.setId(id);
        Critico newObj = Critico.builder()
                .id(id)
                .nome(obj.getNome())
                .aniversario(obj.getAniversario())
                .avaliacao(obj.getAvaliacao())
                .bibliografia(obj.getBibliografia())
                .publicacoes(obj.getPublicacoes())
                .build();
        return repository.save(newObj);
    }
    
}
