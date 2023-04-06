package com.academic.amartek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academic.amartek.models.Skill;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer> {
    
}
