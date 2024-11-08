import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimalImageViewer implements ActionListener {
    private JLabel imageLabel; // JLabel để hiển thị hình ảnh

    public static void main(String[] args) {
        new AnimalImageViewer().createAndShowGUI();
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Animal Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Tạo các nút
        JButton catButton = new JButton("Show Cat");
        JButton dogButton = new JButton("Show Dog");

        // Đăng ký lắng nghe sự kiện cho các nút
        catButton.addActionListener(this);
        dogButton.addActionListener(this);

        // JPanel để chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);

        // JLabel để hiển thị hình ảnh
        imageLabel = new JLabel("", JLabel.CENTER); // Căn giữa hình ảnh

        // Thêm các thành phần vào frame
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(imageLabel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String imagePath = ""; // Đường dẫn hình ảnh

        // Kiểm tra nút nào đã được nhấn
        if (e.getActionCommand().equals("Show Cat"))
            imagePath = "C:\\web\\VHU WEB\\h\\tải xuống (1).jpg"; // Đường dẫn đến hình mèo
        else if (e.getActionCommand().equals("Show Dog")) {
            imagePath = "C:\\web\\VHU WEB\\h\\tải xuống.png"; // Đường dẫn đến hình chó
        }

        // Tạo ImageIcon và gán cho JLabel
        ImageIcon icon = new ImageIcon(imagePath);
        imageLabel.setIcon(icon); // Cập nhật hình ảnh cho JLabel
        imageLabel.setText(""); // Xóa văn bản (nếu có) trong JLabel
    }
}
