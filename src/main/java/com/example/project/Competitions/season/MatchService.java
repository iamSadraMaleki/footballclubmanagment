package com.example.project.Competitions.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private LeagueTableRepository leagueTableRepository;

    @Autowired
    private LeagueRepository leagueRepository;
    private MatchDTO matchDTO;


    public Match createMatch(MatchDTO matchDTO) {
        League league = leagueRepository.findById(matchDTO.getLeagueId())
                .orElseThrow(() -> new IllegalArgumentException("League not found"));

        Match match = new Match(); // این خط دیگر مشکلی ایجاد نمی‌کند
        match.setHomeTeam(matchDTO.getHomeTeam());
        match.setAwayTeam(matchDTO.getAwayTeam());
        match.setHomeScore(matchDTO.getHomeScore());
        match.setAwayScore(matchDTO.getAwayScore());
        match.setLeague(league); // مقدار league_id اینجا ست می‌شود
        match.setWeek(matchDTO.getWeek());

        matchRepository.save(match);
        return match;
    }

    public Match updateMatchResult(Long matchId, int homeScore, int awayScore) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException("Match not found"));

        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
        matchRepository.save(match);

        // Update League Table
        updateLeagueTable(match);
        return match;
    }

    public void updateLeagueTable(Match match) {
        LeagueTable homeTeam = leagueTableRepository
                .findByLeagueAndTeamName(match.getLeague(), match.getHomeTeam())
                .orElseThrow(() -> new IllegalArgumentException("Home team not found in league table"));

        LeagueTable awayTeam = leagueTableRepository
                .findByLeagueAndTeamName(match.getLeague(), match.getAwayTeam())
                .orElseThrow(() -> new IllegalArgumentException("Away team not found in league table"));

        if (match.getHomeScore() > match.getAwayScore()) {
            // Home team wins
            homeTeam.setPoints(homeTeam.getPoints() + 3);
            homeTeam.setWins(homeTeam.getWins() + 1);
            awayTeam.setLosses(awayTeam.getLosses() + 1);
        } else if (match.getHomeScore() < match.getAwayScore()) {
            // Away team wins
            awayTeam.setPoints(awayTeam.getPoints() + 3);
            awayTeam.setWins(awayTeam.getWins() + 1);
            homeTeam.setLosses(homeTeam.getLosses() + 1);
        } else {
            // Draw
            homeTeam.setPoints(homeTeam.getPoints() + 1);
            awayTeam.setPoints(awayTeam.getPoints() + 1);
            homeTeam.setDraws(homeTeam.getDraws() + 1);
            awayTeam.setDraws(awayTeam.getDraws() + 1);
        }

        // Update goals
        homeTeam.setGoalsFor(homeTeam.getGoalsFor() + match.getHomeScore());
        homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst() + match.getAwayScore());
        homeTeam.setGoalDifference(homeTeam.getGoalsFor() - homeTeam.getGoalsAgainst());

        awayTeam.setGoalsFor(awayTeam.getGoalsFor() + match.getAwayScore());
        awayTeam.setGoalsAgainst(awayTeam.getGoalsAgainst() + match.getHomeScore());
        awayTeam.setGoalDifference(awayTeam.getGoalsFor() - awayTeam.getGoalsAgainst());

        leagueTableRepository.save(homeTeam);
        leagueTableRepository.save(awayTeam);
    }

}
