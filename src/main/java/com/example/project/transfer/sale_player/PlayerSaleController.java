package com.example.project.transfer.sale_player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/player-sales")
public class PlayerSaleController {

    @Autowired
    private PlayerSaleService playerSaleService;

    @GetMapping
    public String showBuyPage() {
        return "sale_player"; // تمام اطلاعات در buy_form نمایش داده می‌شود
    }

    @PostMapping("/api")
    public PlayerSale createPlayerSale(@RequestBody PlayerSale playerSale) {
        return playerSaleService.sellPlayer(playerSale);
    }

    @GetMapping("/api")
    @ResponseBody
    public ResponseEntity<List<PlayerSale>> getAllSales() {
        List<PlayerSale> sales = playerSaleService.getAllSales();
        return ResponseEntity.ok(sales);
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<PlayerSale> getSaleDetails(@PathVariable Long id) {
        PlayerSale sale = playerSaleService.getSaleDetails(id);

        if (sale == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sale);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        playerSaleService.deleteSale(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<PlayerSale> updateSale(@PathVariable Long id, @RequestBody PlayerSale updatedSale) {
        PlayerSale savedSale = playerSaleService.updateSale(id, updatedSale);

        if (savedSale == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(savedSale);
    }
}
