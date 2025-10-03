package jdbc_demo.libray_management;

import java.sql.Timestamp;

public class Issue {
    private int issueId;
    private int studentId;
    private int bookId;
    private Timestamp issueDate;
    private Timestamp returnDate;

    public Issue(int issueId, int studentId, int bookId, Timestamp issueDate, Timestamp returnDate) {
        this.issueId = issueId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getIssueId() {
        return issueId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "IssueID: " + issueId +
                ", StudentID: " + studentId +
                ", BookID: " + bookId +
                ", IssueDate: " + issueDate +
                ", ReturnDate: " + returnDate;
    }
}
