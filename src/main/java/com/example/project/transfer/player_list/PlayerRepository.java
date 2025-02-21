package com.example.project.transfer.player_list;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByNationalId(String nationalId);

    void deleteByStaffCode(String staffCode);

    Optional<Player> findByNationalId(String nationalId);
    void deleteByNationalId(String nationalId);
}
