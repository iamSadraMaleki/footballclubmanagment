package com.example.project.Competitions.game_report;

import com.example.project.Competitions.season.Match;
import jakarta.persistence.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_report_id")
    private MatchReport matchReport;

    private String teamName;
    private String playerName; // زننده گل

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MatchReport getMatchReport() {
        return matchReport;
    }

    public void setMatchReport(MatchReport matchReport) {
        this.matchReport = matchReport;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    private int minute; // دقیقه به ثمر رسیدن گل
}
