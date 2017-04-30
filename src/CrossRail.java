/**
 * Keresztez�d� s�nek viselked�s�t val�s�tja meg.
 * Megfelel�en kell tov�bbk�ldenie a kocsikat a k�vetkez� s�nre.
 * Viselked�se tulajdonk�ppen azonos a Rail oszt�ly viselked�s�vel, az egyetlen k�l�nbs�g, hogy t�bb Rail referenci�ja van,
 * amiket a k�vetkez� s�n visszaad�sakor haszn�lnia kell.
 * @author Tajti
 *
 */
public class CrossRail extends Rail{
	private Rail rail3 = null;
	private Rail rail4 = null;
	
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 */
	public CrossRail(String id){
		super(id);
	}
	/**
	 * rail3 setter.
	 * @param r A be�ll�tand� Rail.
	 */
	public void setRail3(Rail r){
		rail3 = r;
	}
	/**
	 * rail4 setter.
	 * @param r A be�ll�tand� Rail.
	 */
	public void setRail4(Rail r){
		rail4 = r;
	}
	/**
	 * A param�terk�nt �tadott referencia alapj�n visszaadja a k�vetkez� Rail referenci�j�t, amire majd a vonat elemnek mozognia kell.
	 * @param prev Az el�z� Rail, amin a Wagon volt.
	 * @return A k�vetkez� Rail referenci�ja.
	 */
	public Rail getNextRail(Rail prev){
		if (prev == rail1) return rail2;
		else if (prev == rail2) return rail1;
		else if (prev == rail3) return rail4;
		else return rail3;
	};
}
