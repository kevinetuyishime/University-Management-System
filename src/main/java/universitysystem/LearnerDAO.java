package universitysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LearnerDAO {

    public void insert(String name, String email) throws SQLException {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.executeUpdate();
        }
    }

    public List<Learner> findAll() throws SQLException {
        List<Learner> learners = new ArrayList<>();
        String sql = "SELECT id, name, email FROM students ORDER BY id";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                learners.add(new Learner(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), 0));
            }
        }
        return learners;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = DbConnector.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}