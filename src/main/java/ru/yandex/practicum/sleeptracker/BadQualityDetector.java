package ru.yandex.practicum.sleeptracker;

import java.util.List;
import java.util.function.Function;

public class BadQualityDetector implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        String description = "Количество сессий с плохим качеством сна";
        List<SleepingSession> badSessions = sleepingSessions.stream()
                .filter(sessions -> sessions.quality.equals(Quality.BAD)).toList();
        int numberOfBadSessions = badSessions.size();
        return new SleepAnalysisResult(numberOfBadSessions, description);
    }
}
