   import java.awt.event.*;
    import javax.swing.*;

    public class z {
        public static void main(String[] args) {
            JFrame f = new JFrame();
            f.setSize(300, 300);
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JButton CO = new JButton("Cộng");
            CO.setBounds(500, 80, 200, 300);

            JButton TR = new JButton("Trừ");
            TR.setBounds(50, 80, 200, 300);

            JButton NH = new JButton("Nhân");
            NH.setBounds(75, 80, 200, 300);

            JButton CH = new JButton("Chia");
            CH.setBounds(100, 80, 200, 300);

            JLabel l1 = new JLabel("Nhập a");
            l1.setBounds(50,50,100,50);

            JLabel l2 = new JLabel("Nhập b");
            l2.setBounds(50,80,100,50);

            JTextField tf1 = new JTextField(" ");
            tf1.setBounds(100,70,100,20);

            JTextField tf2 = new JTextField(" ");
            tf2.setBounds(100,100,100,20);

            JButton b1 = new JButton("Tổng");
            b1.setBounds(100, 150, 70, 30);

            JLabel b3 = new JLabel();
            b3.setBounds(100,200,10000,20);
            b3.setVisible(true);

            b1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int a = Integer.parseInt(tf1.getText().trim());
                    int b = Integer.parseInt(tf2.getText().trim());
                    int tong = a + b;
                    b3.setText("tong 2 so a b la: " + tong);
                    b3.setVisible(true);
                }

            });



            f.add(l1);  f.add(l2);
            f.add(tf1);  f.add(tf2);
            f.add(b1);
            f.add(b3);
            f.add(CO);
    //        f.add(TR);
    //        f.add(NH);
    //        f.add(CH);
            f.setVisible(true);
        }
    }
