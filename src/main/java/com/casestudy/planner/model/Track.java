package com.casestudy.planner.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.casestudy.planner.response.ConferencePlanResponse;

public class Track {
	private final LocalDateTime MORNING_SESSION_START_TIME = LocalDateTime.of(2024, 1, 1, 9, 0);
    private final LocalDateTime MORNING_SESSION_END_TIME = LocalDateTime.of(2024, 1, 1, 12, 0);
    private final LocalDateTime AFTERNOON_SESSION_START_TIME = LocalDateTime.of(2024, 1, 1, 13, 0);
    private final LocalDateTime AFTERNOON_SESSION_END_TIME = LocalDateTime.of(2024, 1, 1, 17, 0);
    private final LocalDateTime NETWORK_SESSION_START_TIME = LocalDateTime.of(2024, 1, 1, 16, 0);
    
    private List<ConferenceSession> sessions;
    private LocalDateTime currentTime;

    public Track() {
        sessions = new ArrayList<>();
        currentTime = MORNING_SESSION_START_TIME;
    }

    public LocalDateTime getCurrenTime() {
    	return this.currentTime;
    } 
    
    public void setCurrentTime(LocalDateTime currenTime) {
    	this.currentTime = currentTime;
    }  
    
    public boolean canAddPresentation(Presentation presentation) {
        int duration = PlannerUtils.parseDuration(presentation.getDuration());
        LocalDateTime sessionEndTime = currentTime.plusMinutes(duration);
        if ((currentTime.isBefore(MORNING_SESSION_END_TIME) && sessionEndTime.isBefore(MORNING_SESSION_END_TIME)) || 
        		(currentTime.isBefore(MORNING_SESSION_END_TIME) && sessionEndTime.equals(MORNING_SESSION_END_TIME))) {
            return true;
        }
        if (currentTime.equals(MORNING_SESSION_END_TIME)) {
            return false; 
        }
        if ((currentTime.isAfter(MORNING_SESSION_END_TIME) && currentTime.isBefore(AFTERNOON_SESSION_END_TIME) && sessionEndTime.isBefore(AFTERNOON_SESSION_END_TIME)) || 
        		(currentTime.isAfter(MORNING_SESSION_END_TIME) && currentTime.isBefore(AFTERNOON_SESSION_END_TIME) && sessionEndTime.equals(AFTERNOON_SESSION_END_TIME))) {
            return true;
        }
        			
        return false;
    }
    
    public boolean endTheTrack() {
    	return currentTime.equals(AFTERNOON_SESSION_END_TIME);
    }
    
    public boolean canAddNetworkEvent() {
    	if(currentTime.isAfter(MORNING_SESSION_END_TIME) && currentTime.isBefore(AFTERNOON_SESSION_END_TIME) && 
    			(currentTime.equals(NETWORK_SESSION_START_TIME) || currentTime.isAfter(NETWORK_SESSION_START_TIME))) {
    		return true;
    	}
    	return false;
    }
    
    public boolean isLunchTime() {
        if(currentTime.isBefore(MORNING_SESSION_END_TIME) || currentTime.equals(MORNING_SESSION_END_TIME))  {
        	currentTime = MORNING_SESSION_END_TIME;
        	return true;
        }        	
        
        return false;
    }
    
    public void addLunchTime() {
    	Presentation presentation = new Presentation("Lunch", "");
    	LocalDateTime sessionEndTime = AFTERNOON_SESSION_START_TIME;
    	sessions.add(new ConferenceSession(PlannerUtils.formatTime(MORNING_SESSION_END_TIME), PlannerUtils.formatTime(sessionEndTime), presentation));
        currentTime = sessionEndTime;
    }

    public void addPresentation(Presentation presentation) {
        int duration = PlannerUtils.parseDuration(presentation.getDuration());
        LocalDateTime sessionEndTime = currentTime.plusMinutes(duration);
        boolean isExist = sessions.parallelStream().anyMatch(session -> session.getPresentation().equals(presentation));

        if (canAddPresentation(presentation) && !isExist) {
            sessions.add(new ConferenceSession(PlannerUtils.formatTime(currentTime), PlannerUtils.formatTime(sessionEndTime), presentation));
            currentTime = sessionEndTime;
        }
    }
    
    public void addNetworkEvent() {
    	Presentation network = new Presentation("Network Event", "");
    	LocalDateTime networkEndTime = AFTERNOON_SESSION_END_TIME;
    	LocalDateTime networkSessionStart = currentTime.isAfter(NETWORK_SESSION_START_TIME) ? currentTime : NETWORK_SESSION_START_TIME;
    	sessions.add(new ConferenceSession(PlannerUtils.formatTime(networkSessionStart), PlannerUtils.formatTime(networkEndTime), network));
        currentTime = networkEndTime;
    }
    
    public List<ConferencePlanResponse> getConferencePlanResponses(int trackNumber) {
        List<ConferencePlanResponse> responses = new ArrayList<>();        
        for (ConferenceSession session : sessions) {
            responses.add(new ConferencePlanResponse(trackNumber, session));
        }
        return responses;
    }

}
