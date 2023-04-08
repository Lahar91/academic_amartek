

package com.academic.amartek.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.academic.amartek.models.Recruitment;

/**
 * IArrangeInterview
 Repository
*/
 
@Repository
public interface IArrangeInterviewRepository extends JpaRepository<Recruitment, Integer>  {
    @Query(value = "select * from tb_tr_recruitments", nativeQuery = true)
    public  List<Recruitment> Getall();
}