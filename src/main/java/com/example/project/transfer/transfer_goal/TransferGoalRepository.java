package com.example.project.transfer.transfer_goal;
;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferGoalRepository extends JpaRepository<TransferGoal, Long> {
}

