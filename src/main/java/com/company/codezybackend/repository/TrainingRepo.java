package com.company.codezybackend.repository;

import com.company.codezybackend.entity.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepo extends JpaRepository<TrainingEntity, Integer> {

}
