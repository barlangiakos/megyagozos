/**
 * Absztrakt oszt�ly a vonat elemeknek. Ennek k�sz�nhet�, hogy egy�ltal�n l�tezhet vonat a programunkban,
 * m�sk�l�nben nem tudn�nk �sszekapcsolni a k�l�nb�z� t�pus� kocsikat.
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
	 * Absztrakt met�dus, ami az egyes vonatelemek mozgat�s��rt lesz felel�s.
	 */
	abstract public void move();
	/**
	 * empty setter.
	 * @param b Az empty �j �rt�ke.
	 */
	public void setEmpty(boolean b) {
		empty = b;
	}
	/**
	 * Absztrakt met�dus.
	 * @return Nem l�nyeges.
	 */
	abstract boolean checkFrontEmpty();
	/**
	 * Absztrakt met�dus.
	 * @return Nem l�nyeges.
	 */
	abstract boolean checkBackEmpty();
	/**
	 * rear setter.
	 * @param w A rear �j �rt�ke.
	 */
	public void setRear(Wagon w){
		rear = w;
	}
	/**
	 * front setter.
	 * @param w A front �j �rt�ke.
	 */
	public void setFront(Wagon w){
		front = w;
	}
	/**
	 * id getter.
	 * @return A Wagon azonos�t�ja.
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
	 * @param value Az entering �j �rt�ke.
	 */
	public void setEntering(boolean value){
		entering = value;
	}
}
