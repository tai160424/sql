package DataBase;
import java.sql.*;

public class MSSV {
    public static void themMas(int mssv) { // Đổi tham số thành int
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";

        String sql = "INSERT INTO SinhVien (MSSV) VALUES (?)";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, mssv); // Sử dụng setInt để thêm giá trị int vào truy vấn
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
