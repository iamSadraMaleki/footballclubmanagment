package com.example.project.transfer.Renewed_Player;

// 1. Model Class

import jakarta.persistence.*;

@Entity
@Table(name = "renewed_player")
public class RenewedPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(name = "shirt_number", nullable = false, unique = true)
    private int shirtNumber;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String nationality;

    @Column(name = "contract_duration", nullable = false)
    private int contractDuration;

    @Column(name = "contract_amount", nullable = false)
    private double contractAmount;

    @Column(nullable = false)
    private String agent;

    @Column(name = "staff_code", nullable = false, unique = true, length = 6)
    private String staffCode;

    @Column(name = "national_id", nullable = false)
    private String nationalId;

    // Getters and Setters

    public RenewedPlayer() {}

    public RenewedPlayer(String firstName, String lastName, int age, int shirtNumber, String position, String nationality,
                         int contractDuration, double contractAmount, String agent, String staffCode, String nationalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.nationality = nationality;
        this.contractDuration = contractDuration;
        this.contractAmount = contractAmount;
        this.agent = agent;
        this.staffCode = staffCode;
        this.nationalId = nationalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
