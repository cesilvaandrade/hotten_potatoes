package com.example.bd_unb.resources;

import com.example.bd_unb.domain.AvaliacaoCritica;
import com.example.bd_unb.services.AvaliacaoCriticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/avaliacao-critica")
@CrossOrigin("*")
public class AvaliacaoCriticaResource {
    @Autowired
    private AvaliacaoCriticaService service;

    @PostMapping(value = "/filme/{idFilme}")
    public ResponseEntity<AvaliacaoCritica> insert(@Valid @RequestBody AvaliacaoCritica obj , @PathVariable Integer idFilme) {
        AvaliacaoCritica newObj = service.insert( obj, idFilme );
        return ResponseEntity.ok().body(newObj);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoCritica> deleteById(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoCritica> updatePost(@PathVariable Integer id, @RequestBody AvaliacaoCritica obj) {
        return ResponseEntity.ok().body(service.update(id, obj));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<AvaliacaoCritica>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

}

