package com.example.comptabilite.repository;

import com.example.comptabilite.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
}
