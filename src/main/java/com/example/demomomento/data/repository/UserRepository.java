package com.example.demomomento.data.repository;

import com.example.demomomento.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
