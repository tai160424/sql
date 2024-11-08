import javax.swing.*;
import java.awt.event.*;

public class T {
    public static void main(String[] args) {
       JFrame f = new JFrame();
            f.setSize(300, 300);
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JLabel a = new JLabel("Nhập a");
            a.setBounds(50,50,100,50);

            JLabel b = new JLabel("Nhập b");
            b.setBounds(50,80,100,50);
            
            JLabel c = new JLabel("Nhập c");
            c.setBounds(50,100,100,50);

            JTextField a1 = new JTextField(" ");
            a1.setBounds(100,70,100,20);

            JTextField b1 = new JTextField(" ");
            b1.setBounds(100,100,100,20);
            
            JTextField c1 = new JTextField(" ");
            c1.setBounds(100,130,100,20);

            JButton G = new JButton("Giai");
            G.setBounds(100, 150, 70, 30);
            
            JLabel b3 = new JLabel();
            b3.setBounds(100,200,10000,20);
            b3.setVisible(true);


            G.addActionListener((ActionEvent e) -> {
                int a2 = Integer.parseInt(a1.getText().trim());
                int b2 = Integer.parseInt(b1.getText().trim());
                int c2 = Integer.parseInt(c1.getText().trim());
                float denta = b2 * b2 - (4 * a2 * c2);
                float kep = -b2 / (2 * a2);
                float x1 = (int) ((-b2 + (Math.sqrt(denta))) / (2 * a2));
                float x2 = (int) ((-b2 - (Math.sqrt(denta))) / (2 * a2));
                
                if(denta < 0){
                    b3.setText("pt vo nghiem");
                }else if(denta == 0){
                    b3.setText("pt co 1 nghiem kep x1 = x2 = " + kep);
                }else{
                    b3.setText("pt co 2 no phan biet: x1 = " + x1 + "x2 =" + x2);
                }
       });
            f.add(a);  f.add(b);  f.add(c);
            f.add(a1); f.add(b1); f.add(c1);
            f.add(b3);
            f.add(G);
            f.setVisible(true);
        }
    
    }
    

