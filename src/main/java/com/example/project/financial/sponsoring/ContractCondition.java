package com.example.project.financial.sponsoring;

import jakarta.persistence.*;

@Entity
public class ContractCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sponsor_id")
    private Sponsor sponsor;

    private String terminationClause; // بند فسخ
    private String extensionClause; // بند تمدید
    private String description; // توضیحات قرارداد

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public String getTerminationClause() {
        return terminationClause;
    }

    public void setTerminationClause(String terminationClause) {
        this.terminationClause = terminationClause;
    }

    public String getExtensionClause() {
        return extensionClause;
    }

    public void setExtensionClause(String extensionClause) {
        this.extensionClause = extensionClause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
