package jdbc_demo.libray_management;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//tset
class LibratyDbTest {
//libray db
    private static LibratyDb db;
    //assign 1
    private static int testStudentId = 1;
    //test book assign 2
    private static int testBookId = 2;
//to call every time
    @BeforeAll
    static void setup() {
        db = new LibratyDb();
    }
//test book issued or not
    @Test
    void testIssueBook() {
        boolean issued = db.issueBook(testStudentId, testBookId);
        assertTrue(issued);
    }
//histroy returned or not
    @Test
    void testStudentHistory() {
        List<Issue> history = db.studentHistory(testStudentId);
        assertNotNull(history);
        assertTrue(history.size() > 0);
    }
//returning test
    @Test
    void testReturnBook() {
        List<Issue> history = db.studentHistory(testStudentId);
        assertFalse(history.isEmpty());

        int issueId = history.get(0).getIssueId();
        boolean returned = db.returnBook(issueId);
        assertTrue(returned);
    }
}
