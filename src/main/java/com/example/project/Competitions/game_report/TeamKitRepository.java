package com.example.project.Competitions.game_report;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamKitRepository extends JpaRepository<TeamKit, Long> {
    // متدهای جستجوی خاص، مثل پیدا کردن کیت تیم بر اساس رنگ یا تیم
    List<TeamKit> findByTeamName(String teamName);
}

