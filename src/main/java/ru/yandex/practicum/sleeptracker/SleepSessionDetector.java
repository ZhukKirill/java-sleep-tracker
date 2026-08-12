package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class SleepSessionDetector implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        String description = "Количество сессий за предоставленный период";
        int numberOfSessions = sleepingSessions.size();
        return new SleepAnalysisResult(numberOfSessions, description);
    }
}
