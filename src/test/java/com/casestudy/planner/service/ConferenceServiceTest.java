package com.casestudy.planner.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.casestudy.planner.model.Presentation;
import com.casestudy.planner.response.ConferencePlanResponse;

public class ConferenceServiceTest {

	private ConferenceServiceImpl conferenceService;

    @BeforeEach
    void setUp() {
        conferenceService = new ConferenceServiceImpl();
    }

    @Test
    @DisplayName("Plan Conference with Invalid Presentation Duration Test")
    void testPlanConferenceWithInvalidPresentationDuration() {
        List<Presentation> presentations = new ArrayList<>();
        presentations.add(new Presentation("Presentation 1", "-30min")); // Negatif bir süre
        List<ConferencePlanResponse> conferencePlanResponses = conferenceService.planConference(presentations);
        assertTrue(conferencePlanResponses.isEmpty()); // Geçersiz sunumlar eklenmediğinden boş bir plan dönmesi beklenir
    }

    @Test
    @DisplayName("Plan Conference with Extreme Case Test")
    void testPlanConferenceWithExtremeCase() {
        List<Presentation> presentations = new ArrayList<>();
        // Çok büyük bir sunum listesi oluşturulabilir
        for (int i = 0; i < 1000; i++) {
            presentations.add(new Presentation("Presentation " + (i + 1), "60min"));
        }
        List<ConferencePlanResponse> conferencePlanResponses = conferenceService.planConference(presentations);
        assertNotNull(conferencePlanResponses); // Sonuç null olmamalı
        assertFalse(conferencePlanResponses.isEmpty()); // Plan boş olmamalı
        // Diğer olası assertler buraya eklenebilir
    }

}
