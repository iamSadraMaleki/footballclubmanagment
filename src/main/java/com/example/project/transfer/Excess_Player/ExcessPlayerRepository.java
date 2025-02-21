package com.example.project.transfer.Excess_Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcessPlayerRepository extends JpaRepository<ExcessPlayer, Long> {
    ExcessPlayer findByStaffCode(String staffCode);
    void deleteByStaffCode(String staffCode);
}
