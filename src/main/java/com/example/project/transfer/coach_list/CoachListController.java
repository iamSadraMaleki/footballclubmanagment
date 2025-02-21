package com.example.project.transfer.coach_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachListController {

    @Autowired
    private CoachListService coachListService;

    // افزودن مربی جدید
    @PostMapping
    public ResponseEntity<CoachList> addCoach(@RequestBody CoachList coach) {
        return ResponseEntity.ok(coachListService.addCoach(coach));
    }

    // دریافت لیست همه مربیان
    @GetMapping
    public ResponseEntity<List<CoachList>> getAllCoaches() {
        return ResponseEntity.ok(coachListService.getAllCoaches());
    }

    // دریافت جزئیات مربی بر اساس ID
    @GetMapping("/{id}")
    public ResponseEntity<CoachList> getCoachById(@PathVariable Long id) {
        return ResponseEntity.ok(coachListService.getCoachById(id));
    }

    // ویرایش اطلاعات مربی
    @PutMapping("/{id}")
    public ResponseEntity<CoachList> updateCoach(@PathVariable Long id, @RequestBody CoachList updatedCoach) {
        return ResponseEntity.ok(coachListService.updateCoach(id, updatedCoach));
    }

    // حذف مربی
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCoach(@PathVariable Long id) {
        coachListService.deleteCoachById(id);
        return ResponseEntity.ok("مربی با موفقیت حذف شد");
    }
}
