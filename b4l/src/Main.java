import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(300, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Nhập a");
        l1.setBounds(50, 50, 100, 50);

        JLabel l2 = new JLabel("Nhập b");
        l2.setBounds(50, 80, 100, 50);

        JTextField tf1 = new JTextField();
        tf1.setBounds(100, 70, 100, 20);

        JTextField tf2 = new JTextField();
        tf2.setBounds(100, 100, 100, 20);

        JButton TO = new JButton("Tổng");
        TO.setBounds(100, 150, 70, 30);

        JLabel TO1 = new JLabel();
        TO1.setBounds(100, 200, 200, 20);
        TO1.setVisible(true);

        JButton TR = new JButton("Hiệu");
        TR.setBounds(200, 150, 70, 30);

        JLabel TR1 = new JLabel();
        TR1.setBounds(100, 200, 200, 20);
        TR1.setVisible(true);

        JButton NH = new JButton("Nhân");
        NH.setBounds(300,150,70,30);

        JLabel NH1 = new JLabel();
        NH1.setBounds(100,200,200,20);
        NH1.setVisible(true);

        JButton CH = new JButton("Chia");
        CH.setBounds(400,150,70,30);

        JLabel CH1 = new JLabel();
        CH1.setBounds(100,200,200,20);
        CH1.setVisible(true);

        TO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(tf1.getText().trim());
                    int b = Integer.parseInt(tf2.getText().trim());
                    int tong = a + b;
                    TO1.setText("Tổng 2 số a và b là: " + tong);
                    TO1.setVisible(true);
                } catch (NumberFormatException ex) {
                    TO1.setText("Vui lòng nhập số hợp lệ!");
                    TO1.setVisible(true);
                }
            }
        });
        TR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(tf1.getText().trim());
                    int b = Integer.parseInt(tf2.getText().trim());
                    int hieu = a - b;
                    TR1.setText("Hiệu 2 số là: " + hieu);
                    TR1.setVisible(true);
                } catch (NumberFormatException ex) {
                    TR1.setText("Vui lòng nhập số hợp lệ!");
                    TR1.setVisible(true);
                }
            }
        });
        NH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(tf1.getText().trim());
                    int b = Integer.parseInt(tf2.getText().trim());
                    int thuong = a * b;
                    NH1.setText("Thương 2 số a và b là: " + thuong);
                    NH1.setVisible(true);
                } catch (NumberFormatException ex) {
                    NH1.setText("Vui lòng nhập số hợp lệ!");
                    NH1.setVisible(true);
                }
            }
        });

        CH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(tf1.getText().trim());
                    int b = Integer.parseInt(tf2.getText().trim());
                    int chia = a / b;
                    CH1.setText("Tích 2 số a và b là: " + chia);
                    CH1.setVisible(true);
                } catch (NumberFormatException ex) {
                    CH1.setText("Vui lòng nhập số hợp lệ!");
                    CH1.setVisible(true);
                }
            }
        });

        f.add(l1);
        f.add(l2);
        f.add(tf1);
        f.add(tf2);
        f.add(TO);
        f.add(TO1);
        f.add(TR);
        f.add(TR1);
        f.add(NH);
        f.add(NH1);
        f.add(CH);
        f.add(CH1);
        f.setVisible(true);
    }
}
