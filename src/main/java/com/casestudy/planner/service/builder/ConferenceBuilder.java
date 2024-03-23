package com.casestudy.planner.service.builder;

import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.model.Track;
import com.casestudy.planner.response.ConferencePlanResponse;

import java.util.ArrayList;
import java.util.List;

public class ConferenceBuilder {
    private List<Track> tracks;

    public ConferenceBuilder() {
        tracks = new ArrayList<>();
        tracks.add(new Track());
    }

    public List<ConferencePlanResponse> build(List<Presentation> presentations) {
        List<ConferencePlanResponse> conferencePlans = new ArrayList<>();
        int trackNumber = 1;

        Track currentTrack = tracks.get(0);
        for (Presentation presentation : presentations) {
            if (!currentTrack.canAddPresentation(presentation)) {
                if (currentTrack.isLunchTime()) {
                    currentTrack.addLunchTime();
                } else if (currentTrack.canAddNetworkEvent()) {
                    currentTrack.addNetworkEvent();
                }

                if (currentTrack.endTheTrack()) {
                    conferencePlans.addAll(currentTrack.getConferencePlanResponses(trackNumber));
                    currentTrack = getNextTrack(trackNumber);
                    trackNumber++;
                }
            }

            currentTrack.addPresentation(presentation);
        }
        
        if (currentTrack.canAddNetworkEvent()) {
            currentTrack.addNetworkEvent();
        }
        conferencePlans.addAll(currentTrack.getConferencePlanResponses(trackNumber));

        return conferencePlans;
    }

    private Track getNextTrack(int trackNumber) {
        if (tracks.size() <= trackNumber) {
            tracks.add(new Track());
        }
        return tracks.get(trackNumber);
    }
}
