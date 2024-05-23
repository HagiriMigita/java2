package kadai8;
import javax.swing.*;
import java.awt.*;
public class Border extends JFrame
{
    public static void main(String[] args)
    {
        Border b = new Border();
        b.setSize(200,200);
        b.setTitle("サンプル");
        b.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        b.setVisible( true );
    }
    public Border()
    {
        setLayout( new FlowLayout());
        for(int i = 0; i < 10; i++)
        {
            add( new JButton( Integer.toString(i)));
        }


    }
}