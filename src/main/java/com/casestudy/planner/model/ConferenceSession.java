package com.casestudy.planner.model;

import java.time.LocalTime;

public class ConferenceSession {
    private LocalTime startTime;
    private LocalTime endTime;
    private Presentation presentation;

    public ConferenceSession(LocalTime startTime, LocalTime endTime, Presentation presentation) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.presentation = presentation;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}

