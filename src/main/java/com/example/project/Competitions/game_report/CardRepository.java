package com.example.project.Competitions.game_report;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    // متدهای سفارشی، مثلاً پیدا کردن کارت‌ها بر اساس نوع کارت (زرد/قرمز)
}

