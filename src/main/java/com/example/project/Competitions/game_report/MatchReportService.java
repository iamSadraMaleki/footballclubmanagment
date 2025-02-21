package com.example.project.Competitions.game_report;

import com.example.project.Competitions.season.Match;
import com.example.project.Competitions.season.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchReportService {
    @Autowired
    private MatchReportRepository matchReportRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamCompositionRepository teamCompositionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private CoachingStaffRepository coachingStaffRepository;

    @Autowired
    private TeamKitRepository teamKitRepository;

    // ایجاد گزارش بازی
    public MatchReport createMatchReport(Long matchId, String summary) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new IllegalArgumentException("Match with ID " + matchId + " not found"));

        MatchReport report = new MatchReport();
        report.setMatch(match);
        report.setSummary(summary);

        return matchReportRepository.save(report);
    }

    // افزودن ترکیب تیم
    public void addTeamCompositionToReport(Long matchReportId, TeamComposition composition) {
        MatchReport report = matchReportRepository.findById(matchReportId)
                .orElseThrow(() -> new IllegalArgumentException("Match Report with ID " + matchReportId + " not found"));

        composition.setMatchReport(report);
        teamCompositionRepository.save(composition);
    }

    // افزودن کارت
    public void addCardToReport(Long matchReportId, Card card) {
        MatchReport report = matchReportRepository.findById(matchReportId)
                .orElseThrow(() -> new IllegalArgumentException("Match Report with ID " + matchReportId + " not found"));

        card.setMatchReport(report);
        cardRepository.save(card);
    }

    // افزودن گل
    public void addGoalToReport(Long matchReportId, Goal goal) {
        MatchReport report = matchReportRepository.findById(matchReportId)
                .orElseThrow(() -> new IllegalArgumentException("Match Report with ID " + matchReportId + " not found"));

        goal.setMatchReport(report);
        goalRepository.save(goal);
    }

    // افزودن پرسنل
    public void addStaffToReport(Long matchReportId, Staff staff) {
        MatchReport report = matchReportRepository.findById(matchReportId)
                .orElseThrow(() -> new IllegalArgumentException("Match Report with ID " + matchReportId + " not found"));

        staff.setMatchReport(report);
        staffRepository.save(staff);
    }

    // افزودن کادر فنی
    public void addCoachingStaffToReport(Long matchReportId, CoachingStaff staff) {
        MatchReport report = matchReportRepository.findById(matchReportId)
                .orElseThrow(() -> new IllegalArgumentException("Match Report with ID " + matchReportId + " not found"));

        staff.setMatchReport(report);
        coachingStaffRepository.save(staff);
    }

    // افزودن کیت تیم
    public void addTeamKitToReport(Long matchReportId, TeamKit kit) {
        MatchReport report = matchReportRepository.findById(matchReportId)
                .orElseThrow(() -> new IllegalArgumentException("Match Report with ID " + matchReportId + " not found"));

        kit.setMatchReport(report);
        teamKitRepository.save(kit);
    }
}

