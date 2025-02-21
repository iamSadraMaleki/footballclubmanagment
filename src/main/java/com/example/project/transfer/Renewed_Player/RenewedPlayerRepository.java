package com.example.project.transfer.Renewed_Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenewedPlayerRepository extends JpaRepository<RenewedPlayer, Long> {
    boolean existsByNationalId(String nationalId);
    void deleteByNationalId(String nationalId);
}

