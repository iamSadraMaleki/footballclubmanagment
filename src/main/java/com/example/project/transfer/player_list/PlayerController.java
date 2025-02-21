package com.example.project.transfer.player_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        Optional<Player> existingPlayer = playerService.getPlayerById(id);
        if (existingPlayer.isPresent()) {
            Player player = existingPlayer.get();
            player.setFirstName(updatedPlayer.getFirstName());
            player.setLastName(updatedPlayer.getLastName());
            player.setAge(updatedPlayer.getAge());
            player.setShirtNumber(updatedPlayer.getShirtNumber());
            player.setPosition(updatedPlayer.getPosition());
            player.setNationality(updatedPlayer.getNationality());
            player.setContractDuration(updatedPlayer.getContractDuration());
            player.setContractAmount(updatedPlayer.getContractAmount());
            player.setAgent(updatedPlayer.getAgent());
            player.setStatus(updatedPlayer.getStatus());
            player.setInjuryReason(updatedPlayer.getInjuryReason());
            player.setInjuryDuration(updatedPlayer.getInjuryDuration());
            playerService.savePlayer(player);
            return ResponseEntity.ok(player);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        Optional<Player> existingPlayer = playerService.getPlayerById(id);
        if (existingPlayer.isPresent()) {
            playerService.deletePlayer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}