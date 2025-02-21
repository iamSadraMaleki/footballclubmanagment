package com.example.project.transfer.transfer_goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferGoalService {

    @Autowired
    private TransferGoalRepository transferGoalRepository;

    public List<TransferGoal> getAllGoals() {
        return transferGoalRepository.findAll();
    }

    public Optional<TransferGoal> getGoalById(Long id) {
        return transferGoalRepository.findById(id);
    }

    public TransferGoal saveGoal(TransferGoal goal) {
        return transferGoalRepository.save(goal);
    }

    public void deleteGoal(Long id) {
        transferGoalRepository.deleteById(id);
    }
}

