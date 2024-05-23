package kadai8;
import javax.swing.*;
public class Sample extends JFrame 
{
    public static void main(String[] args)
    {
        Sample s = new Sample();
        s.setSize(300,250);
        s.setTitle("コメント入力");
        s.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
    }
    
    public Sample()
    {
        setLayout( null );

        JLabel lb1 = new JLabel("氏名:");
        lb1.setBounds( 1, 1, 50, 20);
        add( lb1 );
        JTextField tf1 = new JTextField();
        tf1.setBounds( 70, 1, 200, 20);
        add(tf1);

        JLabel lb2 = new JLabel("Email:");
        lb2.setBounds(1, 30, 50, 20);
        add( lb2 );
        JTextField tf2 = new JTextField();
        tf2.setBounds( 70, 30, 200, 20);
        add( tf2 );

        JLabel lb3 = new JLabel("性別:");
        lb3.setBounds(1, 60, 50, 20);
        add( lb3 );
        JRadioButton rb1 = new JRadioButton("女");
        rb1.setBounds(70, 60, 50, 20);
        add(rb1);
        JRadioButton rb2 = new JRadioButton("男");
        rb2.setBounds(120, 60, 50, 20);
        add(rb2);

        JLabel lb4 = new JLabel("コメント:");
        lb4.setBounds(1, 90, 80, 20);
        add(lb4);
        JTextArea ta1 = new JTextArea();
        ta1.setBounds(70, 90, 200, 60);
        add(ta1);

        JButton bt1 = new JButton("送信");
        bt1.setBounds(1, 180, 60, 20);
        add(bt1);
        JButton bt2 = new JButton("キャンセル");
        bt2.setBounds(70, 180, 100, 20);
        add(bt2);

    }
}