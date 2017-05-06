/**
 * Egyszer� s�n. Legfontosabb feladata annak biztos�t�sa, hogy az egyes vonat elemek tudj�k, hogy merre kell tov�bbmenni�k.
 * @author Tajti
 *
 */
public class Rail {
	protected Rail rail1;
	protected Rail rail2;
	protected Station station;
	protected boolean empty;
	protected String id;
	protected Wagon wagon;
	protected ElementView rView;
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 */
	public Rail(String id){
		this.id = id;
		rail1 = null;
		rail2 = null;
		station = null;
		empty = true;
		wagon = null;
	}
	/**
	 * A param�terk�nt �tadott referencia alapj�n visszaadja a k�vetkez� Rail referenci�j�t, amire majd a vonat elemnek mozognia kell.
	 * @param prev Az el�z� Rail, amin a kocsi volt.
	 * @return A k�vetkez� Rail, amire a kocsinak tov�bb kell mozognia.
	 */
	public Rail getNextRail(Rail prev){
		if (prev == rail1) return rail2;
		else return rail1;
	};
	/**
	 * rail1 setter.
	 * @param r A rail1 �j �rt�ke.
	 */
	public void setRail1(Rail r){
		rail1 = r;
	};
	/**
	 * rail2 setter.
	 * @param r A rail2 �j �rt�ke.
	 */
	public void setRail2(Rail r){
		rail2 = r;
	};
	/**
	 * station setter.
	 * @param s A station �j �rt�ke.
	 */
	public void setStation(Station s){	
		station = s;
	};
	/**
	 * Azt szimul�lja, amikor egy kocsi elhagyja a s�nt.
	 */
	public void leave(){
		wagon = null;
	};
	/**
	 * Azt szimul�lja, amikor egy kocsi a s�nre l�p. Azt is ellen�rzi, hogy volt-e �tk�z�s.
	 * @param w A Wagon, ami a s�nre akar mozogni.
	 */
	public void enter(Wagon w){
		if (wagon != null){
			System.out.println(w.getId() + " crashed.");
			Controller.getController().lose();
		}
		else wagon = w;
	};
	/**
	 * Tov�bb�tja a jelz�st a meg�ll�hoz, hogy a vagon oda�rt.
	 * @param color A kocsi sz�ne.
	 * @return Nincs jelent�s�ge.
	 */
	public boolean getOff(String color){
		if (station != null)
			return station.arrive(color, wagon);
		return false;
	};
	/**
	 * id getter.
	 * @return A Rail azonos�t�ja.
	 */
	public String getId(){
		return id;
	}
	/**
	 * wagon setter.
	 * @param w A wagon �j �rt�ke.
	 */
	public void setWagon(Wagon w){
		wagon = w;
	}
	/**
	 * rView getter
	 * @return rView
	 */
	public ElementView getView(){
		return rView;
	}
	/**
	 * rView setter
	 * @param rv rView �j �rt�ke
	 */
	public void setView(ElementView rv){
		rView = rv;
	}
	/**
	 * A s�nen tart�zkod� vonatot adja vissza (vagy null)
	 * @return wagon
	 */
	public Wagon getWagon(){
		return wagon;
	}
}
