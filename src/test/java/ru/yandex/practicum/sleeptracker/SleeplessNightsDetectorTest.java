package ru.yandex.practicum.sleeptracker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SleeplessNightsDetectorTest {

    @Test
    void shouldReturnTwoSleeplessSessionsInFourNights() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 20, 15),
                LocalDateTime.of(25, 10, 1, 23, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 14, 15),
                LocalDateTime.of(25, 10, 2, 18, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 4, 6, 45), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 5,5 ,15),
                LocalDateTime.of(25, 10, 5, 13, 45), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        SleeplessNightsDetector sleeplessNightsDetector = new SleeplessNightsDetector();
        String result = sleeplessNightsDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("2"));
    }

    @Test
    void shouldReturnOneSleeplessSessionInFourNights() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 10, 15),
                LocalDateTime.of(25, 10, 1, 23, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 22, 15),
                LocalDateTime.of(25, 10, 2, 3, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 0, 0),
                LocalDateTime.of(25, 10, 3, 6, 0), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 4,5 ,15),
                LocalDateTime.of(25, 10, 4, 13, 45), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        SleeplessNightsDetector sleeplessNightsDetector = new SleeplessNightsDetector();
        String result = sleeplessNightsDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("1"));
    }

    @Test
    void shouldReturnZeroSleeplessSessionInFourNights() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 1, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 0, 15),
                LocalDateTime.of(25, 10, 3, 4, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 4, 5, 59),
                LocalDateTime.of(25, 10, 4, 10, 0), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 4,19 ,15),
                LocalDateTime.of(25, 10, 5, 0, 1), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        SleeplessNightsDetector sleeplessNightsDetector = new SleeplessNightsDetector();
        String result = sleeplessNightsDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("0"));
    }

    @Test
    void shouldReturnFourSleeplessSessionInFourNights() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 20, 15),
                LocalDateTime.of(25, 10, 1, 23, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 14, 15),
                LocalDateTime.of(25, 10, 2, 18, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 18, 15),
                LocalDateTime.of(25, 10, 3, 23, 59), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 5,6 ,1),
                LocalDateTime.of(25, 10, 5, 13, 45), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        SleeplessNightsDetector sleeplessNightsDetector = new SleeplessNightsDetector();
        String result = sleeplessNightsDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("4"));
    }
}
