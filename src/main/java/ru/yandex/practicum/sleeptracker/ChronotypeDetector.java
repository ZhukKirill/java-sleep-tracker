package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public class ChronotypeDetector implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        String description = "Ваш хронотип";
        List<SleepingSession> nightsSession = sleepingSessions.stream()
                .filter(session -> {
                    LocalDate nigthDate = session.wakeUpTime.toLocalDate();
                    return session.bedTime.isBefore(nigthDate.atTime(6, 0)) &&
                            session.wakeUpTime.isAfter(nigthDate.atTime(0,0));
                }).toList();
        List<SleepingSession> owlNights = nightsSession.stream()
                .filter(session -> {
                    LocalDate nigthDate = session.wakeUpTime.toLocalDate();
                    return session.bedTime.isAfter(nigthDate.atTime(23, 0).minusDays(1)) &&
                            session.wakeUpTime.isAfter(nigthDate.atTime(9,0));
                }).toList();
        List<SleepingSession> larkNigths = nightsSession.stream()
                .filter(session -> {
                    LocalDate nigthDate = session.wakeUpTime.toLocalDate();
                    return session.bedTime.isBefore(nigthDate.atTime(22,0).minusDays(1)) &&
                            session.wakeUpTime.isBefore(nigthDate.atTime(7,0));
                }).toList();
        int numberOfPigeonNigths = nightsSession.size() - owlNights.size() - larkNigths.size();
        if (owlNights.size() > numberOfPigeonNigths
                && owlNights.size() > larkNigths.size()) return new SleepAnalysisResult(Chronotype.OWL, description);
        if (larkNigths.size() > owlNights.size()
                && larkNigths.size() > numberOfPigeonNigths) return
                new SleepAnalysisResult(Chronotype.LARK, description);
        return new SleepAnalysisResult(Chronotype.PIGEON, description);
    }
}
