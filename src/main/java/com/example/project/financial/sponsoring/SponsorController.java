package com.example.project.financial.sponsoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sponsors")
public class SponsorController {
    @Autowired
    private SponsorService sponsorService;

    // ثبت اسپانسر جدید
    @PostMapping("/add")
    public ResponseEntity<Sponsor> addSponsor(@RequestBody Sponsor sponsor) {
        Sponsor createdSponsor = sponsorService.addSponsor(sponsor);
        return ResponseEntity.ok(createdSponsor);
    }

    // ویرایش اسپانسر
    @PutMapping("/update/{sponsorId}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable Long sponsorId, @RequestBody Sponsor sponsor) {
        Sponsor updatedSponsor = sponsorService.updateSponsor(sponsorId, sponsor);
        return ResponseEntity.ok(updatedSponsor);
    }

    // حذف اسپانسر
    @DeleteMapping("/delete/{sponsorId}")
    public ResponseEntity<String> deleteSponsor(@PathVariable Long sponsorId) {
        sponsorService.deleteSponsor(sponsorId);
        return ResponseEntity.ok("Sponsor deleted successfully");
    }

    // مشاهده لیست اسپانسرها
    @GetMapping
    public ResponseEntity<List<Sponsor>> getAllSponsors() {
        List<Sponsor> sponsors = sponsorService.getAllSponsors();
        return ResponseEntity.ok(sponsors);
    }

    // افزودن شرایط قرارداد
    @PostMapping("/{sponsorId}/add-condition")
    public ResponseEntity<ContractCondition> addContractCondition(@PathVariable Long sponsorId, @RequestBody ContractCondition condition) {
        ContractCondition addedCondition = sponsorService.addContractCondition(sponsorId, condition);
        return ResponseEntity.ok(addedCondition);
    }

    // مشاهده شرایط قرارداد برای یک اسپانسر
    @GetMapping("/{sponsorId}/conditions")
    public ResponseEntity<List<ContractCondition>> getContractConditions(@PathVariable Long sponsorId) {
        List<ContractCondition> conditions = sponsorService.getContractConditionsBySponsor(sponsorId);
        return ResponseEntity.ok(conditions);
    }
}

