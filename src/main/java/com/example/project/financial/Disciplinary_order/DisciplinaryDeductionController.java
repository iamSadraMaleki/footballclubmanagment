package com.example.project.financial.Disciplinary_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deductions")
public class DisciplinaryDeductionController {

    @Autowired
    private DisciplinaryDeductionService deductionService;

    // اضافه کردن جریمه
    @PostMapping("/add")
    public ResponseEntity<DisciplinaryDeduction> addDeduction(@RequestParam Long playerId,
                                                              @RequestParam Double deductionAmount,
                                                              @RequestParam String description) {
        DisciplinaryDeduction deduction = deductionService.addDeduction(playerId, deductionAmount, description);
        return ResponseEntity.ok(deduction);
    }

    // ویرایش جریمه
    @PutMapping("/update/{deductionId}")
    public ResponseEntity<DisciplinaryDeduction> updateDeduction(@PathVariable Long deductionId,
                                                                 @RequestParam Double deductionAmount,
                                                                 @RequestParam String description) {
        DisciplinaryDeduction deduction = deductionService.updateDeduction(deductionId, deductionAmount, description);
        return ResponseEntity.ok(deduction);
    }

    // حذف جریمه
    @DeleteMapping("/delete/{deductionId}")
    public ResponseEntity<String> deleteDeduction(@PathVariable Long deductionId) {
        deductionService.deleteDeduction(deductionId);
        return ResponseEntity.ok("Deduction deleted successfully");
    }

    // مشاهده جریمه‌های یک بازیکن
    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<DisciplinaryDeduction>> getDeductionsByPlayerId(@PathVariable Long playerId) {
        List<DisciplinaryDeduction> deductions = deductionService.getDeductionsByPlayerId(playerId);
        return ResponseEntity.ok(deductions);
    }

    // مشاهده همه جریمه‌ها
    @GetMapping("/all")
    public ResponseEntity<List<DisciplinaryDeduction>> getAllDeductions() {
        List<DisciplinaryDeduction> deductions = deductionService.getAllDeductions();
        return ResponseEntity.ok(deductions);
    }
}

