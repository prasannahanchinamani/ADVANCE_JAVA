package jdbc_demo.libray_management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibratyDb {

    public boolean issueBook(int studentId, int bookId) {
        String checkBook = "SELECT available_copies FROM Book WHERE book_id = ?";
        String insertIssue = "INSERT INTO Issue(student_id, book_id, issue_date) VALUES(?, ?, NOW())";
        String updateBook = "UPDATE Book SET available_copies = available_copies - 1 WHERE book_id = ?";

        try (Connection con = ConnectionDatabase.getConnection()) {
            con.setAutoCommit(false);

            int copies = 0;
            try (PreparedStatement ps = con.prepareStatement(checkBook)) {
                ps.setInt(1, bookId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) copies = rs.getInt("available_copies");
            }

            if (copies <= 0) {
                con.rollback();
                return false; // Book not available
            }

            try (PreparedStatement ps = con.prepareStatement(insertIssue)) {
                ps.setInt(1, studentId);
                ps.setInt(2, bookId);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(updateBook)) {
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            con.commit();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Issue> studentHistory(int studentId) {
        List<Issue> history = new ArrayList<>();
        String query = """
                SELECT i.issue_id, i.student_id, i.book_id, i.issue_date, i.return_date
                FROM Issue i
                WHERE i.student_id = ?
                """;

        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                history.add(new Issue(
                        rs.getInt("issue_id"),
                        rs.getInt("student_id"),
                        rs.getInt("book_id"),
                        rs.getTimestamp("issue_date"),
                        rs.getTimestamp("return_date")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return history;
    }

    public boolean returnBook(int issueId) {
        String updateIssue = "UPDATE Issue SET return_date = NOW() WHERE issue_id = ?";
        String updateBook = """
                UPDATE Book 
                SET available_copies = available_copies + 1 
                WHERE book_id = (SELECT book_id FROM Issue WHERE issue_id = ?)
                """;

        try (Connection con = ConnectionDatabase.getConnection()) {
            con.setAutoCommit(false);

            try (PreparedStatement ps = con.prepareStatement(updateIssue)) {
                ps.setInt(1, issueId);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = con.prepareStatement(updateBook)) {
                ps.setInt(1, issueId);
                ps.executeUpdate();
            }

            con.commit();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
