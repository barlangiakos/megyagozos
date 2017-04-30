import java.util.ArrayList;
/**
 * A TunnelController feladata két megépült alagút száj közötti alagút létrehozása, illetve lebontása.
 * Ezen kívül tárolja az alagút szájak közötti síneket, amiket létrehoz. (Singleton)
 * @author Tajti
 *
 */
public class TunnelController {
	private TunnelSpace t1;
	private TunnelSpace t2;
	private ArrayList<Rail> rails;
	/**
	 * privát konstruktor.
	 */
	private TunnelController() {
		t1 = null;
		t2 = null;
		rails = new ArrayList<Rail>();
	}

	private static TunnelController tc = new TunnelController();
	/**
	 * Ezzel lehet hozzáférni a TunnelController egyetlen példányához.
	 * @return A TunnelController egyetlen példánya.
	 */
	public static TunnelController getTunnelController() {
		return tc;
	}
	/**
	 * Eltárolja, hogy a t TunnelSpace meg van építve (ha eddig nem volt, egyébként azt a referenciáját, ami t-re mutat nullra állítja),
	 * valamint ha az eltárolás után van 2 referenciája TunnelSpace objektumokra, akkor létrehoz és eltárol síneket, amikkel összeköti a két TunnelSpace-t.
	 * @param t A felépítendõ/lebontandó TunnelSpace.
	 */
	public void connectTunnels(TunnelSpace t){
		if (t1 == t){
			t.setTunnelRail(null);
			t1 = null;
			System.out.println(t.getId() + " destroyed.");
			t.getView().setImage("img/tsNotBuilt.jpg");
			if (rails.size() != 0){
				rails = new ArrayList<Rail>();
				System.out.println("Tunnel destroyed between " + t.getId() + " and " + t2.getId() + ".");
			}
		}
		
		else if (t2 == t){
			t.setTunnelRail(null);
			rails = new ArrayList<Rail>();
			t2 = null;
			System.out.println(t.getId() + " destroyed.");
			t.getView().setImage("img/tsNotBuilt.jpg");
			if (rails.size() != 0){
				rails = new ArrayList<Rail>();
				System.out.println("Tunnel destroyed between " + t1.getId() + " and " + t.getId() + ".");
			}
			
		}
		
		else if (t1 == null && t2 == null){
			t1 = t;
			t.getView().setImage("img/tsBuilt.jpg");
			System.out.println(t.getId() + " built.");
		}
		
		else if (t1 != t && t2 == null){
			t2 = t;
			t.getView().setImage("img/tsBuilt.jpg");
			Rail tunnelRail1 = new Rail("tr1");
			Rail tunnelRail2 = new Rail("tr2");
			rails.add(tunnelRail1);
			rails.add(tunnelRail2);
			t1.setTunnelRail(tunnelRail1);
			t2.setTunnelRail(tunnelRail2);
			tunnelRail1.setRail1(t1);
			tunnelRail1.setRail2(tunnelRail2);
			tunnelRail2.setRail1(tunnelRail1);
			tunnelRail2.setRail2(t2);
			System.out.println(t.getId() + " built.");
			System.out.println("Tunnel created between " + t1.getId() + " and " + t2.getId() + ".");
		}
		
		else if (t1 == null && t2 != t){
			t1 = t;
			t.getView().setImage("img/tsBuilt.jpg");
			Rail tunnelRail1 = new Rail("tr1");
			Rail tunnelRail2 = new Rail("tr2");
			rails.add(tunnelRail1);
			rails.add(tunnelRail2);
			t1.setTunnelRail(tunnelRail1);
			t2.setTunnelRail(tunnelRail2);
			tunnelRail1.setRail1(t1);
			tunnelRail1.setRail2(tunnelRail2);
			tunnelRail2.setRail1(tunnelRail1);
			tunnelRail2.setRail2(t2);
			System.out.println(t.getId() + " built.");
			System.out.println("Tunnel created between " + t1.getId() + " and " + t2.getId() + ".");
		}
		
		else{
			System.out.println(t.getId() + " cannot be built.");
		}
	};
	/**
	 * t1 setter.
	 * @param t t1 új értéke.
	 */
	public void setT1(TunnelSpace t){
		t1 = t;
	}
	/**
	 * t2 setter.
	 * @param t t2 új értéke.
	 */
	public void setT2(TunnelSpace t){
		t2 = t;
	}
	/**
	 * t1 getter.
	 * @return t1.
	 */
	public TunnelSpace getT1(){
		return t1;
	}
	/**
	 * t2 getter.
	 * @return t2.
	 */
	public TunnelSpace getT2(){
		return t2;
	}
	/**
	 * Új railt ad a rails kollekcióhoz.
	 * @param r Az új Rail.
	 */
	public void addRail(Rail r){
		rails.add(r);
	}
	/**
	 * A megadott azonosítójú Railt adja vissza a rails listából.
	 * @param id A keresett Rail azonosítója.
	 * @return A megadott azonosítójú Rail.
	 */
	public Rail getRail(String id){
		for (Rail rail : rails){
			if(rail.getId().equals(id))
				return rail;
		}
		return null;
	}
}
