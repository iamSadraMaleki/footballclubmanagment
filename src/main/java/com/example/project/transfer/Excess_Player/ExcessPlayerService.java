package com.example.project.transfer.Excess_Player;

import com.example.project.transfer.player_list.Player;
import com.example.project.transfer.player_list.PlayerRepository;
import com.example.project.transfer.player_list.PlayerStatus;
import com.example.project.transfer.sale_player.PlayerSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExcessPlayerService {

    @Autowired
    private ExcessPlayerRepository excessPlayerRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerSaleRepository playerSaleRepository;

    @Transactional
    public ExcessPlayer addToExcessList(ExcessPlayer excessPlayer) {
        // Find player by nationalId
        Optional<Player> optionalPlayer = playerRepository.findByNationalId(excessPlayer.getNationalId());
        if (optionalPlayer.isEmpty()) {
            throw new IllegalArgumentException("Player not found in player_list");
        }

        // Extract the player object
        Player player = optionalPlayer.get();

        // Update the player's status
        player.setStatus(PlayerStatus.valueOf("EXCESS"));
        playerRepository.save(player);

        // Save player to excess_player table
        return excessPlayerRepository.save(excessPlayer);
    }

    @Transactional
    public void removeFromExcessList(String staffCode) {
        ExcessPlayer excessPlayer = excessPlayerRepository.findByStaffCode(staffCode);
        if (excessPlayer == null) {
            throw new IllegalArgumentException("Player not found in excess list");
        }

        // Check if the player is in the player_sale table
        boolean isInSaleList = playerSaleRepository.existsByStaffCode(staffCode);
        if (isInSaleList) {
            // Remove player from excess_player table
            excessPlayerRepository.deleteByStaffCode(staffCode);
        } else {
            throw new IllegalArgumentException("Player is not in the player_sale list");
        }
    }

    public ExcessPlayer getExcessPlayer(String staffCode) {
        return excessPlayerRepository.findByStaffCode(staffCode);
    }

    public void deleteExcessPlayer(Long id) {
        excessPlayerRepository.deleteById(id);
    }

    public List<ExcessPlayer> getAllExcessPlayers() {
        return excessPlayerRepository.findAll();
    }
}
