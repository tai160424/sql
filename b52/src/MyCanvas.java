import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public void main(String[] args) {

        JFrame f = new JFrame("food orther");
        f.setSize(400, 300);

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel menu = new JLabel("Menu");
        menu.setBounds(50,0,100,100);
        menu.setFont(new Font("Arial", Font.BOLD, 24));

        JCheckBox pz = new JCheckBox("Pizza");
        JCheckBox bg= new JCheckBox("Burger");
        JCheckBox tea = new JCheckBox("Tea");
        JCheckBox cf= new JCheckBox("coffee");

        JButton okButton = new JButton("Ok");
        okButton.addActionListener((ActionListener) this);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener((ActionListener) this);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(pz);
        checkBoxPanel.add(bg);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        f.add(checkBoxPanel, BorderLayout.CENTER);
        f.add(buttonPanel, BorderLayout.SOUTH);
        f.setVisible(true);
        f.add(menu);
    }
}