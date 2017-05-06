/**
 * A sima sín, a keresztezõdés és a belépési pont nézetéért felelõs osztály, kirajzolja a képét egy megadott pozícióra.
 * @author Tajti
 *
 */
public class RailView extends ElementView{
	private Rail mRail;
	/**
	 * konstruktor
	 * @param x x pozíció
	 * @param y y pozíció
	 * @param w szélesség
	 * @param h magasság
	 */
	public RailView(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	/**
	 * mRail setter
	 * @param r mRail új értéke
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
