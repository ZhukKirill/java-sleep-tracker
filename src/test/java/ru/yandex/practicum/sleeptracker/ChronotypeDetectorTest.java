package ru.yandex.practicum.sleeptracker;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChronotypeDetectorTest {

    @Test
    void shouldReturnOwlChronotypeWithMostOwlSessions() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 9, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 0, 15),
                LocalDateTime.of(25, 10, 3, 11, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 4, 5, 59),
                LocalDateTime.of(25, 10, 4, 10, 0), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 4,19 ,15),
                LocalDateTime.of(25, 10, 5, 0, 1), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        ChronotypeDetector chronotypeDetector = new ChronotypeDetector();
        String result = chronotypeDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("OWL"));
    }

    @Test
    void shouldReturnLarkChronotypeWithMostLarkSessions() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 21, 15),
                LocalDateTime.of(25, 10, 2, 6, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 0, 15),
                LocalDateTime.of(25, 10, 3, 11, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 20, 59),
                LocalDateTime.of(25, 10, 4, 5, 0), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 4,19 ,15),
                LocalDateTime.of(25, 10, 5, 0, 1), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        ChronotypeDetector chronotypeDetector = new ChronotypeDetector();
        String result = chronotypeDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("LARK"));
    }

    @Test
    void shouldReturnPigeonChronotypeWithMostPigeonSessions() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 23, 15),
                LocalDateTime.of(25, 10, 2, 6, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 0, 15),
                LocalDateTime.of(25, 10, 3, 11, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 22, 59),
                LocalDateTime.of(25, 10, 4, 5, 0), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 4,21 ,15),
                LocalDateTime.of(25, 10, 5, 8, 1), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        ChronotypeDetector chronotypeDetector = new ChronotypeDetector();
        String result = chronotypeDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("PIGEON"));
    }

    @Test
    void shouldReturnPigeonChronotypeWithEqualityOwlAndLarkSessions() {
        SleepingSession firstSession = new SleepingSession(LocalDateTime.of(25,
                10, 1, 21, 15),
                LocalDateTime.of(25, 10, 2, 6, 15), Quality.GOOD);
        SleepingSession secondSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 0, 15),
                LocalDateTime.of(25, 10, 3, 11, 45), Quality.NORMAL);
        SleepingSession thirdSession = new SleepingSession(LocalDateTime.of(25,
                10, 3, 20, 59),
                LocalDateTime.of(25, 10, 4, 5, 0), Quality.NORMAL);
        SleepingSession fourthSession = new SleepingSession(LocalDateTime.of(25,
                10, 4,23 ,15),
                LocalDateTime.of(25, 10, 5, 9, 1), Quality.NORMAL);
        List<SleepingSession> sleepingSessions = new ArrayList<>(List.of(firstSession, secondSession,
                thirdSession, fourthSession));
        ChronotypeDetector chronotypeDetector = new ChronotypeDetector();
        String result = chronotypeDetector.apply(sleepingSessions).toString();
        assertTrue(result.endsWith("PIGEON"));
    }
}
