package com.example.project.transfer.buy_player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyPlayerRepository extends JpaRepository<BuyPlayer, Long> {
}
