package com.casestudy.planner.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TrackTest {

    private Track track;

    @BeforeEach
    void setUp() {
        track = new Track();
    }

    @Test
    @DisplayName("Add Network Event After 5 PM Test")
    void testAddNetworkEventAfter5PM() {
        // Sabah oturumu sona erdikten sonra aşagidaki saatlere kadar network etkinligi eklenmemeli
        LocalDateTime before5PM = LocalDateTime.of(2024, 1, 1, 16, 59);
        track.setCurrentTime(before5PM);
        track.addPresentation(new Presentation("Morning Presentation", "60min"));
        track.addPresentation(new Presentation("Afternoon Presentation", "60min"));
        track.addNetworkEvent();
        assertFalse(track.canAddNetworkEvent(), "Network event should not be added after 5 PM");
    }

    @Test
    @DisplayName("Add Same Presentation Again Test")
    void testAddSamePresentationAgain() {
        // Ayni sunumun tekrar eklenmemesi gerekiyor
        Presentation presentation = new Presentation("Java Basics", "30min");
        track.addPresentation(presentation);
        assertFalse(track.canAddPresentation(presentation), "Same presentation should not be added again");
    }

    @Test
    @DisplayName("Add Lunch Time Test")
    void testAddLunchTime() {
        // Lunch time'in uygun bir sekilde eklenip eklenmedigini kontrol edin
        track.addPresentation(new Presentation("Morning Presentation", "60min"));
        track.isLunchTime();
        assertTrue(track.getCurrenTime().equals(LocalDateTime.of(2024, 1, 1, 12, 0)), "Lunch time should be added at 12:00 PM");
    }

    @Test
    @DisplayName("Add Presentation After Session End Test")
    void testAddPresentationAfterSessionEnd() {
        // Oturum bitiminden sonra sunum eklenememesi gerekiyor
        track.addPresentation(new Presentation("Morning Presentation", "60min"));
        track.addPresentation(new Presentation("Afternoon Presentation", "60min"));
        assertFalse(track.canAddPresentation(new Presentation("Evening Presentation", "30min")), "Presentation should not be added after session end");
    }

    @Test
    @DisplayName("Add Network Event After Session End Test")
    void testAddNetworkEventAfterSessionEnd() {
        // Oturum bitiminden sonra network event eklenememesi gerekiyor
        track.addPresentation(new Presentation("Morning Presentation", "60min"));
        track.addPresentation(new Presentation("Afternoon Presentation", "60min"));
        track.addNetworkEvent();
        assertFalse(track.canAddNetworkEvent(), "Network event should not be added after session end");
    }

    @Test
    @DisplayName("Add Presentation After 5 PM Test")
    void testAddPresentationAfter5PM() {
        // Saat 17'den sonra sunum eklenememesi gerekiyor
        LocalDateTime after5PM = LocalDateTime.of(2024, 1, 1, 17, 1);
        track.setCurrentTime(after5PM);
        track.addPresentation(new Presentation("Late Presentation", "30min"));
        assertFalse(track.canAddPresentation(new Presentation("Even Later Presentation", "30min")), "Presentation should not be added after 5 PM");
    }
}
