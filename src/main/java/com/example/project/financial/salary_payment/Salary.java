package com.example.project.financial.salary_payment;

import jakarta.persistence.*;
import java.time.Month;

@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_payment_id")
    private PlayerPayment playerPayment;

    private Month month; // ماه
    private Double amount; // مبلغ
    private Boolean status; // وضعیت پرداخت: true = پرداخت شده، false = پرداخت نشده

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerPayment getPlayerPayment() {
        return playerPayment;
    }

    public void setPlayerPayment(PlayerPayment playerPayment) {
        this.playerPayment = playerPayment;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

