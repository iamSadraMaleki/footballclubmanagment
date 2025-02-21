package com.example.project.Competitions.season;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "league_table")
public class LeagueTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "played", nullable = false)
    private int played = 0;

    @Column(name = "wins", nullable = false)
    private int wins = 0;

    @Column(name = "draws", nullable = false)
    private int draws = 0;

    @Column(name = "losses", nullable = false)
    private int losses = 0;

    @Column(name = "goals_for", nullable = false)
    private int goalsFor = 0;

    @Column(name = "goals_against", nullable = false)
    private int goalsAgainst = 0;

    @Column(name = "points", nullable = false)
    private int points = 0;

    @ManyToOne
    @JoinColumn(name = "league_id", nullable = false)
    private League league;

    public int getGoalDifference() {
        return GoalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        GoalDifference = goalDifference;
    }

    @Column(name = "GoalDifference", nullable = false)
    private int GoalDifference = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
// Getters and Setters
}
