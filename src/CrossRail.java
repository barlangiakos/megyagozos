/**
 * Keresztezõdõ sínek viselkedését valósítja meg.
 * Megfelelõen kell továbbküldenie a kocsikat a következõ sínre.
 * Viselkedése tulajdonképpen azonos a Rail osztály viselkedésével, az egyetlen különbség, hogy több Rail referenciája van,
 * amiket a következõ sín visszaadásakor használnia kell.
 * @author Tajti
 *
 */
public class CrossRail extends Rail{
	private Rail rail3 = null;
	private Rail rail4 = null;
	
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 */
	public CrossRail(String id){
		super(id);
	}
	/**
	 * rail3 setter.
	 * @param r A beállítandó Rail.
	 */
	public void setRail3(Rail r){
		rail3 = r;
	}
	/**
	 * rail4 setter.
	 * @param r A beállítandó Rail.
	 */
	public void setRail4(Rail r){
		rail4 = r;
	}
	/**
	 * A paraméterként átadott referencia alapján visszaadja a következõ Rail referenciáját, amire majd a vonat elemnek mozognia kell.
	 * @param prev Az elõzõ Rail, amin a Wagon volt.
	 * @return A következõ Rail referenciája.
	 */
	public Rail getNextRail(Rail prev){
		if (prev == rail1) return rail2;
		else if (prev == rail2) return rail1;
		else if (prev == rail3) return rail4;
		else return rail3;
	};
}
