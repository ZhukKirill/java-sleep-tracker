package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MinSessionDetectorTest {

    @Test
    void shouldReturnFifteenMinutes() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 7, 30), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 3, 8, 30), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 3, 23, 30), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        MinSessionDetector minDetector = new MinSessionDetector();
        String result = minDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("15"));
    }

    @Test
    void  shouldReturnOneMinutes() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 7, 30), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 2, 23, 16), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 3, 23, 30), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        MinSessionDetector minDetector = new MinSessionDetector();
        String result = minDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("1"));
    }

}
