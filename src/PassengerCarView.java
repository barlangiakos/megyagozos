/**
 * Utaskocsi n�zet��rt felel�s oszt�ly, kirajzolja a k�p�t egy megadott poz�ci�ra.
 * @author Tajti
 *
 */
public class PassengerCarView extends ElementView{
	private PassangerCar mPc;
	/**
	 * konstruktor
	 * @param x x poz�ci�
	 * @param y y poz�ci�
	 * @param w sz�less�g
	 * @param h magass�g
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
