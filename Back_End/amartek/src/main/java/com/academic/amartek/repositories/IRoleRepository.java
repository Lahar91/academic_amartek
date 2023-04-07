package com.academic.amartek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.academic.amartek.models.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String>{
    Role findByName(String name);
}