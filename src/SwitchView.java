import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SwitchView extends ElementView implements MouseListener{
	private Switch mSwitch;
	private ArrayList<Image> switchImages;
	private int index = 0;
	
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void setModel(Switch s){
		mSwitch = s;
	}
	
	public Switch getModel(){
		return mSwitch;
	}

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
