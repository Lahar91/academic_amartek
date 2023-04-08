package com.academic.amartek.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.academic.amartek.models.UserSkill;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
    
    @Query(value = "SELECT u.id, u.user_id AS userId, s.skill_name AS skillName FROM tb_tr_userskill u " +
    "JOIN tb_m_skill s ON u.skill_id = s.id " +
    "WHERE u.user_id =:userId", nativeQuery = true)
    public List<Map<String, Object>> getUserSkill(@Param("userId") String userId);
}