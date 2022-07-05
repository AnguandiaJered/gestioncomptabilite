package com.example.comptabilite.repository;

import com.example.comptabilite.models.Caisses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaisseRepository extends JpaRepository<Caisses,Long> {
}
