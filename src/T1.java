import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class T1 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Thông Tin Cá Nhân");
        f.setSize(350, 250);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color myColor = Color.RED;

       
        JLabel a = new JLabel("Thông tin");
        a.setForeground(myColor.brighter());
        a.setBounds(130, 10, 100, 20);
        f.add(a);

        
        JLabel b = new JLabel("Họ và tên:");
        b.setBounds(30, 40, 100, 20);
        f.add(b);

        JTextField a1 = new JTextField();
        a1.setBounds(130, 40, 150, 20);
        f.add(a1);

     
        f.add(new JLabel("Ngày, thang, nam:")).setBounds(30, 70, 100, 20);
        JComboBox<String> dayComboBox = new JComboBox<>();
        for (int day = 1; day <= 31; day++) {
            dayComboBox.addItem(String.valueOf(day));
        }
        dayComboBox.setBounds(130, 70, 50, 20);
        f.add(dayComboBox);

   
        JComboBox<String> monthComboBox = new JComboBox<>();
        for (int month = 1; month <= 12; month++) {
            monthComboBox.addItem(String.valueOf(month));
        }
        monthComboBox.setBounds(180, 70, 50, 20);
        f.add(monthComboBox);

       
        JComboBox<String> yearComboBox = new JComboBox<>();
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int year = 1980; year <= currentYear; year++) {
            yearComboBox.addItem(String.valueOf(year));
        }
        yearComboBox.setBounds(230, 70, 60, 20);
        f.add(yearComboBox);


        JLabel hobbyLabel = new JLabel("Sở thích:");
        hobbyLabel.setBounds(30, 100, 100, 20);
        f.add(hobbyLabel);

        JTextField hobbyField = new JTextField();
        hobbyField.setBounds(130, 100, 150, 20);
        f.add(hobbyField);

     
        JButton viewButton = new JButton("Xem");
        viewButton.setBounds(50, 130, 80, 25);
        f.add(viewButton);

        JButton exitButton = new JButton("Thoát");
        exitButton.setBounds(180, 130, 80, 25);
        f.add(exitButton);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = a1.getText();
                String day = (String) dayComboBox.getSelectedItem();
                String month = (String) monthComboBox.getSelectedItem();
                String year = (String) yearComboBox.getSelectedItem();
                String hobby = hobbyField.getText();

                String message = "Họ và tên: " + name + "\n" +
                                 "Ngày sinh: " + day + "/" + month + "/" + year + "\n" +
                                 "Sở thích: " + hobby;

                JOptionPane.showMessageDialog(f, message, "Thông Tin", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setVisible(true);
    }
}