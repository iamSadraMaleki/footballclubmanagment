package com.example.project.Competitions.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final LeagueRepository leagueRepository;
    private final MatchRepository matchRepository;
    private final MatchService matchService;

    // Constructor Injection
    public MatchController(LeagueRepository leagueRepository, MatchRepository matchRepository, MatchService matchService) {
        this.leagueRepository = leagueRepository;
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }

    @PostMapping
    public Match createMatch(@RequestBody MatchDTO matchDTO) {
        League league = leagueRepository.findById(matchDTO.getLeagueId())
                .orElseThrow(() -> new IllegalArgumentException("League not found"));

        Match match = new Match();
        match.setHomeTeam(matchDTO.getHomeTeam());
        match.setAwayTeam(matchDTO.getAwayTeam());
        match.setHomeScore(matchDTO.getHomeScore());
        match.setAwayScore(matchDTO.getAwayScore());
        match.setLeague(league);
        match.setWeek(matchDTO.getWeek());

        matchRepository.save(match);

        // Call the method to update the league table
        matchService.updateLeagueTable(match);

        return match;
    }

    @PutMapping("/{id}")
    public Match updateMatchResult(@PathVariable Long id, @RequestBody Map<String, Integer> scores) {
        return matchService.updateMatchResult(id, scores.get("homeScore"), scores.get("awayScore"));
    }
}

