package com.example.project.transfer.transfer_report;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferReportRepository extends JpaRepository<TransferReport, Long> {
    void deleteByFirstNameAndLastName(String firstName, String lastName);
}
