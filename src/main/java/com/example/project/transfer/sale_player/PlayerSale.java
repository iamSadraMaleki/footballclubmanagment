package com.example.project.transfer.sale_player;



import jakarta.persistence.*;

@Entity
@Table(name = "player_sale")
public class PlayerSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public String getSeparationType() {
        return separationType;
    }

    public void setSeparationType(String separationType) {
        this.separationType = separationType;
    }

    public double getReleaseClause() {
        return releaseClause;
    }

    public void setReleaseClause(double releaseClause) {
        this.releaseClause = releaseClause;
    }

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

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

    @Column(name = "agent", nullable = false)
    private String agent;

    @Column(name = "staff_code", nullable = false, unique = true, length = 6)
    private String staffCode;

    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalId;

    @Column(name = "separation_type", nullable = false)
    private String separationType;

    @Column(name = "release_clause", nullable = false)
    private double releaseClause;

    // Getters and Setters
    // Default Constructor and Parameterized Constructor
}
