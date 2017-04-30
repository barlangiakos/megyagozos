/**
 * Egyszerû sín. Legfontosabb feladata annak biztosítása, hogy az egyes vonat elemek tudják, hogy merre kell továbbmenniük.
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
	 * @param id A beállítandó azonosító.
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
	 * A paraméterként átadott referencia alapján visszaadja a következõ Rail referenciáját, amire majd a vonat elemnek mozognia kell.
	 * @param prev Az elõzõ Rail, amin a kocsi volt.
	 * @return A következõ Rail, amire a kocsinak tovább kell mozognia.
	 */
	public Rail getNextRail(Rail prev){
		if (prev == rail1) return rail2;
		else return rail1;
	};
	/**
	 * rail1 setter.
	 * @param r A rail1 új értéke.
	 */
	public void setRail1(Rail r){
		rail1 = r;
	};
	/**
	 * rail2 setter.
	 * @param r A rail2 új értéke.
	 */
	public void setRail2(Rail r){
		rail2 = r;
	};
	/**
	 * station setter.
	 * @param s A station új értéke.
	 */
	public void setStation(Station s){	
		station = s;
	};
	/**
	 * Azt szimulálja, amikor egy kocsi elhagyja a sínt.
	 */
	public void leave(){
		wagon = null;
	};
	/**
	 * Azt szimulálja, amikor egy kocsi a sínre lép. Azt is ellenõrzi, hogy volt-e ütközés.
	 * @param w A Wagon, ami a sínre akar mozogni.
	 */
	public void enter(Wagon w){
		if (wagon != null){
			System.out.println(w.getId() + " crashed.");
			Controller.getController().lose();
		}
		else wagon = w;
	};
	/**
	 * Továbbítja a jelzést a megállóhoz, hogy a vagon odaért.
	 * @param color A kocsi színe.
	 * @return Nincs jelentõsége.
	 */
	public boolean getOff(String color){
		if (station != null)
			return station.arrive(color, wagon);
		return false;
	};
	/**
	 * id getter.
	 * @return A Rail azonosítója.
	 */
	public String getId(){
		return id;
	}
	/**
	 * wagon setter.
	 * @param w A wagon új értéke.
	 */
	public void setWagon(Wagon w){
		wagon = w;
	}
	
	public ElementView getView(){
		return rView;
	}
	
	public void setView(ElementView rv){
		rView = rv;
	}
}
