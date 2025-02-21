package com.example.project.Competitions.season;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leagues")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    @JsonBackReference
    private Season season;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<LeagueTable> leagueTable = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public List<LeagueTable> getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(List<LeagueTable> leagueTable) {
        this.leagueTable = leagueTable;
    }

    // Getters and Setters
}
