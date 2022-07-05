package com.example.comptabilite.repository;

import com.example.comptabilite.models.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VenteRepository extends CrudRepository<Ventes,Long> {
}
