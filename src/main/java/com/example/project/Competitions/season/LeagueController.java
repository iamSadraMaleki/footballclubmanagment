package com.example.project.Competitions.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;

    @PostMapping("/{seasonId}")
    public League createLeague(@PathVariable Long seasonId, @RequestBody League league) {
        return leagueService.createLeague(seasonId, league);
    }

    @GetMapping
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @PostMapping("/{leagueId}/initialize-table")
    public ResponseEntity<Void> initializeLeagueTable(
            @PathVariable Long leagueId,
            @RequestBody List<String> teams) {
        leagueService.initializeLeagueTable(leagueId, teams);
        return ResponseEntity.ok().build();
    }



}

