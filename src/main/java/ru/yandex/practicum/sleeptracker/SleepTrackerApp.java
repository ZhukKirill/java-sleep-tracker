package ru.yandex.practicum.sleeptracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.stream.Stream;

public class SleepTrackerApp {

    private static List<SleepingSession> sleepingSessions;
    private static List<Function<List<SleepingSession>, SleepAnalysisResult>> functions;

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Ошибка: не указан путь к файлу лога.");
            return;
        }
        String filePath = args[0];
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
            sleepingSessions = lines
                    .map(session -> SleepingSession.convertFromStringToSleepingSession(session, formatter))
                    .toList();
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл " + filePath + ":");
            e.printStackTrace();
            return;
        }
        functions = new ArrayList<>(List.of(
                new SleepSessionDetector(), new MinSessionDetector(), new MaxSessionDetector(),
                new AverageDurationDetector(), new BadQualityDetector(), new SleeplessNightsDetector(),
                new ChronotypeDetector()));
        List<SleepAnalysisResult> result = functions.stream()
                .map(detector -> detector.apply(sleepingSessions))
                .toList();
        result.forEach(System.out::println);
    }

}