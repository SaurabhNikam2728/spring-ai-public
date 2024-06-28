package com.springai.spring_ai.ai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springai.spring_ai.ai.entity.SpringAi;

@Repository
public interface SpringAiRepository  extends JpaRepository<SpringAi,Integer>{
    
    // Optional<SpringAi> findByIdAndIsDeletedFalse();

    // SpringAi saveResponse(SpringAi springAiDetails); 
}
