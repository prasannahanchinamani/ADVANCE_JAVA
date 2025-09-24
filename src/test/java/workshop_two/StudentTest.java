package workshop_two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @DisplayName("merge without conflits")
    @Test
    public void testMergeWithoutConflicts() {
        List<Student> list1 = Arrays.asList(new Student(1, "Prasanna"), new Student(2, "Prajwal"));
        List<Student> list2 = Arrays.asList(new Student(3, "Rohit"), new Student(4, "Chandan"));

        Map<Integer, Student> expected = new LinkedHashMap<>();
        expected.put(1, new Student(1, "Prasanna"));
        expected.put(2, new Student(2, "Prajwal"));
        expected.put(3, new Student(3, "Rohit"));
        expected.put(4, new Student(4, "Chandan"));

        Map<Integer, Student> result = StudentUtil.mergeWithSameLength(list1, list2);

        assertEquals(expected, result);
    }


    @DisplayName("test with same length")
    @Test
    public void testMergewithSameLength() {
        List<Student> list1 = Arrays.asList(
                new Student(1, "Prasanna"),
                new Student(2, "Prajwal")//7
        );

        List<Student> list2 = Arrays.asList(
                new Student(2, "Pramodh"), //  7
                new Student(3, "Charlie")
        );
        Map<Integer, Student> expected = new LinkedHashMap<>();
        expected.put(1, new Student(1, "Prasanna"));
        expected.put(2, new Student(2, "Prajwal"));
        expected.put(3, new Student(3, "Charlie"));
        Map<Integer, Student> result = StudentUtil.mergeWithSameLength(list1, list2);
        assertEquals(expected, result);
    }
    @DisplayName("test with same length take the longestLength")
    @Test
    public void testMergeWithConflictsKeepLongestName() {
        List<Student> list1 = Arrays.asList(
                new Student(1, "Prasanna"),
                new Student(2, "Prajwal")//7
        );

        List<Student> list2 = Arrays.asList(
                new Student(2, "Prashanth"), //  9  longer name
                new Student(3, "Charlie")
        );

        Map<Integer, Student> expected = new LinkedHashMap<>();
        expected.put(1, new Student(1, "Prasanna"));
        expected.put(2, new Student(2, "Prashanth"));
        expected.put(3, new Student(3, "Charlie"));

        Map<Integer, Student> result = StudentUtil.mergeWithSameLength(list1, list2);
        assertEquals(expected, result);
    }
    @DisplayName("merge with both lists empty")
    @Test
    public void testMergeWithEmptyLists() {
        List<Student> list1 = Collections.emptyList();
        List<Student> list2 = Collections.emptyList();

        Map<Integer, Student> result = StudentUtil.mergeWithSameLength(list1, list2);
        assertTrue(result.isEmpty());
    }

    @DisplayName("merge with duplicate IDs and null names")
    @Test
    public void testMergeWithConflictsAndNullNames() {
        List<Student> list1 = Arrays.asList(new Student(1, null));
        List<Student> list2 = Arrays.asList(new Student(2, "Prasanna"));

        Map<Integer, Student> result = StudentUtil.mergeWithSameLength(list1, list2);
        assertEquals(null, result.get(1).getName());
    }

    @DisplayName("merge with conflicting IDs and same name length")
    @Test
    public void testMergeWithSameLengthConflict() {
        List<Student> list1 = Arrays.asList(new Student(1, "Gaurav"));
        List<Student> list2 = Arrays.asList(new Student(1, "Mishra"));

        Map<Integer, Student> result = StudentUtil.mergeWithSameLength(list1, list2);
        assertEquals("Gaurav", result.get(1).getName());
    }
}
