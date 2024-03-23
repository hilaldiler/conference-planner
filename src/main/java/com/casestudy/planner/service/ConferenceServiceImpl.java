package com.casestudy.planner.service;

import org.springframework.stereotype.Service;

import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.response.ConferencePlanResponse;
import com.casestudy.planner.service.builder.ConferenceBuilder;

import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

	@Override
    public List<ConferencePlanResponse> planConference(List<Presentation> presentations) {
		ConferenceBuilder conferenceBuilder = new ConferenceBuilder();
        return conferenceBuilder.build(presentations);       
    }
}


