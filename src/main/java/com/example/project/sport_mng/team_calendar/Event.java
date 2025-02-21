package com.example.project.sport_mng.team_calendar;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType; // عمومی، تمرین، بازی

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private PublicEvent publicEvent;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private TrainingEvent trainingEvent;

    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL)
    private MatchEvent matchEvent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public PublicEvent getPublicEvent() {
        return publicEvent;
    }

    public void setPublicEvent(PublicEvent publicEvent) {
        this.publicEvent = publicEvent;
    }

    public TrainingEvent getTrainingEvent() {
        return trainingEvent;
    }

    public void setTrainingEvent(TrainingEvent trainingEvent) {
        this.trainingEvent = trainingEvent;
    }

    public MatchEvent getMatchEvent() {
        return matchEvent;
    }

    public void setMatchEvent(MatchEvent matchEvent) {
        this.matchEvent = matchEvent;
    }
}
