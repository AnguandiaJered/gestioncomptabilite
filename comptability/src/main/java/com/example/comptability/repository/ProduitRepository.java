package com.example.comptability.repository;

import com.example.comptability.models.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface ProduitRepository extends CrudRepository<Produits,Long> {
}
