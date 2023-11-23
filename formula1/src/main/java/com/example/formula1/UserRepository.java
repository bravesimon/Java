package com.example.formula1;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);
}