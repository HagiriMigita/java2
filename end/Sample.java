import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;
import java.io.*;

public class Sample extends JFrame
{
    private JButton[][] buttons;
    private int[][] hantei;
    private int clickedCount = 0;
    private static int bombCount = (int)Math.floor(Math.random() * 5) + 5;
    private AudioClip ac;
    private String str;
    private String title;

    public Sample() 
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            title = br.readLine();
            while( (str = br.readLine()) != null)
            {
                title = str;
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println( e );
        }
        this.setTitle("Minesweeper Game" + " " + title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = new JButton[5][5];
        ac = Applet.newAudioClip( getClass().getResource("gudaguda.wav"));
        ac.loop();

        this.setLayout(new GridLayout(5,5));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; //ボタンがセルを埋める

        hantei = new int[5][5];

        for( int i = 0; i < buttons.length; i++)
        {
            for( int j = 0; j < buttons[i].length; j++)
            {
                buttons[i][j] = new JButton();
                gbc.gridx = j;
                gbc.gridy = i;
                this.add(buttons[i][j], gbc);

                final int row = i;
                final int col = j;          

                buttons[i][j].addActionListener
                (new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        clickedCount++;
                        buttonClicked(row, col);
                    }
                });
            }
        }

        zeroOrOne(hantei);

        this.setSize(500,500);
        this.setVisible(true);
    }
    private void buttonClicked(int row, int col)  //ボタンを押したときの挙動
    {
        if(hantei[row][col] == 1)
        {
            ac.stop();
            ac = Applet.newAudioClip( getClass().getResource("Explosion08-2_Short_.wav"));
            ac.play();
            ImageDialogEx();
            
            try
            {
                BufferedWriter bw = new BufferedWriter( new FileWriter( "input.txt"));
                bw.write("前回の記録:" + clickedCount + "回で爆発!");
                bw.newLine();
                bw.close();
            }
            catch( IOException e )
            {
                System.out.println( e );
            }
            System.exit(0);
        }
        else
        {
            buttons[row][col].setText(Integer.toString(countArroundMines(row,col)));
            if(clickedCount == 1)
            {
                int[] directions = {-1, 0, 1};

                for(int dr : directions)
                {
                    for(int dc : directions)
                    {
                        if( dr == 0 && dc == 0)
                        {
                            continue;
                        }
        
                        int r = row + dr;
                        int c = col + dc;
        
                        if( r >= 0 && r < hantei.length && c >= 0 && c < hantei[0].length && hantei[r][c] == 0)
                        {
                            buttons[r][c].setText(Integer.toString(countArroundMines(r,c)));
                        }
                    }
                }
            }

            if(clickedCount == (17 - bombCount))
            {
                ac.stop();
                ac = Applet.newAudioClip( getClass().getResource("栄光のファンファーレ.wav"));
                ac.play();
                ImageDialogCL();
                try
                {
                    BufferedWriter bw = new BufferedWriter( new FileWriter( "input.txt"));
                    bw.write("前回の記録:成功!");
                    bw.newLine();
                    bw.close();
                }
                catch( IOException e )
                {
                    System.out.println( e );
                }
                System.exit(0);
            }
        }

    }

    public static void zeroOrOne(int hantei[][])
    {
        int x = 0;
        int y = 0;

        while(bombCount != 0)
        {
            x = (int)Math.floor(Math.random() * 5);
            y = (int)Math.floor(Math.random() * 5);
            
            if(hantei[x][y] == 1)
            {
                continue;
            }
            else
            {
                hantei[x][y] = 1;
                bombCount--;
            }
        } 
    }

    private int countArroundMines(int row, int col)
    {
        int mineCount = 0;
        int[] directions = {-1, 0, 1};

        for(int dr : directions)
        {
            for(int dc : directions)
            {
                if( dr == 0 && dc == 0)
                {
                    continue;
                }

                int r = row + dr;
                int c = col + dc;

                if( r >= 0 && r < hantei.length && c >= 0 && c < hantei[0].length && hantei[r][c] == 1)
                {
                    mineCount++;
                }
            }
        }

        return mineCount;
        
    }

    public void ImageDialogCL()
    {
        String imagePath = "congratulation.png";
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);
        
        JOptionPane.showMessageDialog(null, label, "おめでとう!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void ImageDialogEx()
    {
        String imagePath = "bakuhatsu.png";
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);
        
        JOptionPane.showMessageDialog(null, label, "爆発してしまいました!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Sample();
            }
        });
    } 
}