import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * Alagútszáj nézetéért felelõs osztály, kirajzolja a képét egy megadott pozícióra.
 * @author Tajti
 *
 */
public class TunnelSpaceView extends ElementView implements MouseListener{
	private TunnelSpace mTunnelSpace;
	/**
	 * konstruktor
	 * @param x x pozíció
	 * @param y y pozíció
	 * @param w szélesség
	 * @param h magasság
	 */
	public TunnelSpaceView(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.addMouseListener(this);
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * mTunnelSpace setter
	 * @param ts mTunnelSpace új értéke
	 */
	public void setModel(TunnelSpace ts){
		mTunnelSpace = ts;
	}
	/**
	 * mTunnelSpace getter
	 * @return mTunnelSpace
	 */
	public TunnelSpace getModel(){
		return mTunnelSpace;
	}
	/**
	 * egérkattintás eseménykezelõje
	 */
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
