/**
 * Szeneskocsi nézetéért felelõs osztály, kirajzolja a képét egy megadott pozícióra.
 * @author Tajti
 *
 */
public class CoalWagonView extends ElementView{
	/**
	 * konstruktor
	 * @param x x pozíció
	 * @param y y pozíció
	 * @param w szélesség
	 * @param h magasság
	 */
	public CoalWagonView(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.setImage("img/cwright.jpg");
		// TODO Auto-generated constructor stub
	}
	/**
	 * x setter
	 */
	public void setX(int x){
		if (x > xCoord){
			this.setImage("img/cwright.jpg");
			width = 80;
			height = 23;
		}
		if (x < xCoord){
			this.setImage("img/cwleft.jpg");
			width = 80;
			height = 23;
		}
		xCoord = x;
		setBounds(xCoord, yCoord, width, height);
	}
	/**
	 * y setter
	 */
	public void setY(int y){
		if (y > yCoord){
			this.setImage("img/cwdown.jpg");
			width = 23;
			height = 80;
		}
		if (y < yCoord){
			this.setImage("img/cwup.jpg");
			width = 23;
			height = 80;
		}
		yCoord = y;
		setBounds(xCoord, yCoord, width, height);
	}
	
}
