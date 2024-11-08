package DataBase;
import java.sql.*;

public class Data {
    public static void themTen(String ten, String ngaySinh, String lop) {
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";

        String sql = "INSERT INTO SinhVien (HoTen, NgaySinh, MaLop) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ten);
            preparedStatement.setString(2, ngaySinh); // Đã thay đổi từ int sang String
            preparedStatement.setString(3, lop);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
