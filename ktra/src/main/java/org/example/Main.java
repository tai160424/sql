import javax.swing.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        // Đăng ký driver MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        JFrame f = new JFrame("Quản Lý Sinh Viên");
        f.setSize(400, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel tenSVLabel = new JLabel("Tên Sinh Viên: ");
        tenSVLabel.setBounds(50, 50, 100, 30);
        JTextField tenSVField = new JTextField();
        tenSVField.setBounds(150, 50, 200, 30);

        JButton timButton = new JButton("Tìm");
        timButton.setBounds(350, 50, 100, 30);
        JButton themButton = new JButton("Thêm");
        themButton.setBounds(50, 100, 100, 30);
        JButton suaButton = new JButton("Sửa");
        suaButton.setBounds(250, 100, 100, 30);
        JButton xoaButton = new JButton("Xóa");
        xoaButton.setBounds(150, 100, 100, 30);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50, 200, 300, 100);
        resultArea.setEditable(false);

        f.add(tenSVLabel);
        f.add(tenSVField);
        f.add(timButton);
        f.add(themButton);
        f.add(suaButton);
        f.add(xoaButton);
        f.add(resultArea);
        f.setVisible(true);

        timButton.addActionListener(e -> {
            String tenSV = tenSVField.getText().trim();
            String result = timSinhVienTheoTen(tenSV);
            resultArea.setText(result);
        });

        themButton.addActionListener(e -> themSinhVien());

        suaButton.addActionListener(e -> suaSinhVien());

        xoaButton.addActionListener(e -> {
            String tenSV = tenSVField.getText().trim();
            if (!tenSV.isEmpty()) {
                xoaSinhVien(tenSV);
            } else {
                JOptionPane.showMessageDialog(f, "Vui lòng nhập tên sinh viên để xóa.");
            }
        });
    }

    private static String timSinhVienTheoTen(String tenSV) {
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";
        StringBuilder result = new StringBuilder();

        String sql = "SELECT SV.MSSV, SV.HoTen, SV.NgaySinh, L.TenLop " +
                "FROM SinhVien SV " +
                "JOIN Lop L ON SV.MaLop = L.MaLop " +
                "WHERE SV.HoTen LIKE ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + tenSV + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int mssv = resultSet.getInt("MSSV");
                String hoTen = resultSet.getString("HoTen");
                Date ngaySinh = resultSet.getDate("NgaySinh");
                String tenLop = resultSet.getString("TenLop");

                result.append("MSSV: " + mssv + ", Họ Tên: " + hoTen + ", Ngày Sinh: " + ngaySinh + ", Tên Lớp: " + tenLop + "\n");
            }
            if (result.length() == 0) {
                return "Không tìm thấy sinh viên nào.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi truy vấn CSDL.";
        }
        return result.toString();
    }

    private static void themSinhVien() {
        JFrame addFrame = new JFrame("Thêm Sinh Viên");
        addFrame.setSize(300, 300);
        addFrame.setLayout(null);

        JLabel mssvLabel = new JLabel("MSSV: ");
        mssvLabel.setBounds(20, 20, 100, 30);
        JTextField mssvField = new JTextField();
        mssvField.setBounds(120, 20, 150, 30);

        JLabel hoTenLabel = new JLabel("Họ Tên: ");
        hoTenLabel.setBounds(20, 60, 100, 30);
        JTextField hoTenField = new JTextField();
        hoTenField.setBounds(120, 60, 150, 30);

        JLabel dobLabel = new JLabel("Ngày Sinh (YYYY-MM-DD): ");
        dobLabel.setBounds(20, 100, 150, 30);
        JTextField dobField = new JTextField();
        dobField.setBounds(170, 100, 100, 30);

        JLabel maLopLabel = new JLabel("Mã Lớp: ");
        maLopLabel.setBounds(20, 140, 100, 30);
        String[] lopOptions = {"CNTT", "Hát", "Nhảy"};
        JComboBox<String> classComboBox = new JComboBox<>(lopOptions);
        classComboBox.setBounds(120, 140, 150, 30);

        JButton addButton = new JButton("Thêm");
        addButton.setBounds(100, 180, 100, 30);
        addFrame.add(mssvLabel);
        addFrame.add(mssvField);
        addFrame.add(hoTenLabel);
        addFrame.add(hoTenField);
        addFrame.add(dobLabel);
        addFrame.add(dobField);
        addFrame.add(maLopLabel);
        addFrame.add(classComboBox);
        addFrame.add(addButton);
        addFrame.setVisible(true);

        addButton.addActionListener(e -> {
            try {
                int mssv = Integer.parseInt(mssvField.getText());
                String hoTen = hoTenField.getText();
                String dateString = dobField.getText();

                // Kiểm tra định dạng ngày sinh
                if (!isValidDate(dateString)) {
                    JOptionPane.showMessageDialog(addFrame, "Định dạng ngày sinh không hợp lệ (YYYY-MM-DD).");
                    return;
                }
                Date ngaySinh = Date.valueOf(dateString);
                String maLop = (String) classComboBox.getSelectedItem();

                int maLopValue;
                switch (maLop) {
                    case "CNTT":
                        maLopValue = 1;
                        break;
                    case "Hát":
                        maLopValue = 2;
                        break;
                    case "Nhảy":
                        maLopValue = 3;
                        break;
                    default:
                        maLopValue = 0; // Mã lớp không hợp lệ
                }

                // Thêm sinh viên vào CSDL
                themSinhVienVaoDB(mssv, hoTen, ngaySinh, maLopValue);
                JOptionPane.showMessageDialog(addFrame, "Thêm sinh viên thành công!");
                addFrame.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addFrame, "MSSV phải là một số.");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(addFrame, "MSSV đã có trong CSDL  .");
            }
        });
    }

    private static void suaSinhVien() {
        // Tương tự như themSinhVien(), nhưng sẽ hiển thị thông tin sinh viên hiện tại để chỉnh sửa
        String mssv = JOptionPane.showInputDialog("Nhập MSSV của sinh viên cần sửa:");
        if (mssv != null && !mssv.isEmpty()) {
            JFrame suaFrame = new JFrame("Sửa Sinh Viên");
            suaFrame.setSize(300, 300);
            suaFrame.setLayout(null);

            JLabel hoTenLabel = new JLabel("Họ Tên: ");
            hoTenLabel.setBounds(20, 60, 100, 30);
            JTextField hoTenField = new JTextField();
            hoTenField.setBounds(120, 60, 150, 30);

            JLabel dobLabel = new JLabel("Ngày Sinh (YYYY-MM-DD): ");
            dobLabel.setBounds(20, 100, 150, 30);
            JTextField dobField = new JTextField();
            dobField.setBounds(170, 100, 100, 30);

            JLabel maLopLabel = new JLabel("Mã Lớp: ");
            maLopLabel.setBounds(20, 140, 100, 30);
            String[] lopOptions = {"CNTT", "Hát", "Nhảy"};
            JComboBox<String> classComboBox = new JComboBox<>(lopOptions);
            classComboBox.setBounds(120, 140, 150, 30);

            JButton updateButton = new JButton("Cập Nhật");
            updateButton.setBounds(100, 180, 100, 30);
            suaFrame.add(hoTenLabel);
            suaFrame.add(hoTenField);
            suaFrame.add(dobLabel);
            suaFrame.add(dobField);
            suaFrame.add(maLopLabel);
            suaFrame.add(classComboBox);
            suaFrame.add(updateButton);
            suaFrame.setVisible(true);

            // Tìm thông tin sinh viên để sửa
            String studentInfo = timSinhVienTheoTen(mssv);
            if (!studentInfo.equals("Không tìm thấy sinh viên nào.")) {
                String[] details = studentInfo.split(", ");
                hoTenField.setText(details[1].split(": ")[1]);
                dobField.setText(details[2].split(": ")[1]);
                // Chọn mã lớp
                String tenLop = details[3].split(": ")[1];
                classComboBox.setSelectedItem(tenLop);
            }

            updateButton.addActionListener(e -> {
                try {
                    String hoTen = hoTenField.getText();
                    String dateString = dobField.getText();

                    // Kiểm tra định dạng ngày sinh
                    if (!isValidDate(dateString)) {
                        JOptionPane.showMessageDialog(suaFrame, "Định dạng ngày sinh không hợp lệ (YYYY-MM-DD).");
                        return;
                    }
                    Date ngaySinh = Date.valueOf(dateString);
                    String maLop = (String) classComboBox.getSelectedItem();

                    int maLopValue;
                    switch (maLop) {
                        case "CNTT":
                            maLopValue = 1;
                            break;
                        case "Hát":
                            maLopValue = 2;
                            break;
                        case "Nhảy":
                            maLopValue = 3;
                            break;
                        default:
                            maLopValue = 0; // Mã lớp không hợp lệ
                    }

                    // Cập nhật thông tin sinh viên trong CSDL
                    capNhatSinhVien(mssv, hoTen, ngaySinh, maLopValue);
                    JOptionPane.showMessageDialog(suaFrame, "Cập nhật thành công!");
                    suaFrame.dispose();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(suaFrame, "Lỗi cập nhật sinh viên.");
                }
            });
        }
    }

    private static void xoaSinhVien(String tenSV) {
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";

        String sql = "DELETE FROM SinhVien WHERE HoTen LIKE ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, "%" + tenSV + "%");
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Xóa sinh viên thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên nào để xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi xóa sinh viên.");
        }
    }

    private static void themSinhVienVaoDB(int mssv, String hoTen, Date ngaySinh, int maLop) throws SQLException {
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";

        String sql = "INSERT INTO SinhVien (MSSV, HoTen, NgaySinh, MaLop) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, mssv);
            preparedStatement.setString(2, hoTen);
            preparedStatement.setDate(3, ngaySinh);
            preparedStatement.setInt(4, maLop);
            preparedStatement.executeUpdate();
        }
    }

    private static void capNhatSinhVien(String mssv, String hoTen, Date ngaySinh, int maLop) throws SQLException {
        String jdbcURL = "jdbc:mysql://10.17.8.183:6603/TSQL";
        String username = "root";
        String password = "phuongaz";

        String sql = "UPDATE SinhVien SET HoTen = ?, NgaySinh = ?, MaLop = ? WHERE MSSV = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, hoTen);
            preparedStatement.setDate(2, ngaySinh);
            preparedStatement.setInt(3, maLop);
            preparedStatement.setInt(4, Integer.parseInt(mssv));
            preparedStatement.executeUpdate();
        }
    }

    private static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
