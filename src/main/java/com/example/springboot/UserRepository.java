package com.example.springboot;

import com.example.springboot.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

//   People findByEmailAndPassword(String email, String password);

    Optional<Object> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}

