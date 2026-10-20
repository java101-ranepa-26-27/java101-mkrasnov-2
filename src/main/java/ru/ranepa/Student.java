package ru.ranepa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class Student {
    private final String name;
    private final List<Integer> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return List.copyOf(grades);
    }

    public double average() {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0); // OptionalDouble -> Double + тест без оценок (ср балл 0)
    }

    public String status() {
        return StudentStatus.fromAverage(average()).getTitle();
    }

    public String report() {
        return String.join("\n",
                "===== Отчёт о студенте =====",
                "Имя: " + name,
                "Оценки: " + grades,
                String.format("Средний балл: %.2f", average()),
                "Статус: " + status());
    }
    public void printReport() {
        System.out.println(report());
    }
}