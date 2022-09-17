package com.example.bd_unb.resources;

import com.example.bd_unb.domain.Critico;
import com.example.bd_unb.services.CriticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/critico")
@CrossOrigin("*")
public class CriticoResource {
    @Autowired
    private CriticoService service;

    @PostMapping(value = "")
    public ResponseEntity<Critico> insert(@Valid @RequestBody Critico obj ) {
        Critico newObj = service.insert( obj );
        return ResponseEntity.ok().body(newObj);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Critico> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Critico> updatePost(@PathVariable Integer id, @RequestBody Critico obj) {
        return ResponseEntity.ok().body(service.update(id, obj));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Critico>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

}

