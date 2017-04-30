/**
 * Olyan Rail, amire alagútszáj építhetõ. Felelõssége csupán a vonat elemek megfelelõ helyre való továbbítása
 * (ez magában foglalja azt, hogy felépült alagút esetén az alagútba küldje a vonatot).
 * @author Tajti
 *
 */
public class TunnelSpace extends Rail {
	private Rail tunnelRail;
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 */
	public TunnelSpace(String id){
		super(id);
		tunnelRail = null;
	}
	/**
	 * tunnelRail setter.
	 * @param r A tunnelRail új értéke.
	 */
	public void setTunnelRail(Rail r){
		tunnelRail = r;
	}
	/**
	 * Felépíti/lebontja a TunnelSpacen az alagútszájat.
	 */
	public void build(){
		TunnelController.getTunnelController().connectTunnels(this);
	}
	/**
	 * Visszaadja az átadott paraméter alapján a következõ sínt, amire a kocsinak mozognia kell.
	 * @param prev Az elõzõ Rail, amin a kocsi volt.
	 * @return A következõ Rail, amire a kocsinak mozognia kell.
	 */
	public Rail getNextRail(Rail prev){
		if (prev == rail1 && tunnelRail == null) return rail2;
		else if (prev == rail2 && tunnelRail == null) return rail1;
		else if ((prev == rail1 || prev == rail2) && tunnelRail != null) return tunnelRail;
		else return rail1;
	}
}
