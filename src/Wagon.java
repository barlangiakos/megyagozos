/**
 * Absztrakt osztály a vonat elemeknek. Ennek köszönhetõ, hogy egyáltalán létezhet vonat a programunkban,
 * máskülönben nem tudnánk összekapcsolni a különbözõ típusú kocsikat.
 * @author Tajti
 *
 */
public abstract class Wagon {
	protected Rail currentRail;
	protected Rail prevRail;
	protected Wagon front;
	protected Wagon rear;
	protected boolean empty;
	protected String id;
	protected boolean entering = false;
	/**
	 * Absztrakt metódus, ami az egyes vonatelemek mozgatásáért lesz felelõs.
	 */
	abstract public void move();
	/**
	 * empty setter.
	 * @param b Az empty új értéke.
	 */
	public void setEmpty(boolean b) {
		empty = b;
	}
	/**
	 * Absztrakt metódus.
	 * @return Nem lényeges.
	 */
	abstract boolean checkFrontEmpty();
	/**
	 * Absztrakt metódus.
	 * @return Nem lényeges.
	 */
	abstract boolean checkBackEmpty();
	/**
	 * rear setter.
	 * @param w A rear új értéke.
	 */
	public void setRear(Wagon w){
		rear = w;
	}
	/**
	 * front setter.
	 * @param w A front új értéke.
	 */
	public void setFront(Wagon w){
		front = w;
	}
	/**
	 * id getter.
	 * @return A Wagon azonosítója.
	 */
	public String getId(){
		return id;
	}
	/**
	 * front getter.
	 * @return front.
	 */
	public Wagon getFront(){
		return front;
	}
	/**
	 * entering setter.
	 * @param value Az entering új értéke.
	 */
	public void setEntering(boolean value){
		entering = value;
	}
}
