package com.example.comptabilite.repository;

import com.example.comptabilite.models.Recettes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecetteRepository extends CrudRepository<Recettes,Long> {
}
