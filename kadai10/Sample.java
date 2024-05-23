package kadai10;
import javax.swing.*;
import java.awt.event.*;

public class Sample extends JFrame
{
    private JLabel lb;
    private int i = 0;
    private long startTime = -1;
    public static void main( String[] args)
    {
        Sample s = new Sample();
        s.setSize(200,100);
        s.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
    }

    public Sample()
    {
        lb = new JLabel(" ");
        add(lb);
        addKeyListener( new SampleKeyListener());
    }

    class SampleKeyListener extends KeyAdapter
    {
        public void keyPressed( KeyEvent e)
        {
            if( startTime == -1)
            {
                startTime = System.currentTimeMillis();
            }
            if( i < 10 )
            {
                i++;
                char keyChar = e.getKeyChar( );
                String key = String.valueOf( keyChar );
                String upperKey = key.toUpperCase( );
                if( lb.getText( ).equals( upperKey ) )
                {
                    String nextKey = String.valueOf(
                        ( char )( Math.random( ) * 26 + 65 )
                    );
                    lb.setText( nextKey );
                }
            }
            else
            if( i == 10)
            {
                long endTime = System.currentTimeMillis();
                double duration = ( endTime - startTime ) / 1000.0;
                String s = Double.toString(duration);
                s = "所要時間:" + s + "sec";
                lb.setText(s);
                add(lb);
                i++;
            }
        }
    }
}
