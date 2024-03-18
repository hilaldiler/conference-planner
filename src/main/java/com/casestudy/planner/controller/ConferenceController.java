package com.casestudy.planner.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.planner.model.Conference;
import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.service.ConferenceService;

@RestController
@RequestMapping("/conference")
public class ConferenceController {

	private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping("/plan")
    public ResponseEntity<List<Conference>> planConference(@RequestBody List<Presentation> presentations) {
        List<Conference> tracks = conferenceService.planConference(presentations);
        return ResponseEntity.ok(tracks);
    }
}
