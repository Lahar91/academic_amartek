package com.academic.amartek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academic.amartek.models.Recruitment;

@Repository
public interface IRecRepository extends JpaRepository<Recruitment, Integer> {
    
}
