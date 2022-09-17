package com.example.bd_unb.resources;

import com.example.bd_unb.domain.Diretor;
import com.example.bd_unb.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/diretor")
@CrossOrigin("*")
public class DiretorResource {

    @Autowired
    private DiretorService service;

    @PostMapping(value = "")
    public ResponseEntity<Diretor> insert(@Valid @RequestBody Diretor obj) {
        Diretor newObj = service.insert(obj);
        return ResponseEntity.ok().body(newObj);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Diretor> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Diretor> updatePost(@PathVariable Integer id, @RequestBody Diretor obj) {
        return ResponseEntity.ok().body(service.update(id, obj));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Diretor>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }


}
