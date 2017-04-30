/**
 * Olyan Rail, amire alag�tsz�j �p�thet�. Felel�ss�ge csup�n a vonat elemek megfelel� helyre val� tov�bb�t�sa
 * (ez mag�ban foglalja azt, hogy fel�p�lt alag�t eset�n az alag�tba k�ldje a vonatot).
 * @author Tajti
 *
 */
public class TunnelSpace extends Rail {
	private Rail tunnelRail;
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 */
	public TunnelSpace(String id){
		super(id);
		tunnelRail = null;
	}
	/**
	 * tunnelRail setter.
	 * @param r A tunnelRail �j �rt�ke.
	 */
	public void setTunnelRail(Rail r){
		tunnelRail = r;
	}
	/**
	 * Fel�p�ti/lebontja a TunnelSpacen az alag�tsz�jat.
	 */
	public void build(){
		TunnelController.getTunnelController().connectTunnels(this);
	}
	/**
	 * Visszaadja az �tadott param�ter alapj�n a k�vetkez� s�nt, amire a kocsinak mozognia kell.
	 * @param prev Az el�z� Rail, amin a kocsi volt.
	 * @return A k�vetkez� Rail, amire a kocsinak mozognia kell.
	 */
	public Rail getNextRail(Rail prev){
		if (prev == rail1 && tunnelRail == null) return rail2;
		else if (prev == rail2 && tunnelRail == null) return rail1;
		else if ((prev == rail1 || prev == rail2) && tunnelRail != null) return tunnelRail;
		else return rail1;
	}
}
