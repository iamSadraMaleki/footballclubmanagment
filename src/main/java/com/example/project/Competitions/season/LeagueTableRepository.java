package com.example.project.Competitions.season;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueTableRepository extends JpaRepository<LeagueTable, Long> {
    // Method to find a specific team's entry in a specific league
    Optional<LeagueTable> findByLeagueAndTeamName(League league, String teamName);

    // Method to fetch all league table entries for a specific league
    List<LeagueTable> findByLeague(League league);
}
