package com.example.comptability.repository;

import com.example.comptability.models.Depenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DepenseRepository extends CrudRepository<Depenses,Long> {
}
