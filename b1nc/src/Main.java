//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(300, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("chick me");
        b.setBounds(30, 80, 200, 300);

        JLabel l = new JLabel();
        l.setBounds(300, 40, 300, 400);
        final int[] count = {0};
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count[0]++;
                l.setText("Click count: " + count[0]);
            }
        });


        f.add(b);
        f.add(l);
            f.setVisible(true);
    }
}