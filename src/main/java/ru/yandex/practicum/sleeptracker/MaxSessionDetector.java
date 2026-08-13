package ru.yandex.practicum.sleeptracker;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MaxSessionDetector implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        int numberOfMinutes;
        String description = "максимальная продолжительность сессии в минутах";
        Optional<SleepingSession> maxSession = sleepingSessions.stream()
                .max(Comparator.comparingLong(s -> s.duration.toMinutes()));
        if (maxSession.isPresent()) {
            SleepingSession session = maxSession.get();
            numberOfMinutes = (int) session.duration.toMinutes();
            return new SleepAnalysisResult(numberOfMinutes, description);
        } else {
            numberOfMinutes = 0;
            return new SleepAnalysisResult(numberOfMinutes, description);
        }
    }
}
