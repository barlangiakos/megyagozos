import javax.swing.*;
import java.awt.*;
/**
 * A kezdõképernyõ
 * @author Tajti
 *
 */
public class StartScreenView extends JFrame{

    private static final int WIDTH = 900;
    private static final int HEIGHT = 720;
    JButton startButton;
    JButton exitButton;

    public StartScreenView()
    {
        setTitle("Sheldon terepasztala");
        setIconImage(new ImageIcon("img/icon.png").getImage());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(new JLabel(new ImageIcon("img/start_screen.png")));
        setLayout(new FlowLayout());
        setBackground(new Color(42, 58, 101));

        startButton = new JButton("ÚJ JÁTÉK");
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        startButton.setContentAreaFilled(false);
        startButton.setForeground(Color.GRAY);
        startButton.setFont(new Font("Arial", Font.PLAIN, 24));
        startButton.setFocusPainted(false);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        exitButton = new JButton("KILÉPÉS");
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        exitButton.setContentAreaFilled(false);
        exitButton.setForeground(Color.GRAY);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 24));
        exitButton.setFocusPainted(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(2,1));
        menu.add(startButton, BorderLayout.PAGE_END);
        menu.add(exitButton, BorderLayout.PAGE_END);
        menu.setBackground( new Color(0, 0, 0, 1) );

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(100, 450));
        panel.add(menu, BorderLayout.PAGE_END);
        panel.setBackground( new Color(0, 0, 0, 1) );
        add(panel);

        // Ablak frissitese
        setSize(400,400);
        setSize(WIDTH,HEIGHT);
        Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();

        setLocation(dimemsion.width/2-this.getSize().width/2, dimemsion.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hover effect
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setForeground(Color.WHITE);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setForeground(Color.GRAY);
            }
        });
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButton.setForeground(Color.WHITE);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButton.setForeground(Color.GRAY);
            }
        });

    }
}
