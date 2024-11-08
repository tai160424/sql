//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(300,300);
        f.setLayout((LayoutManager)null);
        JButton [] b = new JButton[9];
        for (int i= 0; i< 9; i++)
        {
            b[i] = new JButton();
            b[i] .addActionListener(e -> {
                JButton Click = (JButton) e.getSource();

            });
        }
    }
}