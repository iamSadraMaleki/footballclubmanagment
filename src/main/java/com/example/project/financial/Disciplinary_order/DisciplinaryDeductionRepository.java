package com.example.project.financial.Disciplinary_order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaryDeductionRepository extends JpaRepository<DisciplinaryDeduction, Long> {

    List<DisciplinaryDeduction> findByPlayerId(Long playerId);
}

