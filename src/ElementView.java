import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class ElementView extends JLabel{
	protected int xCoord, yCoord;
	protected int width, height;
	protected Image img;
	
	public ElementView(int x, int y, int w, int h){
		xCoord = x;
		yCoord = y;
		width = w;
		height = h;
		setBounds(x, y, w, h);
	}
	
	public int getX(){
		return xCoord;
	}
	
	public int getY(){
		return yCoord;
	}
	
	public void setX(int x){
		xCoord = x;
		setBounds(xCoord, yCoord, width, height);
	}
	
	public void setY(int y){
		yCoord = y;
		setBounds(xCoord, yCoord, width, height);
	}
	
	public void setWidth(int w){
		width = w;
	}
	
	public void setHeight(int h){
		height = h;
	}
	
	public void setImage(String imageName){
		try{
			img = ImageIO.read(new File(imageName));
			setIcon(new ImageIcon(img));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
