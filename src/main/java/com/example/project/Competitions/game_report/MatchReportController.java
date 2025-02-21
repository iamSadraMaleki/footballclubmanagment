package com.example.project.Competitions.game_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match-reports")
public class MatchReportController {

    @Autowired
    private MatchReportService matchReportService;

    // ایجاد گزارش بازی
    @PostMapping("/create")
    public ResponseEntity<?> createMatchReport(@RequestParam Long matchId, @RequestParam String summary) {
        try {
            MatchReport report = matchReportService.createMatchReport(matchId, summary);
            return ResponseEntity.ok(report);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // افزودن ترکیب تیم
    @PostMapping("/{reportId}/add-composition")
    public ResponseEntity<?> addTeamComposition(@PathVariable Long reportId, @RequestBody TeamComposition composition) {
        try {
            matchReportService.addTeamCompositionToReport(reportId, composition);
            return ResponseEntity.ok("Team composition added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // افزودن کارت
    @PostMapping("/{reportId}/add-card")
    public ResponseEntity<?> addCard(@PathVariable Long reportId, @RequestBody Card card) {
        try {
            matchReportService.addCardToReport(reportId, card);
            return ResponseEntity.ok("Card added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // افزودن گل
    @PostMapping("/{reportId}/add-goal")
    public ResponseEntity<?> addGoal(@PathVariable Long reportId, @RequestBody Goal goal) {
        try {
            matchReportService.addGoalToReport(reportId, goal);
            return ResponseEntity.ok("Goal added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // افزودن پرسنل
    @PostMapping("/{reportId}/add-staff")
    public ResponseEntity<?> addStaff(@PathVariable Long reportId, @RequestBody Staff staff) {
        try {
            matchReportService.addStaffToReport(reportId, staff);
            return ResponseEntity.ok("Staff added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // افزودن کادر فنی
    @PostMapping("/{reportId}/add-coaching-staff")
    public ResponseEntity<?> addCoachingStaff(@PathVariable Long reportId, @RequestBody CoachingStaff staff) {
        try {
            matchReportService.addCoachingStaffToReport(reportId, staff);
            return ResponseEntity.ok("Coaching staff added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // افزودن کیت تیم
    @PostMapping("/{reportId}/add-kit")
    public ResponseEntity<?> addTeamKit(@PathVariable Long reportId, @RequestBody TeamKit kit) {
        try {
            matchReportService.addTeamKitToReport(reportId, kit);
            return ResponseEntity.ok("Team kit added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
