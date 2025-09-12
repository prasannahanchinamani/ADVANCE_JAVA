package java8_features.stream_api.student_performance;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

class StudentResultProcessingTest {

    private List<Student> students;

    @BeforeEach
    void setUp() {
        students = Arrays.asList(
                new Student(1, "Sam", 75),
                new Student(2, "Ani", 82),
                new Student(3, "Steve", 92),
                new Student(4, "Boss", 28),
                new Student(5, "Sonal", 65)
        );
    }

    @Test
    void testFindFirstStudentStartingWithS() {
        Optional<Student> result = StudentResultProcessing.findFirstStudentStartingWithS(students);
        assertTrue(result.isPresent());
        assertTrue(result.get().getName().startsWith("S"));
        assertEquals("Sam", result.get().getName());
    }

    @Test
    void testFindFirstStudentStartingWithS_NoMatch() {
        List<Student> noMatchList = Arrays.asList(
                new Student(1, "Ani", 50),
                new Student(2, "Boss", 60)
        );
        Optional<Student> result = StudentResultProcessing.findFirstStudentStartingWithS(noMatchList);
        assertFalse(result.isPresent());
    }

    @Test
    void testAllStudentsScoredAbove35() {
        boolean allAbove = StudentResultProcessing.allStudentsScoredAbove35(students);
        assertFalse(allAbove); // Bob scored 28
    }

    @Test
    void testAllStudentsScoredAbove35_AllPass() {
        List<Student> passing = Arrays.asList(
                new Student(1, "Anna", 50),
                new Student(2, "Benstokes", 70)
        );
        boolean allAbove = StudentResultProcessing.allStudentsScoredAbove35(passing);
        assertTrue(allAbove);
    }

    @Test
    void testAverageScore() {
        OptionalDouble average = StudentResultProcessing.averageScore(students);
        assertTrue(average.isPresent());
        assertEquals((75 + 82 + 92 + 28 + 65) / 5.0, average.getAsDouble(), 0.001);
    }

    @Test
    void testAverageScore_EmptyList() {
        List<Student> emptyList = Collections.emptyList();
        OptionalDouble average = StudentResultProcessing.averageScore(emptyList);
        assertFalse(average.isPresent());
    }
}

