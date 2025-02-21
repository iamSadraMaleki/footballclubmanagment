package com.example.project.financial.salary_payment;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class PlayerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // نام بازیکن
    private Double contractAmount; // مبلغ قرارداد (کل مبلغ)
    private Double monthlySalary;  // حقوق ماهانه (سیستم محاسبه می‌کند)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    @OneToMany(mappedBy = "playerPayment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salary> salaries;

    // Getters and Setters
}