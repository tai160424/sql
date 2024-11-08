    import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.Container;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.ItemEvent;
    import java.awt.event.ItemListener;

    import javax.swing.JButton;
    import javax.swing.JCheckBox;
    import javax.swing.JComboBox;
    import javax.swing.JFrame;
    import javax.swing.JPanel;

    public class COLORZ extends JFrame implements ActionListener
    {

        private JComboBox comboBox;
        private JCheckBox background, foreground;
        private JButton okButton, cancelButton;
        private String[] colors = { "RED", "GREEN", "BLUE", "YELLOW","WHITE" };
        private Color color[] = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,Color.WHITE  };

        private JPanel checkBoxPanel, buttonPanel;
        Container container = new JPanel();

        public COLORZ()
        {

            super("ColorSelect");
            setContentPane(container);
            this.getContentPane().setBackground(color[0]);

            comboBox = new JComboBox(colors);
            comboBox.setMaximumRowCount(2);
            comboBox.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent event)
                {

                    if (event.getStateChange() == ItemEvent.SELECTED)
                    {
                        container.setBackground(color[comboBox.getSelectedIndex()]);
                        container.repaint();
                    }

                }

            });

            background = new JCheckBox("Background");
            foreground = new JCheckBox("Foreground");
    
            okButton = new JButton("Ok");
            okButton.addActionListener(this);
            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(this);

            checkBoxPanel = new JPanel();
            checkBoxPanel.add(background);
            checkBoxPanel.add(foreground);

            buttonPanel = new JPanel();
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);

            container.add(comboBox, BorderLayout.NORTH);
            container.add(checkBoxPanel, BorderLayout.CENTER);
            container.add(buttonPanel, BorderLayout.SOUTH);

            setVisible(true);
            setBounds(400, 200, 300, 120);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        @Override
        public void actionPerformed(ActionEvent event)
        {

            if (event.getSource() == okButton)
            {
                container.setBackground(color[comboBox.getSelectedIndex()]);
            }
            else if (event.getSource() == cancelButton)
            {
                System.exit(0);
            }

        }

        public static void main(String[] args)
        {
            new COLORZ();
        }

    }