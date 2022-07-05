package com.example.comptabilite.repository;

import com.example.comptabilite.models.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface ProduitRepository extends CrudRepository<Produits,Long> {
}
