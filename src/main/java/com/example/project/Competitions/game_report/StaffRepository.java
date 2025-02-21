package com.example.project.Competitions.game_report;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    // متدهای خاص برای جستجوی پرسنل بر اساس سمت
    List<Staff> findByRole(String role);
}
