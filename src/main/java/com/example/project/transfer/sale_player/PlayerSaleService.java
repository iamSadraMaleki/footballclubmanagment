package com.example.project.transfer.sale_player;


import com.example.project.transfer.player_list.Player;
import com.example.project.transfer.player_list.PlayerRepository;
import com.example.project.transfer.transfer_report.TransferReport;
import com.example.project.transfer.transfer_report.TransferReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerSaleService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerSaleRepository playerSaleRepository;

    @Autowired
    private TransferReportRepository transferReportRepository;

    @Transactional
    public PlayerSale sellPlayer(PlayerSale playerSale) {
        // Find and remove the player from player_list
        Optional<Player> player = playerRepository.findByNationalId(playerSale.getNationalId());
        if (player == null) {
            throw new IllegalArgumentException("Player not found in player_list");
        }
        if (playerSale.getSeparationType() == null || playerSale.getSeparationType().isEmpty()) {
            playerSale.setSeparationType("Transfer"); // مقدار پیش‌فرض
        }
        playerRepository.deleteByNationalId(playerSale.getNationalId());

        // Save player to player_sale table
        PlayerSale savedPlayerSale = playerSaleRepository.save(playerSale);

        // Add entry to transfer_report
        TransferReport transferReport = new TransferReport(
                playerSale.getFirstName(),
                playerSale.getLastName(),
                playerSale.getAge(),
                playerSale.getPosition(),
                playerSale.getNationality(),
                "Sold"
        );
        transferReportRepository.save(transferReport);

        return savedPlayerSale;
    }

    public List<PlayerSale> getAllSales() {
        return playerSaleRepository.findAll();
    }

    public PlayerSale getSaleDetails(Long id) {
        return playerSaleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Sale not found"));
    }

    @Transactional
    public void deleteSale(Long id) {
        PlayerSale sale = playerSaleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Sale not found"));
        playerSaleRepository.deleteById(id);
    }

    @Transactional
    public PlayerSale updateSale(Long id, PlayerSale updatedSale) {
        PlayerSale existingSale = playerSaleRepository.findById(id).orElse(null);

        if (existingSale == null) {
            return null; // یا می‌تونی یک استثنا (`throw new EntityNotFoundException()`) برگردونی
        }

        // به‌روزرسانی فیلدهای بازیکن فروش رفته
        existingSale.setFirstName(updatedSale.getFirstName());
        existingSale.setLastName(updatedSale.getLastName());
        existingSale.setAge(updatedSale.getAge());
        existingSale.setShirtNumber(updatedSale.getShirtNumber());
        existingSale.setPosition(updatedSale.getPosition());
        existingSale.setNationality(updatedSale.getNationality());
        existingSale.setContractDuration(updatedSale.getContractDuration());
        existingSale.setContractAmount(updatedSale.getContractAmount());
        existingSale.setAgent(updatedSale.getAgent());
        existingSale.setStaffCode(updatedSale.getStaffCode());
        existingSale.setNationalId(updatedSale.getNationalId());
        existingSale.setSeparationType(updatedSale.getSeparationType());
        existingSale.setReleaseClause(updatedSale.getReleaseClause());

        return playerSaleRepository.save(existingSale);
    }

}
