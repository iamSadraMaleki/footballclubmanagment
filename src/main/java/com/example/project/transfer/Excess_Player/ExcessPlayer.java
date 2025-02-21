package com.example.project.transfer.Excess_Player;


import jakarta.persistence.*;

@Entity
@Table(name = "excess_player")
public class ExcessPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_code", nullable = false, unique = true, length = 6)
    private String staffCode;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalId;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "shirt_number", nullable = false)
    private int shirtNumber;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "contract_duration", nullable = false)
    private int contractDuration;

    @Column(name = "contract_amount", nullable = false)
    private double contractAmount;

    public ExcessPlayer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
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

    @Column(name = "agent", nullable = false)
    private String agent;

    // Getters and Setters
    // Default constructor
    public ExcessPlayer(Long id, String staffCode, String firstName, String lastName, String nationalId, int age, int shirtNumber, String position, String nationality, int contractDuration, double contractAmount, String agent) {
        this.id = id;
        this.staffCode = staffCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.age = age;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.nationality = nationality;
        this.contractDuration = contractDuration;
        this.contractAmount = contractAmount;
        this.agent = agent;
    }
}
