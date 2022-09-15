package com.example.bd_unb.services;

import com.example.bd_unb.domain.Filme;
import com.example.bd_unb.repositories.FilmeRepository;
import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    DiretorService diretorService;

    @Autowired
    EstudioService estudioService;

    public Filme insert(Filme obj) {
        Filme newObj = Filme.builder()
                .anoEstreia(obj.getAnoEstreia())
                .bilheteria(obj.getBilheteria())
                .classificao(obj.getClassificao())
                .duracao(obj.getDuracao())
                .paisDeOrigem(obj.getPaisDeOrigem())
                .titulo(obj.getTitulo())
                .sinopse(obj.getSinopse())
                .diretor(diretorService.findById(obj.getDiretor().getId()))
                .estudio(estudioService.findById(obj.getEstudio().getId()))
                .build();
        return repository.save(newObj);
    }

    public List<Filme> findAll() {
        return repository.findAll();
    }

    public Filme findById(Integer id) {
        Optional<Filme> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
                "Object not found! Id: " + id + ", Type: " + Filme.class.getName()));
    }

//    public List<Filme> findByFilmes(Integer id) {
//        return repository.findByFilmes(id);
//    }

    public void deleteById(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.example.bd_unb.services.exceptions.DataIntegrityViolationException("Error to delete Filme");
        }
    }

    public Filme update(Integer id, Filme obj) {
        obj.setId(id);
        Filme newObj = Filme.builder()
                .id(id)
                .anoEstreia(obj.getAnoEstreia())
                .bilheteria(obj.getBilheteria())
                .classificao(obj.getClassificao())
                .duracao(obj.getDuracao())
                .paisDeOrigem(obj.getPaisDeOrigem())
                .titulo(obj.getTitulo())
                .sinopse(obj.getSinopse())
                .build();
        return repository.save(newObj);
    }
    
}
