package SQL;
import java.sql.*;

public class DataBase {
    public static void themTen(String ten) {
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";
        String sql = "INSERT INTO Khach_Hang (Ten) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ten);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Tên đã được thêm vào CSDL thành công!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
