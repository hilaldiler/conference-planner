package com.casestudy.planner.model;

import java.util.ArrayList;
import java.util.List;

public class Conference {
    private List<ConferenceSession> morningSessions;
    private List<ConferenceSession> afternoonSessions;

    public Conference() {
        this.morningSessions = new ArrayList<>();
        this.afternoonSessions = new ArrayList<>();
    }

    public void addMorningSession(ConferenceSession session) {
        morningSessions.add(session);
    }

    public void addAfternoonSession(ConferenceSession session) {
        afternoonSessions.add(session);
    }

    public List<ConferenceSession> getMorningSessions() {
        return morningSessions;
    }

    public List<ConferenceSession> getAfternoonSessions() {
        return afternoonSessions;
    }
}

