/**
 * Absztrakt oszt�ly az �llom�soknak. Egy Station lehet OnStation vagy OffStation.
 * @author Tajti
 *
 */
abstract public class Station {
	protected String color;
	protected String id;
	protected StationView sView;
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 * @param color A be�ll�tand� sz�n.
	 */
	public Station(String id, String color){
		this.color = color;
		this.id = id;
	}
	/**
	 * id getter.
	 * @return A Station azonos�t�ja.
	 */
	public String getId(){
		return id;
	}
	/**
	 * Absztrakt met�dus, amit a lesz�rmazottaknak meg kell val�s�taniuk.
	 * Azt kell kezelnie, amikor egy kocsi a meg�ll�hoz �r.
	 * @param color A kocsi sz�ne.
	 * @param w A kocsi, amelyik a meg�ll�hoz �rt.
	 * @return Nincs jelent�s�ge.
	 */
	abstract public boolean arrive(String color, Wagon w);
	
	/**
	 * sView getter
	 * @return sView
	 */
	public StationView getView(){
		return sView;
	}
	/**
	 * sView setter
	 * @param v sView �j �rt�ke
	 */
	public void setView(StationView v){
		sView = v;
	}
}
