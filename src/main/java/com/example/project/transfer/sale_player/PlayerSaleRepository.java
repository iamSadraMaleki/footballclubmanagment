package com.example.project.transfer.sale_player;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerSaleRepository extends JpaRepository<PlayerSale, Long> {
    boolean existsByStaffCode(String staffCode);
}

