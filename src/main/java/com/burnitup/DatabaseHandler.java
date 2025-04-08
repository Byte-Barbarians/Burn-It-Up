import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class DatabaseHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/BurnItUp";
    private static final String USER = "LKEETON27";
    private static final String PASSWORD = "Stryker1234!";

    // Establish database connection
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Delete a log by LogID
    public static void deleteLog(int logID) {
        String query = "DELETE FROM Log WHERE LogID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, logID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a user and their logs by UserID
    public static void deleteUser(int userID) {
        String query = "DELETE FROM Users WHERE UserID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a new user
    public static void insertUser(String name, double weight, double height, String gender, int age) {
        String query = "INSERT INTO Users (Name, Weight, Height, Gender, Age) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDouble(2, weight);
            stmt.setDouble(3, height);
            stmt.setString(4, gender);
            stmt.setInt(5, age);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a new log
    public static void insertLog(int userID, String food, double water, int steps, int calories, int calorieGoal, int caloriesBurned) {
        String query = "INSERT INTO Log (UserID, Food, Water, Steps, Calories, CalorieGoal, CaloriesBurned) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userID);
            stmt.setString(2, food);
            stmt.setDouble(3, water);
            stmt.setInt(4, steps);
            stmt.setInt(5, calories);
            stmt.setInt(6, calorieGoal);
            stmt.setInt(7, caloriesBurned);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Edit user information
    public static void updateUser(int userID, double weight, int age) {
        String query = "UPDATE Users SET Weight = ?, Age = ? WHERE UserID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, weight);
            stmt.setInt(2, age);
            stmt.setInt(3, userID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Edit a past log
    public static void updateLog(int logID, int userID, String food, int calories) {
        String query = "UPDATE Log SET Food = ?, Calories = ? WHERE LogID = ? AND UserID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, food);
            stmt.setInt(2, calories);
            stmt.setInt(3, logID);
            stmt.setInt(4, userID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch a single log by LogID
    public static void getLog(int logID) {
        String query = "SELECT * FROM Log WHERE LogID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, logID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Log ID: " + rs.getInt("LogID") + ", Food: " + rs.getString("Food"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch multiple logs by LogID
    public static void getMultipleLogs(int... logIDs) {
        StringBuilder query = new StringBuilder("SELECT * FROM Log WHERE LogID IN (");
        for (int i = 0; i < logIDs.length; i++) {
            query.append("?");
            if (i < logIDs.length - 1) {
                query.append(",");
            }
        }
        query.append(")");

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query.toString())) {
            for (int i = 0; i < logIDs.length; i++) {
                stmt.setInt(i + 1, logIDs[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Log ID: " + rs.getInt("LogID") + ", Food: " + rs.getString("Food"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch logs by date (assuming Ive updated EntryDate to a DATE type. As of this documents creation I haven't.)
    public static void getLogsByDate(String date) {
        String query = "SELECT * FROM Log WHERE EntryDate = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Log ID: " + rs.getInt("LogID") + ", Date: " + rs.getDate("EntryDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch user info by UserID
    public static void getUser(int userID) {
        String query = "SELECT * FROM Users WHERE UserID = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("UserID") + ", Name: " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test functions(This is of course optional to do. The output will end by deleting the user and their logs. It cant do any real harm.)
    public static void main(String[] args) {
        insertUser("John Doe", 185, 6.2, "Male", 28);
        insertLog(1, "Carrot", 12.5, 1000, 125, 1225, 122);
        getLog(1);
        updateUser(1, 190, 29);
        deleteUser(1);
    }
}
