package com.casestudy.planner.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlannerUtilsTest {
	
	@Test
    @DisplayName("Valid Duration Format Test")
    void testValidDurationFormat() {
        assertEquals(30, PlannerUtils.parseDuration("30min"));
        assertEquals(5, PlannerUtils.parseDuration("lightning"));
    }

    @Test
    @DisplayName("Invalid Duration Format Test")
    void testInvalidDurationFormat() {
        assertThrows(IllegalArgumentException.class, () -> PlannerUtils.parseDuration("InvalidDuration"));
        assertThrows(IllegalArgumentException.class, () -> PlannerUtils.parseDuration("60min"));
    }

    @Test
    @DisplayName("Time Format Test")
    void testTimeFormat() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 12, 30);
        assertEquals("12:30PM", PlannerUtils.formatTime(dateTime));
    }
    
    @Test
    @DisplayName("Null Argument Test")
    void testNullArgument() {
        assertThrows(NullPointerException.class, () -> PlannerUtils.parseDuration(null));
    }

    @Test
    @DisplayName("Empty Argument Test")
    void testEmptyArgument() {
        assertThrows(IllegalArgumentException.class, () -> PlannerUtils.parseDuration(""));
    }

    @Test
    @DisplayName("Invalid Time Format Test")
    void testInvalidTimeFormat() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 1, 1, 25, 30);
        assertThrows(DateTimeException.class, () -> PlannerUtils.formatTime(dateTime));
    }

}
