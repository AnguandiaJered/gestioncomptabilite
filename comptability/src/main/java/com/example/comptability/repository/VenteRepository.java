package com.example.comptability.repository;

import com.example.comptability.models.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VenteRepository extends CrudRepository<Ventes,Long> {
}
