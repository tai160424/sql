import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("RadioByttibDemo");
        f.setSize(300, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton CatButton = new JRadioButton("Cat");
        JRadioButton DogButton = new JRadioButton("Dog");

        ActionListener lisstener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        f.setVisible(true);

    }
    }
