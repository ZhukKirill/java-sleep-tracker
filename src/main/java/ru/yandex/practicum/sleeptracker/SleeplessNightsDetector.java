package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.function.Function;

public class SleeplessNightsDetector implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        String description = "Количество бессонных ночей";
        boolean isFirstSessionBeforeNoon = sleepingSessions.getFirst().bedTime.toLocalTime()
                .isBefore(LocalTime.of(12, 0));
        List<SleepingSession> nightsSession = sleepingSessions.stream()
                .filter(session -> {
                    LocalDate nigthDate = session.wakeUpTime.toLocalDate();
                    return session.bedTime.isBefore(nigthDate.atTime(6, 0)) &&
                            session.wakeUpTime.isAfter(nigthDate.atTime(0,0));
                }).toList();
        int numberOfNights = Period.between(sleepingSessions.getFirst().bedTime.toLocalDate(),
                sleepingSessions.getLast().wakeUpTime.toLocalDate()).getDays();
        if (isFirstSessionBeforeNoon == true) numberOfNights += 1;
        int sleeplessNights = numberOfNights - nightsSession.size();
        return new SleepAnalysisResult(sleeplessNights, description);
    }
}
