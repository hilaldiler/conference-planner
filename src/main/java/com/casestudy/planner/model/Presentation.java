package com.casestudy.planner.model;

public class Presentation {
	
	public String subject;
	public int duration;	
	
	public Presentation(String subject, int duration) {
		this.subject = subject;
		this.duration = duration;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
