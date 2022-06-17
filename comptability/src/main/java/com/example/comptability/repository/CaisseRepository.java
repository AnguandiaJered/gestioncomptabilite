package com.example.comptability.repository;

import com.example.comptability.models.Caisses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaisseRepository extends JpaRepository<Caisses,Long> {
}
