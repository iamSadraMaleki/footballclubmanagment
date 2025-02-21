package com.example.project.transfer.transfer_report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/transfer-reports")
public class TransferReportController {

    @Autowired
    private TransferReportService transferReportService;

    @GetMapping("/buy")
    public String showBuyPage() {
        return "transfer_report"; // تمام اطلاعات در buy_form نمایش داده می‌شود
    }

    @GetMapping
    public List<TransferReport> getAllReports() {
        return transferReportService.getAllReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferReport> getReportById(@PathVariable Long id) {
        Optional<TransferReport> report = transferReportService.getReportById(id);
        return report.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TransferReport createReport(@RequestBody TransferReport report) {
        return transferReportService.saveReport(report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferReport> updateReport(@PathVariable Long id, @RequestBody TransferReport updatedReport) {
        Optional<TransferReport> existingReport = transferReportService.getReportById(id);
        if (existingReport.isPresent()) {
            TransferReport report = existingReport.get();
            report.setFirstName(updatedReport.getFirstName());
            report.setLastName(updatedReport.getLastName());
            report.setAge(updatedReport.getAge());
            report.setPosition(updatedReport.getPosition());
            report.setNationality(updatedReport.getNationality());
            report.setTransferType(updatedReport.getTransferType());
            transferReportService.saveReport(report);
            return ResponseEntity.ok(report);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        Optional<TransferReport> existingReport = transferReportService.getReportById(id);
        if (existingReport.isPresent()) {
            transferReportService.deleteReport(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}