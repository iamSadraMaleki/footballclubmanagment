package com.example.project.transfer.Renewed_Player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/renewed-players")
public class RenewedPlayerController {

    @Autowired
    private RenewedPlayerService renewedPlayerService;

    @GetMapping
    public List<RenewedPlayer> getAllRenewedPlayers() {
        return renewedPlayerService.getAllRenewedPlayers();
    }

    @PostMapping
    public RenewedPlayer renewPlayer(@RequestBody RenewedPlayer renewedPlayer) {
        return renewedPlayerService.renewPlayer(renewedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRenewedPlayer(@PathVariable Long id) {
        renewedPlayerService.deleteRenewedPlayer(id);
        return ResponseEntity.noContent().build();
    }
}

