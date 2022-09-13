package com.example.bd_unb.repositories;



import com.example.bd_unb.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {

   List<Ator> findByFilmes(Integer id);



}
