package com.casestudy.planner.model;

public class Presentation {
	
	private String subject;
	private String duration;	
	
	public Presentation(String subject, String duration) {
		this.subject = subject;
		this.duration = duration;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
        this.duration = duration;
    }

	@Override
    public String toString() {
        return String.format("%s %s", subject, duration);
    }

}

