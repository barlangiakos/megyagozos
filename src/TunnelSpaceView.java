import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * Alag�tsz�j n�zet��rt felel�s oszt�ly, kirajzolja a k�p�t egy megadott poz�ci�ra.
 * @author Tajti
 *
 */
public class TunnelSpaceView extends ElementView implements MouseListener{
	private TunnelSpace mTunnelSpace;
	/**
	 * konstruktor
	 * @param x x poz�ci�
	 * @param y y poz�ci�
	 * @param w sz�less�g
	 * @param h magass�g
	 */
	public TunnelSpaceView(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.addMouseListener(this);
		
		// TODO Auto-generated constructor stub
	}
	/**
	 * mTunnelSpace setter
	 * @param ts mTunnelSpace �j �rt�ke
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
	 * eg�rkattint�s esem�nykezel�je
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
