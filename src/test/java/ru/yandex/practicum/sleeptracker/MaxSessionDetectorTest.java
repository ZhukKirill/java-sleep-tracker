package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MaxSessionDetectorTest {

    @Test
    void shouldReturnfourHundredAndEightyMinutes() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 7, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 3, 6, 30), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 3, 23, 30), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        MaxSessionDetector maxDetector = new MaxSessionDetector();
        String result = maxDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("480"));
    }

    @Test
    void shouldReturnThirtyMinutes() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 1, 23, 20), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 2, 23, 25), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 3, 23, 45), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        MaxSessionDetector maxDetector = new MaxSessionDetector();
        String result = maxDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("30"));
    }
}
