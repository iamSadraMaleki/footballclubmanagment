package com.example.project.users.repository;

import com.example.project.users.modelENTTI.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersModel, Long> {
    UsersModel findByUsername(String username);
}

