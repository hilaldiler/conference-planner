package com.casestudy.planner.service.builder;

import java.time.LocalTime;

import com.casestudy.planner.model.Conference;
import com.casestudy.planner.model.ConferenceSession;
import com.casestudy.planner.model.Presentation;

public class ConferenceBuilder {
    private final LocalTime MORNING_SESSION_START_TIME = LocalTime.of(9, 0);
    private final LocalTime MORNING_SESSION_END_TIME = LocalTime.of(12, 0);
    private final LocalTime AFTERNOON_SESSION_START_TIME = LocalTime.of(13, 0);
    private final LocalTime AFTERNOON_SESSION_END_TIME = LocalTime.of(17, 0);
    private final int LIGHTNING_DURATION_MINUTES = 5;

    private Conference conference;
    private LocalTime currentTime;

    public ConferenceBuilder() {
        this.conference = new Conference();
        this.currentTime = MORNING_SESSION_START_TIME;
    }

    public boolean isMorningSessionAvailable() {
        return currentTime.isBefore(MORNING_SESSION_END_TIME);
    }

    public boolean isAfternoonSessionAvailable() {
        return currentTime.isBefore(AFTERNOON_SESSION_END_TIME);
    }

    public void addPresentation(Presentation presentation) throws IllegalStateException {
        if (presentation.getDuration() == LIGHTNING_DURATION_MINUTES) {
            presentation.setDuration(LIGHTNING_DURATION_MINUTES);
        }

        LocalTime sessionEndTime = currentTime.plusMinutes(presentation.getDuration());

        if (isMorningSessionAvailable()) {
            if (sessionEndTime.isBefore(MORNING_SESSION_END_TIME) || sessionEndTime.equals(MORNING_SESSION_END_TIME)) {
            	conference.addMorningSession(new ConferenceSession(currentTime, sessionEndTime, presentation));
                currentTime = sessionEndTime;
                return;
            }
        }

        if (isAfternoonSessionAvailable()) {
            if (sessionEndTime.isBefore(AFTERNOON_SESSION_END_TIME) || sessionEndTime.equals(AFTERNOON_SESSION_END_TIME)) {
            	conference.addAfternoonSession(new ConferenceSession(currentTime, sessionEndTime, presentation));
                currentTime = sessionEndTime;
                return;
            }
        }

        throw new IllegalStateException("Cannot add presentation: Time slot is full.");
    }

    public Conference build() {
        return conference;
    }
}
