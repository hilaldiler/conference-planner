package com.casestudy.planner.response;

import com.casestudy.planner.model.ConferenceSession;

public class ConferencePlanResponse {

	private int track;
	private ConferenceSession conferenceSession;

    public ConferencePlanResponse(int track, ConferenceSession conferenceSession) {
        this.conferenceSession = conferenceSession;
        this.track = track;
    }

	public ConferenceSession getConferenceSession() {
		return conferenceSession;
	}

	public void setConferenceSession(ConferenceSession conferenceSession) {
		this.conferenceSession = conferenceSession;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}
    
}
