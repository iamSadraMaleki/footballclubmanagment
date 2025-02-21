package com.example.project.transfer.Renewed_Player;


import com.example.project.transfer.player_list.Player;
import com.example.project.transfer.player_list.PlayerRepository;
import com.example.project.transfer.transfer_report.TransferReport;
import com.example.project.transfer.transfer_report.TransferReportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenewedPlayerService {

    @Autowired
    private RenewedPlayerRepository renewedPlayerRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TransferReportRepository transferReportRepository;

    public RenewedPlayer renewPlayer(RenewedPlayer renewedPlayer) {
        // Save in renewed_player table
        RenewedPlayer savedRenewedPlayer = renewedPlayerRepository.save(renewedPlayer);

        // Update player in player_list table
        Player player = playerRepository.findByNationalId(renewedPlayer.getNationalId())
                .orElseThrow(() -> new IllegalArgumentException("Player not found in player_list"));
        player.setContractDuration(renewedPlayer.getContractDuration());
        player.setContractAmount(renewedPlayer.getContractAmount());
        playerRepository.save(player);

        // Save in transfer_report table
        TransferReport report = new TransferReport(
                renewedPlayer.getFirstName(),
                renewedPlayer.getLastName(),
                renewedPlayer.getAge(),
                renewedPlayer.getPosition(),
                renewedPlayer.getNationality(),
                "Renewed"
        );
        transferReportRepository.save(report);

        return savedRenewedPlayer;
    }

    public List<RenewedPlayer> getAllRenewedPlayers() {
        return renewedPlayerRepository.findAll();
    }

    @Transactional
    public void deleteRenewedPlayer(Long id) {
        RenewedPlayer renewedPlayer = renewedPlayerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Renewed player not found"));

        // Delete from player_list and transfer_report
        playerRepository.deleteByStaffCode(renewedPlayer.getStaffCode());
        transferReportRepository.deleteByFirstNameAndLastName(
                renewedPlayer.getFirstName(), renewedPlayer.getLastName()
        );

        renewedPlayerRepository.deleteById(id);
    }
}