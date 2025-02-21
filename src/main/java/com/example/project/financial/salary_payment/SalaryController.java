package com.example.project.financial.salary_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    // ثبت بازیکن جدید
    @PostMapping("/create-player")
    public ResponseEntity<PlayerPayment> createPlayer(@RequestParam String name, @RequestParam Double contractAmount) {
        PlayerPayment playerPayment = salaryService.createPlayer(name, contractAmount);
        return ResponseEntity.ok(playerPayment);
    }

    // ویرایش بازیکن
    @PutMapping("/update-player/{playerPaymentId}")
    public ResponseEntity<PlayerPayment> updatePlayer(@PathVariable Long playerPaymentId,
                                                      @RequestParam String name,
                                                      @RequestParam Double contractAmount) {
        PlayerPayment playerPayment = salaryService.updatePlayer(playerPaymentId, name, contractAmount);
        return ResponseEntity.ok(playerPayment);
    }

    // حذف بازیکن
    @DeleteMapping("/delete-player/{playerPaymentId}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long playerPaymentId) {
        salaryService.deletePlayer(playerPaymentId);
        return ResponseEntity.ok("Player deleted successfully");
    }

    // مشاهده لیست بازیکنان
    @GetMapping("/players")
    public ResponseEntity<List<PlayerPayment>> getAllPlayers() {
        List<PlayerPayment> players = salaryService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    // مشاهده حقوق بازیکن
    @GetMapping("/player-salaries/{playerPaymentId}")
    public ResponseEntity<List<Salary>> getPlayerSalaries(@PathVariable Long playerPaymentId) {
        List<Salary> salaries = salaryService.getPlayerSalaries(playerPaymentId);
        return ResponseEntity.ok(salaries);
    }

    // تغییر وضعیت پرداخت حقوق
    @PutMapping("/update-salary-status/{salaryId}")
    public ResponseEntity<Salary> updateSalaryStatus(@PathVariable Long salaryId, @RequestParam Boolean status) {
        Salary salary = salaryService.updateSalaryStatus(salaryId, status);
        return ResponseEntity.ok(salary);
    }
}

