package com.academic.amartek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academic.amartek.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String>{
    boolean existsByEmail(String email);
    User findByEmail(String email);
}