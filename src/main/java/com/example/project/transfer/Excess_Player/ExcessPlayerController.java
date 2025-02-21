package com.example.project.transfer.Excess_Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/excess-players")
public class ExcessPlayerController {

    @Autowired
    private ExcessPlayerService excessPlayerService;

    @PostMapping
    public ExcessPlayer addToExcessList(@RequestBody ExcessPlayer excessPlayer) {
        return excessPlayerService.addToExcessList(excessPlayer);
    }

    @DeleteMapping("/{staffCode}")
    public ResponseEntity<Void> removeFromExcessList(@PathVariable String staffCode) {
        excessPlayerService.removeFromExcessList(staffCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{staffCode}")
    public ExcessPlayer getExcessPlayer(@PathVariable String staffCode) {
        return excessPlayerService.getExcessPlayer(staffCode);
    }

    @GetMapping
    public List<ExcessPlayer> getAllExcessPlayers() {
        return excessPlayerService.getAllExcessPlayers();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExcessPlayer(@PathVariable Long id) {
        excessPlayerService.deleteExcessPlayer(id);
        return ResponseEntity.noContent().build();
    }
}

