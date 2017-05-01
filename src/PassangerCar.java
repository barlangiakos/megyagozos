/**
 * Utasszállító kocsik, amik különbözõ színûek lehetnek, az utasok csak ezekrõla kocsikról szállhatnak le, és csak ezekre szállhatnak fel.
 * A vonat összekötése ugyanúgy feladatuk, mint a többi vonat elemnek. 
 * @author Tajti
 *
 */
public class PassangerCar extends Wagon {
	private String color;
	private PassengerCarView pcView;
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 * @param color A beállítandó szín.
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
	 * @param id A beállítandó azonosító.
	 * @param color A beállítandó szín.
	 * @param cr A currentRailként beállítandó Rail.
	 * @param pr A prevRailként beállítandó Rail.
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
	 * Megnézi, hogy az elõtte lévõ kocsik mind üresek-e.
	 */
	boolean checkFrontEmpty() {
		if (!empty) return false;
		else return front.checkFrontEmpty();
	}

	@Override
	/**
	 * Megnézi, hogy a mögötte lévõ kocsik üresek-e.
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
			pcView.setX(nextX);
			pcView.setY(nextY);
			
			currentRail.enter(this);
			System.out.println(id + " moved to " + currentRail.getId() + ".");
			currentRail.getOff(color);
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
	
	public void setView(PassengerCarView pcv){
		pcView = pcv;
	}
	
	public void setEmpty(boolean b) {
		empty = b;
		if (!b){
			pcView.setImage("img/" + color + "pc.jpg");
		}
		else pcView.setImage("emptypc.jpg");
	}
	
	public String getColor(){
		return color;
	}
	
	public boolean isEmpty(){
		return empty;
	}
}
