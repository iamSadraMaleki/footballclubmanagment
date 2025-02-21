package com.example.project.sport_mng.team_calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @PostMapping("/create")
    public ResponseEntity<Calendar> createCalendar(@RequestBody Calendar calendar) {
        return ResponseEntity.ok(calendarService.createCalendar(calendar));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Calendar>> getAllCalendars() {
        return ResponseEntity.ok(calendarService.getAllCalendars());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCalendar(@PathVariable Long id) {
        calendarService.deleteCalendar(id);
        return ResponseEntity.ok("Calendar deleted successfully");
    }

    @PostMapping("/{calendarId}/add-event")
    public ResponseEntity<Event> addEventToCalendar(@PathVariable Long calendarId, @RequestBody Event event) {
        return ResponseEntity.ok(calendarService.addEventToCalendar(calendarId, event));
    }

    @PostMapping("/event/{eventId}/add-public")
    public ResponseEntity<PublicEvent> addPublicEvent(@PathVariable Long eventId, @RequestBody PublicEvent publicEvent) {
        return ResponseEntity.ok(calendarService.addPublicEvent(eventId, publicEvent));
    }

    @PostMapping("/event/{eventId}/add-training")
    public ResponseEntity<TrainingEvent> addTrainingEvent(@PathVariable Long eventId, @RequestBody TrainingEvent trainingEvent) {
        return ResponseEntity.ok(calendarService.addTrainingEvent(eventId, trainingEvent));
    }

    @PostMapping("/event/{eventId}/add-match")
    public ResponseEntity<MatchEvent> addMatchEvent(@PathVariable Long eventId, @RequestBody MatchEvent matchEvent) {
        return ResponseEntity.ok(calendarService.addMatchEvent(eventId, matchEvent));
    }
}

