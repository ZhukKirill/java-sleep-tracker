package ru.yandex.practicum.sleeptracker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AverageDurationDetectorTest {

    @Test
    void shouldReturnSixtyMinutes() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 0, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 2, 23, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 4, 0, 45), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        AverageDurationDetector averageDurationDetector = new AverageDurationDetector();
        String result = averageDurationDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("60"));
    }
    @Test
    void ShouldReturnfourHundredAndEightyMinutes() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 7, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 2, 23, 15),
                LocalDateTime.of(25, 10, 3, 6, 15), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 23, 15),
                LocalDateTime.of(25, 10, 4, 8, 15), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession));
        AverageDurationDetector averageDurationDetector = new AverageDurationDetector();
        String result = averageDurationDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("480"));
    }
}
