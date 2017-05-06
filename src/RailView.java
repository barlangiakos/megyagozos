/**
 * A sima s�n, a keresztez�d�s �s a bel�p�si pont n�zet��rt felel�s oszt�ly, kirajzolja a k�p�t egy megadott poz�ci�ra.
 * @author Tajti
 *
 */
public class RailView extends ElementView{
	private Rail mRail;
	/**
	 * konstruktor
	 * @param x x poz�ci�
	 * @param y y poz�ci�
	 * @param w sz�less�g
	 * @param h magass�g
	 */
	public RailView(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	/**
	 * mRail setter
	 * @param r mRail �j �rt�ke
	 */
	public void setModel(Rail r){
		mRail = r;
	}
	/**
	 * mRail getter
	 * @return mRail
	 */
	public Rail getModel(){
		return mRail;
	}
}
