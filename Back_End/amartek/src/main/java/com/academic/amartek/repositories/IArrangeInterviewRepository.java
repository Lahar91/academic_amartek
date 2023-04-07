

package com.academic.amartek.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academic.amartek.models.Recruitment;

/**
 * IArrangeInterview
 Repository
*/
 
@Repository
public interface IArrangeInterviewRepository extends JpaRepository<Recruitment, Integer>  {

    
}