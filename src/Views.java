import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
/**
 * Felel�s az �sszes k�perny�re rajzolhat� elem t�rol�s��rt, �s k�perny�re rajzol�s��rt.
 * @author Tajti
 *
 */
public class Views extends JFrame{
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 1024;
	private ArrayList<ElementView> elements;
	private JLayeredPane mainPanel;
	/**
	 * konstruktor
	 */
	public Views(){
		super("Sheldon terepasztala");
		elements = new ArrayList<ElementView>();

		mainPanel = new JLayeredPane();
		add(mainPanel);
		setSize(WIDTH, HEIGHT);
		setIconImage(new ImageIcon("img/icon.png").getImage());
		Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dimemsion.width/2-this.getSize().width/2, dimemsion.height/2-this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		mainPanel.setVisible(true);
	}
	/**
	 * �j elemet ad az elements list�j�hoz
	 * @param e az �j elem
	 */
	public void addElement(ElementView e){
		elements.add(e);
		mainPanel.add(e,0);
		repaint();
		revalidate();
	}
	/**
	 * �jrarajzolja az elements list�ban l�v� �sszes objektumot
	 */
	public void drawAll(){
		repaint();
		revalidate();
	}
	/**
	 * bez�rja az ablakot
	 */
	public void close(){
		this.dispose();
	}
}
