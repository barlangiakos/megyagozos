import java.util.ArrayList;
/**
 * Váltók, amik igazából olyan sínek, amiknek 1 bemenetük van, és tetszõleges számú kimenetük.
 * A kimenetet a felhasználónak tudnia kell váltogatni.
 * @author Tajti
 *
 */
public class Switch extends Rail{
	private ArrayList<Rail> rails;
	private int index;
	private SwitchView vsw;
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 */
	public Switch(String id) {
		super(id);
		rails = new ArrayList<Rail>();
		index = 0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * A rail2 referenciát a rails kollekcióban a következõ elemre állítja, ha a kollekció végére ért, akkor az elsõ referenciától indul újra.
	 */
	public void changeRail(){
		if(wagon == null){
			rail2 = rails.get(++index);
			System.out.println(id + " changed to " + rail2.getId() + ".");
			if (index == rails.size()-1) index = -1;
		}
	};
	/**
	 * Új Rail objektumot ad a rails kollekcióhoz.
	 * @param r Az új Rail.
	 */
	public void addRail(Rail r){
		rails.add(r);
	}
}
