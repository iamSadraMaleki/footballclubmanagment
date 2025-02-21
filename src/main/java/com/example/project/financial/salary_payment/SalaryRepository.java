package com.example.project.financial.salary_payment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findByPlayerPaymentId(Long playerPaymentId);
}
