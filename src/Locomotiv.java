/**
 * A mozdonyt testes�ti meg.
 * Egy mozdony egy�rtelm�en meghat�roz egy vonatot, a mozdonyb�l kiindulva v�gig lehet menni a teljes vonaton,
 * ennek k�sz�nhet� igaz�b�l, hogy a vonat elemei egyszerre tudnak mozogni.
 * @author Tajti
 *
 */
public class Locomotiv extends Wagon {
	private LocomotivView lView;
	private boolean win = false;
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
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
	 * @param id A be�ll�tand� azonos�t�.
	 * @param cr A currentRail �j �rt�ke.
	 * @param pr A previousRail �j �rt�ke.
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
	 * Mindig igazzal t�r vissza, hiszen a mozdonyban nem utazik senki.
	 */
	@Override
	boolean checkFrontEmpty() {
		return true;
	}
	/**
	 * Megn�zi, hogy a m�g�tte l�v� kocsik mind �resek-e.
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
	 * @param r A currentRail �j �rt�ke.
	 */
	public void setCurrentRail(Rail r){
		currentRail = r;
	}
	/**
	 * win setter.
	 * @param value A win �j �rt�ke.
	 */
	public void setWin(boolean value){
		win = value;
	}
	/**
	 * win getter
	 * @return A win �rt�ke.
	 */
	public boolean getWin(){
		return win;
	}
	
	public void setView(LocomotivView l){
		lView = l;
	}
}
