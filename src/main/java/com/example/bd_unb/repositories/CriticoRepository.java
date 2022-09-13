package com.example.bd_unb.repositories;

import com.example.bd_unb.domain.Critico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriticoRepository extends JpaRepository<Critico, Integer> {
}
