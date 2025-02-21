package com.example.project.transfer.transfer_goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transfer-goals")
public class TransferGoalController {

    @Autowired
    private TransferGoalService transferGoalService;

    @GetMapping
    public List<TransferGoal> getAllGoals() {
        return transferGoalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferGoal> getGoalById(@PathVariable Long id) {
        Optional<TransferGoal> goal = transferGoalService.getGoalById(id);
        return goal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TransferGoal createGoal(@RequestBody TransferGoal goal) {
        return transferGoalService.saveGoal(goal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferGoal> updateGoal(@PathVariable Long id, @RequestBody TransferGoal updatedGoal) {
        Optional<TransferGoal> existingGoal = transferGoalService.getGoalById(id);
        if (existingGoal.isPresent()) {
            TransferGoal goal = existingGoal.get();
            goal.setFirstName(updatedGoal.getFirstName());
            goal.setLastName(updatedGoal.getLastName());
            goal.setPosition(updatedGoal.getPosition());
            goal.setAge(updatedGoal.getAge());
            goal.setTeamNeedPercentage(updatedGoal.getTeamNeedPercentage());
            goal.setCurrentTeam(updatedGoal.getCurrentTeam());
            transferGoalService.saveGoal(goal);
            return ResponseEntity.ok(goal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        Optional<TransferGoal> existingGoal = transferGoalService.getGoalById(id);
        if (existingGoal.isPresent()) {
            transferGoalService.deleteGoal(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

