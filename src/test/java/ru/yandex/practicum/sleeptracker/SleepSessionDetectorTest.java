package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SleepSessionDetectorTest {

    @Test
    void shouldReturnCorrectAmount() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 7, 30), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 3, 7, 30), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession));
        SleepSessionDetector sessionDetector = new SleepSessionDetector();
        String result = sessionDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("2"));
    }

    @Test
    void shouldReturnCorrectZero() {
        List<SleepingSession> sleepingSessions = new ArrayList<>();
        SleepSessionDetector sessionDetector = new SleepSessionDetector();
        String result = sessionDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("0"));
    }
}