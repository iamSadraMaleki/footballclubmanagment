package com.example.project.financial.salary_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private PlayerPaymentRepository playerPaymentRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    // ثبت بازیکن و ایجاد حقوق ماهانه
    public PlayerPayment createPlayer(String name, Double contractAmount) {
        PlayerPayment playerPayment = new PlayerPayment();
        playerPayment.setName(name);
        playerPayment.setContractAmount(contractAmount);

        // محاسبه حقوق ماهانه
        Double monthlySalary = contractAmount / 12;
        playerPayment.setMonthlySalary(monthlySalary);

        PlayerPayment savedPlayerPayment = playerPaymentRepository.save(playerPayment);

        // ایجاد حقوق ماهانه برای 12 ماه
        List<Salary> salaries = new ArrayList<>();
        for (Month month : Month.values()) {
            Salary salary = new Salary();
            salary.setPlayerPayment(savedPlayerPayment);
            salary.setMonth(month);
            salary.setAmount(monthlySalary);
            salary.setStatus(false); // پیش‌فرض: پرداخت نشده
            salaries.add(salary);
        }

        salaryRepository.saveAll(salaries);
        return savedPlayerPayment;
    }

    // ویرایش بازیکن
    public PlayerPayment updatePlayer(Long playerPaymentId, String name, Double contractAmount) {
        PlayerPayment playerPayment = playerPaymentRepository.findById(playerPaymentId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        playerPayment.setName(name);
        playerPayment.setContractAmount(contractAmount);

        // محاسبه مجدد حقوق ماهانه
        playerPayment.setMonthlySalary(contractAmount / 12);
        return playerPaymentRepository.save(playerPayment);
    }

    // حذف بازیکن و حقوق مربوطه
    public void deletePlayer(Long playerPaymentId) {
        playerPaymentRepository.deleteById(playerPaymentId);
    }

    // مشاهده لیست بازیکنان
    public List<PlayerPayment> getAllPlayers() {
        return playerPaymentRepository.findAll();
    }

    // مشاهده لیست حقوق یک بازیکن
    public List<Salary> getPlayerSalaries(Long playerPaymentId) {
        return salaryRepository.findByPlayerPaymentId(playerPaymentId);
    }

    // تغییر وضعیت پرداخت حقوق
    public Salary updateSalaryStatus(Long salaryId, Boolean status) {
        Salary salary = salaryRepository.findById(salaryId)
                .orElseThrow(() -> new IllegalArgumentException("Salary not found"));

        salary.setStatus(status);
        return salaryRepository.save(salary);
    }
}
