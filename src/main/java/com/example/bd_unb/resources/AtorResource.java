package com.example.bd_unb.resources;


import com.example.bd_unb.domain.Ator;
import com.example.bd_unb.services.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/ator")
@CrossOrigin("*")
public class AtorResource {

    @Autowired
    private AtorService service;

    @PostMapping(value = "")
    public ResponseEntity<Ator> insert( @Valid @RequestBody Ator obj) {
        Ator newObj = service.insert( obj);
        return ResponseEntity.ok().body(newObj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Ator>> findAll(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findByFilmes(id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Ator> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Ator> updatePost(@PathVariable Integer id, @RequestBody Ator obj) {
        return ResponseEntity.ok().body(service.update(id, obj));
    }
    
}
