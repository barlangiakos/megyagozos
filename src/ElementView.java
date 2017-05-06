import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * A kirajzolhat� elemek �soszt�lya. A k�dduplik�ci� elker�l�se v�gett ker�lt bevezet�sre.
 * @author Tajti
 *
 */
public abstract class ElementView extends JLabel{
	protected int xCoord, yCoord;
	protected int width, height;
	protected Image img;
	/**
	 * konstruktor
	 * @param x x poz�ci�
	 * @param y y poz�ci�
	 * @param w sz�less�g
	 * @param h magass�g
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
	 * @param x x �j �rt�ke
	 */
	public void setX(int x){
		xCoord = x;
		setBounds(xCoord, yCoord, width, height);
	}
	/**
	 * y setter
	 * @param y y �j �rt�ke
	 */
	public void setY(int y){
		yCoord = y;
		setBounds(xCoord, yCoord, width, height);
	}
	/**
	 * width setter
	 * @param w Az �j sz�less�g.
	 */
	public void setWidth(int w){
		width = w;
	}
	/**
	 * height setter
	 * @param h Az �j magass�g.
	 */
	public void setHeight(int h){
		height = h;
	}
	/**
	 * Be�ll�tja a JLabel k�p�t a param�terk�nt megadott k�pre.
	 * @param imageName A be�ll�tand� k�p el�r�si �tvonala
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
