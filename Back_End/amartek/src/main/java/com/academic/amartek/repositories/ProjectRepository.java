package com.academic.amartek.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.academic.amartek.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT p.id, p.user_id AS userId, p.name AS projectName, p.project_start AS projectStart, "+
    "p.project_end AS projectEnd, p.project_desc AS projectDesc FROM tb_m_project p " +
    "WHERE p.user_id =:userId", nativeQuery = true)
    public List<Map<String, Object>> getProject(@Param("userId") String userId);
}
