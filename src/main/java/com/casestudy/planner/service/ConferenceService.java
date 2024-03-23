package com.casestudy.planner.service;

import java.util.List;

import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.response.ConferencePlanResponse;

public interface ConferenceService {

	List<ConferencePlanResponse> planConference(List<Presentation> presentations);
}

