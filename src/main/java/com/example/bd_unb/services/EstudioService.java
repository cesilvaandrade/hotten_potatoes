package com.example.bd_unb.services;

import com.example.bd_unb.domain.Estudio;
import com.example.bd_unb.repositories.EstudioRepository;
import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository repository;


    public Estudio insert(Estudio obj) {
        Estudio newObj = Estudio.builder()
                .anoFundacao(obj.getAnoFundacao())
                .nome(obj.getNome())
                .pais(obj.getPais())
                .presidente(obj.getPresidente())
                .build();
        return repository.save(newObj);
    }

    public List<Estudio> findAll() {
        return repository.findAll();
    }

    public Estudio findById(Integer id) {
        Optional<Estudio> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
                "Object not found! Id: " + id + ", Type: " + Estudio.class.getName()));
    }

//    public List<Estudio> findByFilmes(Integer id) {
//        return repository.findByFilmes(id);
//    }

    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.example.bd_unb.services.exceptions.DataIntegrityViolationException("Error to delete Estudio");
        }
    }

    public Estudio update(Integer id, Estudio obj) {
        obj.setId(id);
        Estudio newObj = Estudio.builder()
                .id(id)
                .anoFundacao(obj.getAnoFundacao())
                .nome(obj.getNome())
                .pais(obj.getPais())
                .presidente(obj.getPresidente())
                .build();
        return repository.save(newObj);
    }
    
}
