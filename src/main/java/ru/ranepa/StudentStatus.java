package ru.ranepa;
import java.util.Arrays;

public enum StudentStatus {
    EXCELLENT("отличник", 4.5),
    GOOD("хорошист", 3.5),
    SATISFACTORY("троечник", 2.5),
    FAILING("двоечник", Double.NEGATIVE_INFINITY);

    private final String title;
    private final double minAverage;

    StudentStatus(String title, double minAverage) {
        this.title = title;
        this.minAverage = minAverage;
    }

    public String getTitle() {
        return title;
    }

    public static StudentStatus fromAverage(double average) {
        return Arrays.stream(values())
                .filter(status -> average >= status.minAverage)
                .findFirst()
                .orElseThrow();
    }
}
