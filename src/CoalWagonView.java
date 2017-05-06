/**
 * Szeneskocsi n�zet��rt felel�s oszt�ly, kirajzolja a k�p�t egy megadott poz�ci�ra.
 * @author Tajti
 *
 */
public class CoalWagonView extends ElementView{
	/**
	 * konstruktor
	 * @param x x poz�ci�
	 * @param y y poz�ci�
	 * @param w sz�less�g
	 * @param h magass�g
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
