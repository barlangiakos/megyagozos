/**
 * A mozdonyt testesíti meg.
 * Egy mozdony egyértelmûen meghatároz egy vonatot, a mozdonyból kiindulva végig lehet menni a teljes vonaton,
 * ennek köszönhetõ igazából, hogy a vonat elemei egyszerre tudnak mozogni.
 * @author Tajti
 *
 */
public class Locomotiv extends Wagon {
	private LocomotivView lView;
	private boolean win = false;
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 */
	public Locomotiv(String id){
		this.id = id;
		currentRail = null;
		prevRail = null;
		front = null;
		rear = null;
		empty = true;
	}
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 * @param cr A currentRail új értéke.
	 * @param pr A previousRail új értéke.
	 */
	public Locomotiv(String id, Rail cr, Rail pr){
		this.id = id;
		currentRail = cr;
		prevRail = pr;
		front = null;
		rear = null;
		empty = true;
	}
	/**
	 * Mindig igazzal tér vissza, hiszen a mozdonyban nem utazik senki.
	 */
	@Override
	boolean checkFrontEmpty() {
		return true;
	}
	/**
	 * Megnézi, hogy a mögötte lévõ kocsik mind üresek-e.
	 */
	@Override
	boolean checkBackEmpty() {
		if (rear != null){
			return rear.checkBackEmpty();
		}
		return true;
	}
	/**
	 * Mozgatja a mozdonyt.
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
			lView.setX(nextX);
			lView.setY(nextY);
			currentRail.enter(this);
			System.out.println(id + " moved to " + currentRail.getId() + ".");
			if (rear != null && !entering) rear.move(); 
			else entering = false;
		}
	}
	/**
	 * currentRail setter.
	 * @param r A currentRail új értéke.
	 */
	public void setCurrentRail(Rail r){
		currentRail = r;
	}
	/**
	 * win setter.
	 * @param value A win új értéke.
	 */
	public void setWin(boolean value){
		win = value;
	}
	/**
	 * win getter
	 * @return A win értéke.
	 */
	public boolean getWin(){
		return win;
	}
	/**
	 * lView setter
	 * @param l lView új értéke.
	 */
	public void setView(LocomotivView l){
		lView = l;
	}
}
