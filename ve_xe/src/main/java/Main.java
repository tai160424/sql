import SQL.DAT_VE;
import SQL.DataBase;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Đăng ký driver MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return; // Kết thúc nếu không tìm thấy driver
        }

        JFrame f = new JFrame();
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton DV = new JButton("Đặt vé");
        DV.setBounds(50, 250, 100, 50);

        JButton HV = new JButton("Hủy đặt vé");
        HV.setBounds(200, 250, 100, 50);

        JLabel T = new JLabel("Nhập Tên: ");
        T.setBounds(50, 50, 100, 50);
        JLabel BD = new JLabel("Điểm Bắt Đầu: ");
        BD.setBounds(50, 85, 100, 50);
        JLabel KT = new JLabel("Điểm Kết Thúc: ");
        KT.setBounds(50, 125, 100, 30);
        JLabel GV = new JLabel("Giá vé: ");
        GV.setBounds(50, 140, 100, 50);

        JTextField T1 = new JTextField();
        T1.setBounds(150, 70, 100, 20);
        JTextField BD1 = new JTextField();
        BD1.setBounds(150, 100, 100, 20);
        JTextField KT1 = new JTextField();
        KT1.setBounds(150, 130, 100, 20);
        JTextField GV1 = new JTextField();
        GV1.setBounds(150, 160, 100, 20);

        f.add(DV);
        f.add(HV);
        f.add(T);
        f.add(BD);
        f.add(KT);
        f.add(GV);
        f.add(T1);
        f.add(BD1);
        f.add(KT1);
        f.add(GV1);
        f.setVisible(true);

        DV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ten = T1.getText().trim();
                String dbd = BD1.getText().trim();
                String dkt = KT1.getText().trim();

                // Lấy giá vé từ JTextField và chuyển đổi thành số
                int gv = 0;
                try {
                    gv = Integer.parseInt(GV1.getText().trim()); // Lấy giá từ JTextField
                } catch (NumberFormatException ex) {
                    System.out.println("Giá vé không hợp lệ: " + GV1.getText());
                    return; // Thoát khỏi phương thức nếu giá không hợp lệ
                }

                if (!kiemTraTen(ten)) {
                    DataBase.themTen(ten);
                    System.out.println("Tên đã được thêm vào CSDL.");
                } else {
                    System.out.println("Tên đã tồn tại trong CSDL.");
                }
            }
        });
    }

    public static boolean kiemTraTen(String ten) {
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";
        boolean exists = false;

        String sql = "SELECT COUNT(*) FROM Khach_Hang WHERE Ten = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ten);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }
}