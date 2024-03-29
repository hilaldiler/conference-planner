package com.casestudy.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.response.ConferencePlanResponse;
import com.casestudy.planner.service.ConferenceService;

@RestController
public class ConferenceController {

	private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping("/planConference")
    public List<ConferencePlanResponse> planConference(@RequestBody List<Presentation> presentations) {
        return conferenceService.planConference(presentations);
    }
}