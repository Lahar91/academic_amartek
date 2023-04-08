package com.academic.amartek.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.academic.amartek.models.Biodata;


@Repository
public interface BiodataRepository extends JpaRepository<Biodata, Integer> {

    @Query(value = "SELECT b.id, b.fullname, b.birth_date, b.no_telp, b.address, b.summary FROM tb_m_biodata b " +
    "WHERE b.id =:userId", nativeQuery = true)
    public List<Map<String, Object>> getBiodata(@Param("userId") String userId);
    
}
