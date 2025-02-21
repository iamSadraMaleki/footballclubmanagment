package com.example.project.Competitions.game_report;

import com.example.project.Competitions.season.Match;
import jakarta.persistence.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class MatchReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match; // ارتباط با جدول بازی

    private String summary; // خلاصه گزارش

    @OneToMany(mappedBy = "matchReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamComposition> teamCompositions; // ترکیب تیم‌ها

    @OneToMany(mappedBy = "matchReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards; // کارت‌های بازی

    @OneToMany(mappedBy = "matchReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Goal> goals; // گل‌ها

    @OneToMany(mappedBy = "matchReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Staff> staffs; // پرسنل بازی (داور، ناظر و غیره)

    @OneToMany(mappedBy = "matchReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CoachingStaff> coachingStaffs; // کادر فنی

    @OneToMany(mappedBy = "matchReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamKit> teamKits; // رنگ کیت تیم‌ها

    // متدهای getter و setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<TeamComposition> getTeamCompositions() {
        return teamCompositions;
    }

    public void setTeamCompositions(List<TeamComposition> teamCompositions) {
        this.teamCompositions = teamCompositions;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<CoachingStaff> getCoachingStaffs() {
        return coachingStaffs;
    }

    public void setCoachingStaffs(List<CoachingStaff> coachingStaffs) {
        this.coachingStaffs = coachingStaffs;
    }

    public List<TeamKit> getTeamKits() {
        return teamKits;
    }

    public void setTeamKits(List<TeamKit> teamKits) {
        this.teamKits = teamKits;
    }
}

