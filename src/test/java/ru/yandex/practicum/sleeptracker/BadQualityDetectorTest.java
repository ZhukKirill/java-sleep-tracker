package ru.yandex.practicum.sleeptracker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BadQualityDetectorTest {

    @Test
    void shouldReturnThreeBadSessions() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 7, 15), Quality.BAD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 3, 6, 15), Quality.BAD);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 4, 8, 15), Quality.BAD);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        BadQualityDetector badQualityDetector = new BadQualityDetector();
        String result = badQualityDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("3"));
    }

    @Test
    void shouldReturnZeroBadSessions() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 7, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 3, 6, 15), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 4, 8, 15), Quality.GOOD);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        BadQualityDetector badQualityDetector = new BadQualityDetector();
        String result = badQualityDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("0"));
    }
}
