package com.example.project.financial.sponsoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService {
    @Autowired
    private SponsorRepository sponsorRepository;

    @Autowired
    private ContractConditionRepository contractConditionRepository;

    // ثبت اسپانسر جدید
    public Sponsor addSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    // ویرایش اسپانسر
    public Sponsor updateSponsor(Long sponsorId, Sponsor updatedSponsor) {
        Sponsor existingSponsor = sponsorRepository.findById(sponsorId)
                .orElseThrow(() -> new IllegalArgumentException("Sponsor not found"));

        existingSponsor.setName(updatedSponsor.getName());
        existingSponsor.setCompanyType(updatedSponsor.getCompanyType());
        existingSponsor.setTradeCode(updatedSponsor.getTradeCode());
        existingSponsor.setContractStartDate(updatedSponsor.getContractStartDate());
        existingSponsor.setContractAmount(updatedSponsor.getContractAmount());
        existingSponsor.setCeoName(updatedSponsor.getCeoName());
        return sponsorRepository.save(existingSponsor);
    }

    // حذف اسپانسر
    public void deleteSponsor(Long sponsorId) {
        sponsorRepository.deleteById(sponsorId);
    }

    // مشاهده لیست اسپانسرها
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    // افزودن شرایط قرارداد
    public ContractCondition addContractCondition(Long sponsorId, ContractCondition condition) {
        Sponsor sponsor = sponsorRepository.findById(sponsorId)
                .orElseThrow(() -> new IllegalArgumentException("Sponsor not found"));

        condition.setSponsor(sponsor);
        return contractConditionRepository.save(condition);
    }

    // مشاهده شرایط قرارداد برای اسپانسر
    public List<ContractCondition> getContractConditionsBySponsor(Long sponsorId) {
        return contractConditionRepository.findAll()
                .stream()
                .filter(condition -> condition.getSponsor().getId().equals(sponsorId))
                .toList();
    }
}

