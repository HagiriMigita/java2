package kadai8;
import javax.swing.*;

public class Sample2 extends JFrame
{
    public static void main(String[] args)
    {
        Sample2 s = new Sample2();//Sample2クラスのオブジェクトを作成
        s.setSize(250, 100);//ウィンドウサイズを設定
        s.setTitle("サンプル");//ウィンドウタイトルを設定
        s.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);//ウィンドウを閉じた時にアプリケーションを終了するように設定
        s.setVisible(true);//ウィンドウを表示
    }

    private JLabel lb;
    public Sample2()
    {
        lb = new JLabel("ようこそ");

        //Container cp = getContentPane();//コンテンツペインを取得
        //cp.add(lb);//コンテンツペインにラベルを追加
        //省略可能

        add(lb);
    }
}