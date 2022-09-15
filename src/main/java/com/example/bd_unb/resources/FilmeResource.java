package com.example.bd_unb.resources;

import com.example.bd_unb.domain.Filme;
import com.example.bd_unb.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/filme")
@CrossOrigin("*")
public class FilmeResource {

    @Autowired
    private FilmeService service;

    @PostMapping(value = "")
    public ResponseEntity<Filme> insert(@Valid @RequestBody Filme obj) {
        Filme newObj = service.insert( obj);
        return ResponseEntity.ok().body(newObj);
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<List<Filme>> findByFilme(@PathVariable Integer id) {
//        return ResponseEntity.ok().body(service.findByFilmes(id));
//    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Filme> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Filme> updatePost(@PathVariable Integer id, @RequestBody Filme obj) {
        return ResponseEntity.ok().body(service.update(id, obj));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Filme>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
    
}
