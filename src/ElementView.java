import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * A kirajzolható elemek õsosztálya. A kódduplikáció elkerülése végett került bevezetésre.
 * @author Tajti
 *
 */
public abstract class ElementView extends JLabel{
	protected int xCoord, yCoord;
	protected int width, height;
	protected Image img;
	/**
	 * konstruktor
	 * @param x x pozíció
	 * @param y y pozíció
	 * @param w szélesség
	 * @param h magasság
	 */
	public ElementView(int x, int y, int w, int h){
		xCoord = x;
		yCoord = y;
		width = w;
		height = h;
		setBounds(x, y, w, h);
	}
	/**
	 * x getter
	 */
	public int getX(){
		return xCoord;
	}
	/**
	 * y getter
	 */
	public int getY(){
		return yCoord;
	}
	/**
	 * x setter
	 * @param x x új értéke
	 */
	public void setX(int x){
		xCoord = x;
		setBounds(xCoord, yCoord, width, height);
	}
	/**
	 * y setter
	 * @param y y új értéke
	 */
	public void setY(int y){
		yCoord = y;
		setBounds(xCoord, yCoord, width, height);
	}
	/**
	 * width setter
	 * @param w Az új szélesség.
	 */
	public void setWidth(int w){
		width = w;
	}
	/**
	 * height setter
	 * @param h Az új magasság.
	 */
	public void setHeight(int h){
		height = h;
	}
	/**
	 * Beállítja a JLabel képét a paraméterként megadott képre.
	 * @param imageName A beállítandó kép elérési útvonala
	 */
	public void setImage(String imageName){
		try{
			img = ImageIO.read(new File(imageName));
			setIcon(new ImageIcon(img));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
