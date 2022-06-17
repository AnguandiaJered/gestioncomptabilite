package com.example.comptability.repository;

import com.example.comptability.models.Recettes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecetteRepository extends CrudRepository<Recettes,Long> {
}
