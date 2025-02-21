package com.example.project.transfer.transfer_goal;

import jakarta.persistence.*;

@Entity
@Table(name = "transfer_goal")
public class TransferGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private int age;

    @Column(name = "team_need_percentage", nullable = false)
    private int teamNeedPercentage;

    @Column(name = "current_team", nullable = false)
    private String currentTeam;

    // Getters and Setters

    public TransferGoal() {}

    public TransferGoal(String firstName, String lastName, String position, int age, int teamNeedPercentage, String currentTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.age = age;
        this.teamNeedPercentage = teamNeedPercentage;
        this.currentTeam = currentTeam;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeamNeedPercentage() {
        return teamNeedPercentage;
    }

    public void setTeamNeedPercentage(int teamNeedPercentage) {
        this.teamNeedPercentage = teamNeedPercentage;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(String currentTeam) {
        this.currentTeam = currentTeam;
    }
}
