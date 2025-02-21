package com.example.project.financial.Disciplinary_order;

import com.example.project.financial.salary_payment.PlayerPayment;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DisciplinaryDeduction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerPayment player;

    private Double deductionAmount;

    @Column(length = 500)
    private String description;

    private LocalDate deductionDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerPayment getPlayer() {
        return player;
    }

    public void setPlayer(PlayerPayment player) {
        this.player = player;
    }

    public Double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(Double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeductionDate() {
        return deductionDate;
    }

    public void setDeductionDate(LocalDate deductionDate) {
        this.deductionDate = deductionDate;
    }
}

