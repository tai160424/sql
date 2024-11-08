import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Main extends JFrame implements ActionListener {

    private JRadioButton catButton, dogButton, fishButton, pigButton, rabbitButton;
    private ButtonGroup group;
    private JLabel imageJLabel;

    public Main() {
        setTitle("RadioButtonDemo");
        setSize(300, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        fishButton = new JRadioButton("Fish");
        pigButton = new JRadioButton("Pig");
        rabbitButton = new JRadioButton("Rabbit");

        group = new ButtonGroup();
        group.add(catButton);
        group.add(dogButton);
        group.add(fishButton);
        group.add(pigButton);
        group.add(rabbitButton);

        imageJLabel = new JLabel();

        JPanel radioJPanel = new JPanel(new GridLayout(5, 1));
        radioJPanel.add(catButton);
        radioJPanel.add(dogButton);
        radioJPanel.add(fishButton);
        radioJPanel.add(pigButton);
        radioJPanel.add(rabbitButton);

        fishButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        add(radioJPanel, BorderLayout.WEST);
        add(imageJLabel, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String image = "";
        if (e.getSource() == catButton)
            image = "https://en.wikipedia.org/wiki/File:June_odd-eyed-cat.jpg";
        if (e.getSource() == dogButton)
            image = "dog.jpg";
        if (e.getSource() == fishButton)
            image = "fish.jpg";
        if (e.getSource() == pigButton)
            image = "pig.jpg";
        if (e.getSource() == rabbitButton)
            image = "rabbit.jpg";
        ImageIcon icon = new ImageIcon(getClass().getResource(image));
        imageJLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        new Main();
    }
}