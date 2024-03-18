package com.casestudy.planner.service;

import org.springframework.stereotype.Service;

import com.casestudy.planner.model.Conference;
import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.service.builder.ConferenceBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Override
    public List<Conference> planConference(List<Presentation> presentations) {
        List<Conference> conferences = new ArrayList<>();
        ConferenceBuilder trackBuilder = new ConferenceBuilder();

        try {
            for (Presentation presentation : presentations) {
                trackBuilder.addPresentation(presentation);
            }

            conferences.add(trackBuilder.build());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return conferences;
    }
}

