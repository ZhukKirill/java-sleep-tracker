package ru.yandex.practicum.sleeptracker;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MinSessionDetector implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        int numberOfMinutes;
        String description = "Минимальная продолжительность сессии в минутах";
        Optional<SleepingSession> minSession = sleepingSessions.stream()
                .min(Comparator.comparingLong(s -> s.duration.toMinutes()));
        if (minSession.isPresent()) {
            SleepingSession session = minSession.get();
            numberOfMinutes = (int) session.duration.toMinutes();
            return new SleepAnalysisResult(numberOfMinutes, description);
        } else {
            numberOfMinutes = 0;
            return new SleepAnalysisResult(numberOfMinutes, description);
        }
    }
}
