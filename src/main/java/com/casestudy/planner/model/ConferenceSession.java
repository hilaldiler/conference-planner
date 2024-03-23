package com.casestudy.planner.model;

public class ConferenceSession {
    private String startTime;
    private String endTime;
    private Presentation presentation;

    public ConferenceSession(String startTime, String endTime, Presentation presentation) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.presentation = presentation;
    }

    
    public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public Presentation getPresentation() {
		return presentation;
	}


	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}


	@Override
    public String toString() {
        return String.format("%s %s - %s", startTime.toString(), endTime.toString(), presentation.getSubject());
    }

}

