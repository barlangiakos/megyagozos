/**
 * Utassz�ll�t� kocsik, amik k�l�nb�z� sz�n�ek lehetnek, az utasok csak ezekr�la kocsikr�l sz�llhatnak le, �s csak ezekre sz�llhatnak fel.
 * A vonat �sszek�t�se ugyan�gy feladatuk, mint a t�bbi vonat elemnek. 
 * @author Tajti
 *
 */
public class PassangerCar extends Wagon {
	private String color;
	private PassengerCarView pcView;
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 * @param color A be�ll�tand� sz�n.
	 */
	public PassangerCar(String id, String color){
		this.id = id;
		this.color = color;
		currentRail = null;
		prevRail = null;
		front = null;
		rear = null;
		empty = false;
	}
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 * @param color A be�ll�tand� sz�n.
	 * @param cr A currentRailk�nt be�ll�tand� Rail.
	 * @param pr A prevRailk�nt be�ll�tand� Rail.
	 * @param full Azt jelzi, hogy vannak-e utasok a kocsiban.
	 */
	public PassangerCar(String id, String color, Rail cr, Rail pr, String full){
		this.id = id;
		this.color = color;
		currentRail = cr;
		prevRail = pr;
		front = null;
		rear = null;
		if (full.equals("+"))
			empty = false;
		else
			empty = true;
	}
	
	
	@Override
	/**
	 * Megn�zi, hogy az el�tte l�v� kocsik mind �resek-e.
	 */
	boolean checkFrontEmpty() {
		if (!empty) return false;
		else return front.checkFrontEmpty();
	}

	@Override
	/**
	 * Megn�zi, hogy a m�g�tte l�v� kocsik �resek-e.
	 */
	boolean checkBackEmpty() {
		if (!empty) return false;
		else if (rear == null) return true;
		else return rear.checkBackEmpty();
	}

	@Override
	/**
	 * Mozgatja a kocsit.
	 */
	public void move() {
		if(currentRail.getNextRail(prevRail) != null){
			Rail nextRail = currentRail.getNextRail(prevRail);
			prevRail = currentRail;
			currentRail.leave();
			currentRail = nextRail;
			int nextX = nextRail.getView().getX();
			int nextY = nextRail.getView().getY();
			
			currentRail.enter(this);
			System.out.println(id + " moved to " + currentRail.getId() + ".");
			currentRail.getOff(color);
			pcView.setX(nextX);
			pcView.setY(nextY);
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
	 * pcView setter
	 * @param pcv pcView �j �rt�ke
	 */
	public void setView(PassengerCarView pcv){
		pcView = pcv;
	}
	/**
	 * empty setter
	 * @param b A be�ll�tand� �rt�k
	 */
	public void setEmpty(boolean b) {
		empty = b;
		if (!b){
			pcView.setImage("img/" + color + "pc.jpg");
		}
	}
	/**
	 * color getter
	 * @return color
	 */
	public String getColor(){
		return color;
	}
	/**
	 * empty getter
	 * @return empty
	 */
	public boolean isEmpty(){
		return empty;
	}
}
