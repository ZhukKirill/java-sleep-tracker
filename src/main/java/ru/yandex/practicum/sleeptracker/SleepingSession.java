package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SleepingSession {
    final LocalDateTime bedTime;
    final LocalDateTime wakeUpTime;
    final Quality quality;
    final Duration duration;

    public SleepingSession(LocalDateTime bedTime, LocalDateTime wakeUpTime, Quality quality) {
        this.bedTime = bedTime;
        this.wakeUpTime = wakeUpTime;
        this.quality = quality;
        duration = SleepingSession.calculateDuration(bedTime, wakeUpTime);
    }

    public static SleepingSession convertFromStringToSleepingSession(String logLine, DateTimeFormatter formatter) {
        String[] parts = logLine.split(";");
        LocalDateTime bedTime = LocalDateTime.parse(parts[0], formatter);
        LocalDateTime wakeUpTime = LocalDateTime.parse(parts[1], formatter);
        Quality quality = Quality.valueOf(parts[2]);
        return new SleepingSession(bedTime, wakeUpTime, quality);
    }

    private static Duration calculateDuration(LocalDateTime initialTime, LocalDateTime finalTime) {
        return Duration.between(initialTime, finalTime);
    }

}
