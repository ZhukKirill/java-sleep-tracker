package ru.yandex.practicum.sleeptracker;

public class SleepAnalysisResult {

    private Integer value;
    private String description;
    private Chronotype chronotype;

    public SleepAnalysisResult(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public SleepAnalysisResult(Chronotype chronotype, String description) {
        this.chronotype = chronotype;
        this.description = description;
    }

    @Override
    public String toString() {
        if (value != null) return String.format("%s: %s", description, value);
        return String.format("%s: %s", description, chronotype);
    }
}
