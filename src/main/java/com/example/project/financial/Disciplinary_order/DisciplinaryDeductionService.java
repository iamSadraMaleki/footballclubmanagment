package com.example.project.financial.Disciplinary_order;

import com.example.project.financial.salary_payment.PlayerPayment;
import com.example.project.financial.salary_payment.PlayerPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DisciplinaryDeductionService {

    @Autowired
    private DisciplinaryDeductionRepository deductionRepository;

    @Autowired
    private PlayerPaymentRepository playerPaymentRepository;

    // اضافه کردن جریمه
    public DisciplinaryDeduction addDeduction(Long playerId, Double deductionAmount, String description) {
        PlayerPayment player = playerPaymentRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        DisciplinaryDeduction deduction = new DisciplinaryDeduction();
        deduction.setPlayer(player);
        deduction.setDeductionAmount(deductionAmount);
        deduction.setDescription(description);
        deduction.setDeductionDate(LocalDate.now());

        return deductionRepository.save(deduction);
    }

    // ویرایش جریمه
    public DisciplinaryDeduction updateDeduction(Long deductionId, Double deductionAmount, String description) {
        DisciplinaryDeduction deduction = deductionRepository.findById(deductionId)
                .orElseThrow(() -> new IllegalArgumentException("Deduction not found"));

        deduction.setDeductionAmount(deductionAmount);
        deduction.setDescription(description);

        return deductionRepository.save(deduction);
    }

    // حذف جریمه
    public void deleteDeduction(Long deductionId) {
        deductionRepository.deleteById(deductionId);
    }

    // مشاهده جریمه‌های یک بازیکن
    public List<DisciplinaryDeduction> getDeductionsByPlayerId(Long playerId) {
        return deductionRepository.findByPlayerId(playerId);
    }

    // مشاهده همه جریمه‌ها
    public List<DisciplinaryDeduction> getAllDeductions() {
        return deductionRepository.findAll();
    }
}
