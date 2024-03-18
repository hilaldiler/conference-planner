package com.casestudy.planner.service;

import java.util.List;

import com.casestudy.planner.model.Conference;
import com.casestudy.planner.model.Presentation;

public interface ConferenceService {

	List<Conference> planConference(List<Presentation> presentations);
}
