package com.example.project.Competitions.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private LeagueTableRepository leagueTableRepository;


    public League createLeague(Long seasonId, League league) {
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new IllegalArgumentException("Season not found"));
        league.setSeason(season);
        return leagueRepository.save(league);
    }

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public void initializeLeagueTable(Long leagueId, List<String> teams) {
        League league = leagueRepository.findById(leagueId)
                .orElseThrow(() -> new IllegalArgumentException("League not found"));

        for (String team : teams) {
            LeagueTable leagueTable = new LeagueTable();
            leagueTable.setLeague(league);
            leagueTable.setTeamName(team);
            leagueTable.setPlayed(0);
            leagueTable.setWins(0);
            leagueTable.setDraws(0);
            leagueTable.setLosses(0);
            leagueTable.setGoalsFor(0);
            leagueTable.setGoalsAgainst(0);
            leagueTable.setPoints(0);

            leagueTableRepository.save(leagueTable);
        }
    }
}

