package com.company.codezybackend.repository;

import com.company.codezybackend.entity.StudentsEntity;
import com.company.codezybackend.entity.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo  extends JpaRepository<StudentsEntity, Integer> {
}
