package com.example.bd_unb.repositories;

import com.example.bd_unb.domain.AvaliacaoCritica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoCriticaRepository extends JpaRepository<AvaliacaoCritica, Integer> {
}
