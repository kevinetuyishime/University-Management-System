package universitysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {

    public void enroll(int learnerId, int subjectId) throws SQLException {
        String sql = "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, learnerId);
            ps.setInt(2, subjectId);
            ps.executeUpdate();
        }
    }

    public void changeSubject(int registrationId, int newSubjectId) throws SQLException {
        String sql = "UPDATE enrollments SET course_id = ? WHERE id = ?";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newSubjectId);
            ps.setInt(2, registrationId);
            ps.executeUpdate();
        }
    }

    public List<String> findReport() throws SQLException {
        List<String> lines = new ArrayList<>();
        String sql = "SELECT enrollments.id, students.name, courses.title "
                + "FROM enrollments "
                + "JOIN students ON enrollments.student_id = students.id "
                + "JOIN courses ON enrollments.course_id = courses.id "
                + "ORDER BY enrollments.id";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lines.add("Registration " + rs.getInt("id") + ": "
                        + rs.getString("name") + " -> " + rs.getString("title"));
            }
        }
        return lines;
    }
}