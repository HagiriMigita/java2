import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperGame {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private int bombCount; // ボムの個数

    public MinesweeperGame() {
        // JFrameの設定
        frame = new JFrame("Minesweeper Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // CardLayoutを使用するパネルの作成
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // ボムの難易度選択画面
        JPanel difficultyPanel = new JPanel(new GridLayout(3, 1));
        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");

        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bombCount = 10; // 適当な値。実際のゲームでは調整が必要です。
                showGamePanel();
            }
        });

        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bombCount = 20; // 適当な値。実際のゲームでは調整が必要です。
                showGamePanel();
            }
        });

        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bombCount = 30; // 適当な値。実際のゲームでは調整が必要です。
                showGamePanel();
            }
        });

        difficultyPanel.add(easyButton);
        difficultyPanel.add(mediumButton);
        difficultyPanel.add(hardButton);

        // マインスイーパー画面
        JPanel gamePanel = new JPanel();
        gamePanel.add(new JLabel("Minesweeper Game Panel"));

        // パネルをカードに追加
        cardPanel.add(difficultyPanel, "difficultyPanel");
        cardPanel.add(gamePanel, "gamePanel");

        // JFrameにカードパネルを追加
        frame.getContentPane().add(cardPanel);

        // 最初に難易度選択画面を表示
        cardLayout.show(cardPanel, "difficultyPanel");
    }

    private void showGamePanel() {
        // マインスイーパー画面を表示
        cardLayout.show(cardPanel, "gamePanel");
        // ここでボムの個数(bombCount)を使用してゲームを初期化するロジックを追加
    }

    public void show() {
        // GUIを表示
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MinesweeperGame game = new MinesweeperGame();
                game.show();
            }
        });
    }
}
