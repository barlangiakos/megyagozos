/**
 * A CoalWagon a szeneskocsi viselkedését szimulálja.
 * Feladata igazából csak annyi, hogy biztosítsa a kapcsolatot a vonaton belül (2 kocsi között), azért hogy a vonat “együtt” tudjon mozogni.
 *  A szeneskocsira nem szállnak fel és nem is szállnak le róla utasok.
 * @author PC
 *
 */

public class CoalWagon extends Wagon{
	/**
	 * Konstruktor
	 * @param id A beállítandó id.
	 */
	private CoalWagonView cwView;
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
	 * @param id A beállítandó id.
	 * @param cr A currentRail új értéke.
	 * @param pr A previousRail új értéke.
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
	 * Megnézi, hogy az elõtte lévõ kocsik mind üresek-e.
	 */
	@Override
	boolean checkFrontEmpty() {
		if (front == null) return true;
		else return front.checkFrontEmpty();
	}
	/**
	 * Megnézi, hogy a mögötte lévõ kocsik mind üresek-e.
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
	 * @param r A currentRail új értéke.
	 */
	public void setCurrentRail(Rail r){
		currentRail = r;
	}
	
	public void setView(CoalWagonView cwv){
		cwView = cwv;
	}
}
