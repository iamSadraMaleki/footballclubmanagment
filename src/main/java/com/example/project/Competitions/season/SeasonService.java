package com.example.project.Competitions.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    public Season createSeason(Season season) {
        return seasonRepository.save(season);
    }

    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }
}


