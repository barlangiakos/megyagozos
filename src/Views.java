import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Views extends JFrame{
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 1024;
	private ArrayList<ElementView> elements;
	private JLayeredPane mainPanel;
	
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
	
	public void addElement(ElementView e){
		elements.add(e);
		mainPanel.add(e,0);
		repaint();
		revalidate();
	}
	
	public void drawAll(){
		repaint();
		revalidate();
	}
	
	public void close(){
		this.dispose();
	}
}
