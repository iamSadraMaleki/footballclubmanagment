package com.example.project.transfer.buy_player;

import com.example.project.transfer.player_list.Player;
import com.example.project.transfer.player_list.PlayerRepository;
import com.example.project.transfer.player_list.PlayerStatus;
import com.example.project.transfer.transfer_report.TransferReport;
import com.example.project.transfer.transfer_report.TransferReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyPlayerService {

    @Autowired
    private BuyPlayerRepository buyPlayerRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TransferReportRepository transferReportRepository;

    public BuyPlayer buyPlayer(BuyPlayer buyPlayer) {
        // Save in buy_player table
        BuyPlayer savedBuyPlayer = buyPlayerRepository.save(buyPlayer);

        // Save in player_list table
        Player player = new Player(
                buyPlayer.getFirstName(),
                buyPlayer.getLastName(),
                buyPlayer.getAge(),
                buyPlayer.getShirtNumber(),
                buyPlayer.getPosition(),
                buyPlayer.getNationality(),
                buyPlayer.getContractDuration(),
                buyPlayer.getContractAmount(),
                buyPlayer.getAgent(),
                buyPlayer.getStaffCode(),
                buyPlayer.getNationalId(),
                PlayerStatus.AVAILABLE
        );
        playerRepository.save(player);

        // Save in transfer_report table
        TransferReport report = new TransferReport(
                buyPlayer.getFirstName(),
                buyPlayer.getLastName(),
                buyPlayer.getAge(),
                buyPlayer.getPosition(),
                buyPlayer.getNationality(),
                "Buy"
        );
        transferReportRepository.save(report);

        return savedBuyPlayer;
    }

    public List<BuyPlayer> getAllBuyPlayers() {
        return buyPlayerRepository.findAll();
    }

    public void deleteBuyPlayer(Long id) {
        buyPlayerRepository.deleteById(id);
    }
}

