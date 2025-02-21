package com.example.project.sport_mng.team_calendar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PublicEventRepository publicEventRepository;

    @Autowired
    private TrainingEventRepository trainingEventRepository;

    @Autowired
    private MatchEventRepository matchEventRepository;

    public Calendar createCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public List<Calendar> getAllCalendars() {
        return calendarRepository.findAll();
    }

    public void deleteCalendar(Long id) {
        calendarRepository.deleteById(id);
    }

    public Event addEventToCalendar(Long calendarId, Event event) {
        Calendar calendar = calendarRepository.findById(calendarId)
                .orElseThrow(() -> new IllegalArgumentException("Calendar not found"));
        event.setCalendar(calendar);
        return eventRepository.save(event);
    }

    public PublicEvent addPublicEvent(Long eventId, PublicEvent publicEvent) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        publicEvent.setEvent(event);
        return publicEventRepository.save(publicEvent);
    }

    public TrainingEvent addTrainingEvent(Long eventId, TrainingEvent trainingEvent) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        trainingEvent.setEvent(event);
        return trainingEventRepository.save(trainingEvent);
    }

    public MatchEvent addMatchEvent(Long eventId, MatchEvent matchEvent) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        matchEvent.setEvent(event);
        return matchEventRepository.save(matchEvent);
    }
}
