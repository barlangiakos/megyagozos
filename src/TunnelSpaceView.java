import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class TunnelSpaceView extends ElementView implements MouseListener{
	private TunnelSpace mTunnelSpace;
	
	public TunnelSpaceView(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.addMouseListener(this);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void setModel(TunnelSpace ts){
		mTunnelSpace = ts;
	}
	
	public TunnelSpace getModel(){
		return mTunnelSpace;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mTunnelSpace.build();
		getParent().repaint();
		getParent().revalidate();
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
