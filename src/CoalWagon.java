/**
 * A CoalWagon a szeneskocsi viselked�s�t szimul�lja.
 * Feladata igaz�b�l csak annyi, hogy biztos�tsa a kapcsolatot a vonaton bel�l (2 kocsi k�z�tt), az�rt hogy a vonat �egy�tt� tudjon mozogni.
 *  A szeneskocsira nem sz�llnak fel �s nem is sz�llnak le r�la utasok.
 * @author PC
 *
 */

public class CoalWagon extends Wagon{
	private CoalWagonView cwView;
	/**
	 * Konstruktor
	 * @param id A be�ll�tand� id.
	 */
	public CoalWagon(String id){
		this.id = id;
		currentRail = null;
		prevRail = null;
		front = null;
		rear = null;
		empty = true;
	}
	/**
	 * Konstruktor
	 * @param id A be�ll�tand� id.
	 * @param cr A currentRail �j �rt�ke.
	 * @param pr A previousRail �j �rt�ke.
	 */
	public CoalWagon(String id, Rail cr, Rail pr){
		this.id = id;
		currentRail = cr;
		prevRail = pr;
		front = null;
		rear = null;
		empty = true;
	}
	/**
	 * Megn�zi, hogy az el�tte l�v� kocsik mind �resek-e.
	 */
	@Override
	boolean checkFrontEmpty() {
		if (front == null) return true;
		else return front.checkFrontEmpty();
	}
	/**
	 * Megn�zi, hogy a m�g�tte l�v� kocsik mind �resek-e.
	 */
	@Override
	boolean checkBackEmpty() {
		if (rear == null) return true;
		else return rear.checkBackEmpty();
	}
	/**
	 * Mozgatja a szeneskocsit.
	 */
	@Override
	public void move() {
		if(currentRail.getNextRail(prevRail) != null){
			Rail nextRail = currentRail.getNextRail(prevRail);
			currentRail.leave();
			prevRail = currentRail;
			currentRail = nextRail;
			int nextX = nextRail.getView().getX();
			int nextY = nextRail.getView().getY();
			cwView.setX(nextX);
			cwView.setY(nextY);
			currentRail.enter(this);
			System.out.println(id + " moved to " + currentRail.getId() + ".");
			if (rear != null && !entering) rear.move(); 
			else entering = false;
		}
	}
	/**
	 * currentRail setter
	 * @param r A currentRail �j �rt�ke.
	 */
	public void setCurrentRail(Rail r){
		currentRail = r;
	}
	/**
	 * cwView setter
	 * @param cwv A cwView �j �rt�ke.
	 */
	public void setView(CoalWagonView cwv){
		cwView = cwv;
	}
}
