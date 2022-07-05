package com.example.comptabilite.repository;

import com.example.comptabilite.models.Depenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepenseRepository extends CrudRepository<Depenses,Long> {
}
