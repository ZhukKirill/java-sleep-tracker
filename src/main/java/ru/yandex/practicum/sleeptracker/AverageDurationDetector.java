package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class AverageDurationDetector implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        String description = "Средняя продолжительность сна";
        int averageDuration;
        if (sleepingSessions.isEmpty()) {
            averageDuration = 0;
            return new SleepAnalysisResult(averageDuration, description);
        } else {
            averageDuration = sumMinutes(sleepingSessions, 0) / sleepingSessions.size();
            return new SleepAnalysisResult(averageDuration, description);
        }
    }

    private int sumMinutes(List<SleepingSession> sleepingSessions, int index) {
        if (index >= sleepingSessions.size()) {
            return 0;
        }
        int currentDuration = (int) sleepingSessions.get(index).duration.toMinutes();
        return currentDuration + sumMinutes(sleepingSessions, index + 1);
    }
}
