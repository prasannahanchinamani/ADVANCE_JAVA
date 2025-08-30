package student_tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {
    @Test
    void testStudentCreation() {
        Student studnent= new Student("Prasanna", 21, 85.0);
        assertEquals("Prasanna",studnent.getName());
        assertEquals(21,studnent.getAge());
        assertEquals(85.0,studnent.getGrade());
    }
}
