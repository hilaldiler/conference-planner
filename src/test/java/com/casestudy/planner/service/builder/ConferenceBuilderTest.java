package com.casestudy.planner.service.builder;

import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.model.Track;
import com.casestudy.planner.response.ConferencePlanResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConferenceBuilderTest {
	
	private ConferenceBuilder conferenceBuilder;

    @BeforeEach
    void setUp() {
        conferenceBuilder = new ConferenceBuilder();
    }

    @Test
    @DisplayName("Build Conference Test")
    void testBuildConference() {
        List<Presentation> presentations = new ArrayList<>();
        presentations.add(new Presentation("Presentation 1", "60min"));
        presentations.add(new Presentation("Presentation 2", "45min"));
        presentations.add(new Presentation("Presentation 3", "30min"));
        presentations.add(new Presentation("Presentation 4", "lightning"));
        presentations.add(new Presentation("Presentation 5", "60min"));

        List<ConferencePlanResponse> conferencePlanResponses = conferenceBuilder.build(presentations);
        
        assertNotNull(conferencePlanResponses);
        assertFalse(conferencePlanResponses.isEmpty());
    }

    @Test
    @DisplayName("Empty Presentation List Test")
    void testBuildConferenceWithEmptyList() {
        List<Presentation> presentations = new ArrayList<>();
        List<ConferencePlanResponse> conferencePlanResponses = conferenceBuilder.build(presentations);
        assertTrue(conferencePlanResponses.isEmpty());
    }

    @Test
    @DisplayName("Null Presentation List Test")
    void testBuildConferenceWithNullList() {
        List<ConferencePlanResponse> conferencePlanResponses = conferenceBuilder.build(null);
        assertTrue(conferencePlanResponses.isEmpty());
    }

    @Test
    @DisplayName("Presentation Duration Overflow Test")
    void testBuildConferenceWithPresentationDurationOverflow() {
        // 8 saat 30 dakika süren sunumlar oluştur
        List<Presentation> presentations = new ArrayList<>();
        presentations.add(new Presentation("Long Presentation", "8h 30min"));
        List<ConferencePlanResponse> conferencePlanResponses = conferenceBuilder.build(presentations);
        assertFalse(conferencePlanResponses.isEmpty());
    }

    @Test
    @DisplayName("Large Number of Presentations Test")
    void testBuildConferenceWithLargeNumberOfPresentations() {
        // Çok sayıda sunum oluştur
        List<Presentation> presentations = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            presentations.add(new Presentation("Presentation " + i, "30min"));
        }
        List<ConferencePlanResponse> conferencePlanResponses = conferenceBuilder.build(presentations);
        assertFalse(conferencePlanResponses.isEmpty());
    }

    @Test
    @DisplayName("Empty Presentation List Test")
    void testEmptyPresentationList() {
        List<Presentation> presentations = new ArrayList<>();
        List<ConferencePlanResponse> conferencePlanResponses = conferenceBuilder.build(presentations);
        assertTrue(conferencePlanResponses.isEmpty());
    }

    @Test
    @DisplayName("Null Presentation List Test")
    void testNullPresentationList() {
        assertThrows(NullPointerException.class, () -> conferenceBuilder.build(null));
    }
}
