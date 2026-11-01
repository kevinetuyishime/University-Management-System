package universitysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {

    public void insert(String title) throws SQLException {
        String sql = "INSERT INTO courses (title) VALUES (?)";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.executeUpdate();
        }
    }

    public List<Subject> findAll() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT id, title FROM courses ORDER BY id";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                subjects.add(new Subject(rs.getInt("id"), rs.getString("title")));
            }
        }
        return subjects;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM courses WHERE id = ?";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}