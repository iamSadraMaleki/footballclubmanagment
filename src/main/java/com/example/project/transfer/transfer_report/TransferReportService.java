package com.example.project.transfer.transfer_report;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferReportService {

    @Autowired
    private TransferReportRepository transferReportRepository;

    public List<TransferReport> getAllReports() {
        return transferReportRepository.findAll();
    }

    public Optional<TransferReport> getReportById(Long id) {
        return transferReportRepository.findById(id);
    }

    public TransferReport saveReport(TransferReport report) {
        return transferReportRepository.save(report);
    }

    public void deleteReport(Long id) {
        transferReportRepository.deleteById(id);
    }
}
