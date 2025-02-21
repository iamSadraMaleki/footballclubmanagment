package com.example.project.Competitions.game_report;

import com.example.project.Competitions.season.Match;
import jakarta.persistence.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class TeamKit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_report_id")
    private MatchReport matchReport;

    private String teamName;
    private String jerseyColor;
    private String shortsColor;
    private String socksColor;

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

    public String getJerseyColor() {
        return jerseyColor;
    }

    public void setJerseyColor(String jerseyColor) {
        this.jerseyColor = jerseyColor;
    }

    public String getShortsColor() {
        return shortsColor;
    }

    public void setShortsColor(String shortsColor) {
        this.shortsColor = shortsColor;
    }

    public String getSocksColor() {
        return socksColor;
    }

    public void setSocksColor(String socksColor) {
        this.socksColor = socksColor;
    }
}
