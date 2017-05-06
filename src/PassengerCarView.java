/**
 * Utaskocsi nézetéért felelõs osztály, kirajzolja a képét egy megadott pozícióra.
 * @author Tajti
 *
 */
public class PassengerCarView extends ElementView{
	private PassangerCar mPc;
	/**
	 * konstruktor
	 * @param x x pozíció
	 * @param y y pozíció
	 * @param w szélesség
	 * @param h magasság
	 * @param model modellbeli kocsi
	 */
	public PassengerCarView(int x, int y, int w, int h, PassangerCar model) {
		super(x, y, w, h);
		mPc = model;
		// TODO Auto-generated constructor stub
	}
	/**
	 * x setter
	 */
	public void setX(int x){
		if (x > xCoord && !mPc.isEmpty()){
			this.setImage("img/" + mPc.getColor() + "rightpc.jpg");
			width = 80;
			height = 23;
		}
		if (x > xCoord && mPc.isEmpty()){
			this.setImage("img/emptyrightpc.jpg");
			width = 80;
			height = 23;
		}
		if (x < xCoord && !mPc.isEmpty()){
			this.setImage("img/" + mPc.getColor() + "leftpc.jpg");
			width = 80;
			height = 23;
		}
		if (x < xCoord && mPc.isEmpty()){
			this.setImage("img/emptyleftpc.jpg");
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
		if (y > yCoord && !mPc.isEmpty()){
			this.setImage("img/" + mPc.getColor() + "downpc.jpg");
			width = 23;
			height = 80;
		}
		if (y > yCoord && mPc.isEmpty()){
			this.setImage("img/emptydownpc.jpg");
			width = 23;
			height = 80;
		}
		if (y < yCoord && !mPc.isEmpty()){
			this.setImage("img/" + mPc.getColor() + "uppc.jpg");
			width = 23;
			height = 80;
		}
		if (y < yCoord && mPc.isEmpty()){
			this.setImage("img/emptyuppc.jpg");
			width = 23;
			height = 80;
		}
		yCoord = y;
		setBounds(xCoord, yCoord, width, height);
	}
	
}
