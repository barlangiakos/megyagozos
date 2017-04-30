import java.util.ArrayList;
/**
 * A TunnelController feladata k�t meg�p�lt alag�t sz�j k�z�tti alag�t l�trehoz�sa, illetve lebont�sa.
 * Ezen k�v�l t�rolja az alag�t sz�jak k�z�tti s�neket, amiket l�trehoz. (Singleton)
 * @author Tajti
 *
 */
public class TunnelController {
	private TunnelSpace t1;
	private TunnelSpace t2;
	private ArrayList<Rail> rails;
	/**
	 * priv�t konstruktor.
	 */
	private TunnelController() {
		t1 = null;
		t2 = null;
		rails = new ArrayList<Rail>();
	}

	private static TunnelController tc = new TunnelController();
	/**
	 * Ezzel lehet hozz�f�rni a TunnelController egyetlen p�ld�ny�hoz.
	 * @return A TunnelController egyetlen p�ld�nya.
	 */
	public static TunnelController getTunnelController() {
		return tc;
	}
	/**
	 * Elt�rolja, hogy a t TunnelSpace meg van �p�tve (ha eddig nem volt, egy�bk�nt azt a referenci�j�t, ami t-re mutat nullra �ll�tja),
	 * valamint ha az elt�rol�s ut�n van 2 referenci�ja TunnelSpace objektumokra, akkor l�trehoz �s elt�rol s�neket, amikkel �sszek�ti a k�t TunnelSpace-t.
	 * @param t A fel�p�tend�/lebontand� TunnelSpace.
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
	 * @param t t1 �j �rt�ke.
	 */
	public void setT1(TunnelSpace t){
		t1 = t;
	}
	/**
	 * t2 setter.
	 * @param t t2 �j �rt�ke.
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
	 * �j railt ad a rails kollekci�hoz.
	 * @param r Az �j Rail.
	 */
	public void addRail(Rail r){
		rails.add(r);
	}
	/**
	 * A megadott azonos�t�j� Railt adja vissza a rails list�b�l.
	 * @param id A keresett Rail azonos�t�ja.
	 * @return A megadott azonos�t�j� Rail.
	 */
	public Rail getRail(String id){
		for (Rail rail : rails){
			if(rail.getId().equals(id))
				return rail;
		}
		return null;
	}
}
