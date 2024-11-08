import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.javafx.fxml.expression.Expression.add;

public class Main {
    public void z(String[] args) {

        JFrame f = new JFrame();
        f.setSize(400, 300);

        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton cat = new JRadioButton("Cat");
        JRadioButton dog = new JRadioButton("Dog");

        ButtonGroup group = new ButtonGroup();
        group.add(cat);
        group.add(dog);

        JLabel imageJLabel = new JLabel();

        JPanel radioJPanel = new JPanel(new GridLayout(2, 1));
        radioJPanel.add(cat);
        radioJPanel.add(dog);

        cat.addActionListener((ActionListener) this);
        dog.addActionListener((ActionListener) this);

        add(radioJPanel, BorderLayout.WEST);
        add(imageJLabel, BorderLayout.EAST);
        setVisible(true);

        ActionEvent e = null;
            String image = "";
            if (e.getSource() == cat)
                image = "C:\\web\\VHU WEB\\h\\tải xuống (1).jpg";
            if (e.getSource() == dog)
                image = "C:\\web\\VHU WEB\\h\\tải xuống.png\\";
        ImageIcon icon = new ImageIcon(getClass().getResource(image));
        imageJLabel.setIcon(icon);
    }
}
