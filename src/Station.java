/**
 * Absztrakt osztály az állomásoknak. Egy Station lehet OnStation vagy OffStation.
 * @author Tajti
 *
 */
abstract public class Station {
	protected String color;
	protected String id;
	protected StationView sView;
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 * @param color A beállítandó szín.
	 */
	public Station(String id, String color){
		this.color = color;
		this.id = id;
	}
	/**
	 * id getter.
	 * @return A Station azonosítója.
	 */
	public String getId(){
		return id;
	}
	/**
	 * Absztrakt metódus, amit a leszármazottaknak meg kell valósítaniuk.
	 * Azt kell kezelnie, amikor egy kocsi a megállóhoz ér.
	 * @param color A kocsi színe.
	 * @param w A kocsi, amelyik a megállóhoz ért.
	 * @return Nincs jelentõsége.
	 */
	abstract public boolean arrive(String color, Wagon w);
	
	public StationView getView(){
		return sView;
	}
}
