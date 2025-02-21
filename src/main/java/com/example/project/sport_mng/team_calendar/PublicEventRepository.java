package com.example.project.sport_mng.team_calendar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicEventRepository extends JpaRepository<PublicEvent, Long> {
}