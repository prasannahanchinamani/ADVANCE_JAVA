package java8_features.stream_api.student_performance;

import java.util.*;
import java.util.stream.*;

class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public double getScore() { return score; }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", score=" + score + '}';
    }
}

public class StudentResultProcessing {

    public static Optional<Student> findFirstStudentStartingWithS(List<Student> students) {
        return students.stream()
                .filter(s -> s.getName().startsWith("S"))
                .findFirst();
    }

    public static boolean allStudentsScoredAbove35(List<Student> students) {
        return students.stream()
                .allMatch(s -> s.getScore() > 35);
    }

    public static OptionalDouble averageScore(List<Student> students) {
        return students.stream()
                .mapToDouble(Student::getScore)
                .average();
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "Sam", 75),
                new Student(2, "Alni", 82),
                new Student(3, "Steve", 92),
                new Student(4, "Boss", 28),
                new Student(5, "Sonal", 65)
        );

        Optional<Student> firstS = findFirstStudentStartingWithS(students);
        firstS.ifPresentOrElse(
                s -> System.out.println("First student starting with S: " + s),
                () -> System.out.println("No student found starting with S")
        );

        System.out.println("All students scored above 35: " + allStudentsScoredAbove35(students));

        OptionalDouble avgScore = averageScore(students);
        avgScore.ifPresentOrElse(
                avg -> System.out.println("Average score: " + avg),
                () -> System.out.println("No students to calculate average")
        );
    }
}

