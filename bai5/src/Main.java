import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("Food Order");
        f.setSize(400, 300);
        f.setLayout(new BorderLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel menu = new JLabel("Menu");
        menu.setFont(new Font("Arial", Font.BOLD, 24));
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        f.add(menu, BorderLayout.NORTH);

        // Tạo các JCheckBox
        JCheckBox pz = new JCheckBox("Pizza");
        JCheckBox bg = new JCheckBox("Burger");
        JCheckBox tea = new JCheckBox("Tea");
        JCheckBox cf = new JCheckBox("Coffee");

        // Tạo JPanel cho các JCheckBox
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(pz);
        checkBoxPanel.add(bg);
        checkBoxPanel.add(tea);
        checkBoxPanel.add(cf);

        f.add(checkBoxPanel, BorderLayout.CENTER);


        JButton okButton = new JButton("Order");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedItems = new StringBuilder("You ordered: ");
                if (pz.isSelected()) selectedItems.append("Pizza ");
                if (bg.isSelected()) selectedItems.append("Burger ");
                if (tea.isSelected()) selectedItems.append("Tea ");
                if (cf.isSelected()) selectedItems.append("Coffee ");

                JOptionPane.showMessageDialog(f, selectedItems.toString());
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);

        f.add(buttonPanel, BorderLayout.SOUTH);

        f.setVisible(true);
    }
}
