import java.util.ArrayList;
/**
 * V�lt�k, amik igaz�b�l olyan s�nek, amiknek 1 bemenet�k van, �s tetsz�leges sz�m� kimenet�k.
 * A kimenetet a felhaszn�l�nak tudnia kell v�ltogatni.
 * @author Tajti
 *
 */
public class Switch extends Rail{
	private ArrayList<Rail> rails;
	private int index;
	private SwitchView vsw;
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 */
	public Switch(String id) {
		super(id);
		rails = new ArrayList<Rail>();
		index = 0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * A rail2 referenci�t a rails kollekci�ban a k�vetkez� elemre �ll�tja, ha a kollekci� v�g�re �rt, akkor az els� referenci�t�l indul �jra.
	 */
	public void changeRail(){
		if(wagon == null){
			rail2 = rails.get(++index);
			System.out.println(id + " changed to " + rail2.getId() + ".");
			if (index == rails.size()-1) index = -1;
		}
	};
	/**
	 * �j Rail objektumot ad a rails kollekci�hoz.
	 * @param r Az �j Rail.
	 */
	public void addRail(Rail r){
		rails.add(r);
	}
}
