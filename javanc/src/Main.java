import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(300, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("nhap a");
        l1.setBounds(50, 50, 50, 50);

        JLabel l2 = new JLabel("nhap b");
        l2.setBounds(50, 70, 60, 60);
//        JButton button1 = new JButton("sddsa: ") ;
//        f.getContentPane().add(button1);
//        f.setVisible(true9);
        f.add(l1);
        f.add(l2);
        f.setVisible(true);
        JButton b1 = new JButton("Tong");
        b1.setBounds(200, 250, 1000, 300);
        JLabel l3 = new JLabel();
        l3.setBounds(175, 200, 1000, 200);


        b1.addActionListener(e -> {
            int a = Integer.parseInt(l1.getText());
            int b = Integer.parseInt(l2.getText());
            int tong = a + b;
            l3.setText("tong la "+tong);
            l3.setVisible(true);
        });
        }
    }
