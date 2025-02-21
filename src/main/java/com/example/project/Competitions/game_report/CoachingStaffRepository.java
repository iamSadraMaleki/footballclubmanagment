package com.example.project.Competitions.game_report;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachingStaffRepository extends JpaRepository<CoachingStaff, Long> {
    // مثلاً متدی برای پیدا کردن مربیان بر اساس تیم یا سمت
    List<CoachingStaff> findByTeamNameAndRole(String teamName, String role);
}

