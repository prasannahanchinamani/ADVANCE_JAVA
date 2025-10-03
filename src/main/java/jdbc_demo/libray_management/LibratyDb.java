package jdbc_demo.libray_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibratyDb {
    public void issueBook(int studentId, int bookId) {
        String checkBook = "SELECT available_copies FROM Book WHERE book_id = ?";
        String insertIssue = "INSERT INTO Issue(student_id, book_id, issue_date) VALUES(?, ?, NOW())";
        String updateBook = "UPDATE Book SET available_copies = available_copies - 1 WHERE book_id = ?";
        try (Connection connection = ConnectionDatabase.getConnection()) {
            connection.setAutoCommit(false);
            int copies = 0;
            try (PreparedStatement ps = connection.prepareStatement(checkBook)) {
                ps.setInt(1, bookId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) copies = rs.getInt("available_copies");
            }
            if (copies > 0) {
                try (PreparedStatement ps = connection.prepareStatement(insertIssue)) {
                    ps.setInt(1, studentId);
                    ps.setInt(2, bookId);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = connection.prepareStatement(updateBook)) {
                    ps.setInt(1, bookId);
                    ps.executeUpdate();
                }
                connection.commit();
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("Book not available.");
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void studentHistory(int studentId) {
        String query = """
                SELECT s.name, b.title, i.issue_date, i.return_date
                FROM Issue i
                JOIN Student s ON i.student_id = s.student_id
                JOIN Book b ON i.book_id = b.book_id
                WHERE s.student_id = ?
                """;

        try (Connection con = ConnectionDatabase.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "  " +
                                rs.getString("title") + " Issued: " +
                                rs.getTimestamp("issue_date") + "  Returned: " +
                                rs.getTimestamp("return_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnBook(int issueId) {
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
            System.out.println("Book returned successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
