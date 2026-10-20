package ru.ranepa;
import java.util.Scanner;

public final class Main {
    private static final int END_OF_INPUT = 0;

    private Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя студента:");
        String name = scanner.nextLine();
        Student student = new Student(name);
        readGrades(scanner, student);

        student.printReport();
    }

    private static void readGrades(Scanner scanner, Student student) {
        System.out.println("Введите оценки по одной в строке (" + END_OF_INPUT + " — конец ввода):");

        int grade = Integer.parseInt(scanner.nextLine());
        while (grade != END_OF_INPUT) {
            student.addGrade(grade);
            grade = Integer.parseInt(scanner.nextLine());
        }
    }
}