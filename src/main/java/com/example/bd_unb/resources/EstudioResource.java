package com.example.bd_unb.resources;

import com.example.bd_unb.domain.Estudio;
import com.example.bd_unb.services.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/estudio")
@CrossOrigin("*")
public class EstudioResource {

    @Autowired
    private EstudioService service;

    @PostMapping(value = "")
    public ResponseEntity<Estudio> insert(@Valid @RequestBody Estudio obj) {
        Estudio newObj = service.insert( obj);
        return ResponseEntity.ok().body(newObj);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Estudio> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Estudio> updatePost(@PathVariable Integer id, @RequestBody Estudio obj) {
        return ResponseEntity.ok().body(service.update(id, obj));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Estudio>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }


}
