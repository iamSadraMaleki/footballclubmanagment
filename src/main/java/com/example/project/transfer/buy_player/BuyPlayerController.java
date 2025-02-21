package com.example.project.transfer.buy_player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/buy-players")
public class BuyPlayerController {

    @Autowired
    private BuyPlayerService buyPlayerService;

    @GetMapping
    public String showBuyPage() {
        return "buy_player"; // نمایش صفحه خرید بازیکن
    }

    @GetMapping("/api")
    @ResponseBody
    public ResponseEntity<List<BuyPlayer>> getAllBuyPlayers() {
        List<BuyPlayer> players = buyPlayerService.getAllBuyPlayers();
        return ResponseEntity.ok(players);
    }

    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<BuyPlayer> buyPlayer(@RequestBody BuyPlayer buyPlayer) {
        if (buyPlayer.getAgent() == null) {
            buyPlayer.setAgent(""); // مقدار پیش‌فرض برای جلوگیری از خطای null
        }
        BuyPlayer savedPlayer = buyPlayerService.buyPlayer(buyPlayer);
        return ResponseEntity.ok(savedPlayer);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Void> deleteBuyPlayer(@PathVariable Long id) {
        buyPlayerService.deleteBuyPlayer(id);
        return ResponseEntity.noContent().build();
    }
}