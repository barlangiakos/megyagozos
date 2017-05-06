import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * A v�lt� n�zet��rt felel�s oszt�ly, kirajzolja a k�p�t egy megadott poz�ci�ra.
 * @author Tajti
 *
 */
public class SwitchView extends ElementView implements MouseListener{
	private Switch mSwitch;
	private ArrayList<Image> switchImages;
	private int index = 0;
	/**
	 * konstruktor
	 * @param x x poz�ci�
	 * @param y y poz�ci�
	 * @param w sz�less�g
	 * @param h magass�g
	 * @param s modellbeli v�lt�
	 * @param image1 els� �ll�shoz tartoz� k�p
	 * @param image2 m�sodik �ll�shoz tartoz� k�p
	 */
	public SwitchView(int x, int y, int w, int h, Switch s, String image1, String image2) {
		super(x, y, w, h);
		mSwitch = s;
		this.addMouseListener(this);
		switchImages = new ArrayList<Image>();
		
		try{
			switchImages.add(ImageIO.read(new File(image1)));
			switchImages.add(ImageIO.read(new File(image2)));
			setIcon(new ImageIcon(switchImages.get(0)));
		}catch(IOException e){
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
	/**
	 * mSwitch setter
	 * @param s mSwitch �j �rt�ke
	 */
	public void setModel(Switch s){
		mSwitch = s;
	}
	/**
	 * mSwitch getter
	 * @return mSwitch
	 */
	public Switch getModel(){
		return mSwitch;
	}
	/**
	 * Az eg�rkettint�s esem�nykezel�je
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(((JLabel)e.getSource()).equals(this)){
			if(mSwitch.getWagon() == null){
				this.mSwitch.changeRail();
				setIcon(new ImageIcon(switchImages.get(++index)));
				if(index == 1) index = -1;
				getParent().repaint();
				getParent().revalidate();
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
