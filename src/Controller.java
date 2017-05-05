import java.io.*;
import java.util.*;

/**
 * Biztos�tja, hogy a felhaszn�l� be tudjon avatkozni a j�t�k menet�be: tudja �ll�tani a v�lt�kat, tudjon alag�t sz�jakat �p�teni/lebontani.
 * Ezen k�v�l k�pes a vonatok mozgat�s�nak kezdem�nyez�s�re, �j vonat behoz�s�ra, valamint a j�t�k v�g�nek ellen�rz�s�re (Singleton oszt�ly).
 * @author Tajti
 *
 */

public class Controller {
	private Map map;
	private ArrayList<Locomotiv> locomotives;
	private ArrayList<PassangerCar> pcs;
	private ArrayList<CoalWagon> cws;
	private int trainTime;
	private int level;
	private int latest = 1;
	int wincount = 0;
	int traincount = 0;
	private Views views;
	/**
	 * Konstruktor. Inicializ�lja a Controllert.
	 */
	private Controller() {
		map = new Map();
		locomotives = new ArrayList<Locomotiv>();
		pcs = new ArrayList<PassangerCar>();
		cws = new ArrayList<CoalWagon>();
		trainTime = 2;
		level = 1;
		views = new Views();
	}
	
	public void createMap(){
		map.create();
	}
	
	private static Controller controller = new Controller();
	/**
	 * Singleton oszt�ly, ezzel a met�dussal �rhet� el az egyetlen p�d�nya.
	 * @return A Controller egyetlen p�ld�nya.
	 */
	public static Controller getController() {
		return controller;
	}
	/**
	 * L�pteti a j�t�kot, �gy ezen bel�l t�rt�nik a vonatok mozgat�sa, a j�t�k v�g�nek ellen�rz�se.
	 * Esetlegesen az �j vonatot hoz be a p�ly�ra.
	 */
	public void tick(){
		for (Locomotiv loco : locomotives){
			loco.move();
		}
		
		views.drawAll();
		
		for (Locomotiv loco : locomotives){
			if (loco.getWin() == false){
				if (loco.checkBackEmpty()){
					wincount++;
					loco.setWin(true);
				}
			}
		}
		
		if (wincount == (level*2)){
			System.out.println("You won!");
			return;
		}
		
		trainTime--;
		if(trainTime == 0 && traincount < (level*2)){
			locomotives.add(map.generateTrain(latest++));
			trainTime = 30;
			traincount++;
		}
		
	};
	/**
	 * Az id azonos�t�j� TunnelSpace-re val� alag�t sz�j �p�t�s�t/lebont�s�t kezdem�nyezi (tov�bb�tja a Maphez).
	 * @param id A fel�p�tend�/lebontand� alag�tsz�j azonos�t�ja.
	 */
	public void buildTunnel(String id){
		map.build(id);
	};
	/**
	 * Az id azonos�t�j� Switch �ll�s�nak v�ltoztat�s�t kezdem�nyezi (tov�bb�tja a Maphez).
	 * @param id A v�ltand� v�lt� azonos�t�ja.
	 */
	public void changeSwitch(String id){
		map.changeSwitch(id);
	};
	/**
	 * Vonatok �tk�z�se eset�n a veres�get kezeli (le�ll az alkalmaz�s).
	 */
	public void lose(){
		System.exit(0);
	};
	/**
	 * Olvassa a bemenetet a standard inputr�l. A bemenet f�ggv�ny�ben h�v meg tov�bbi met�dusokat.
	 * Ez a met�dus biztos�tja, hogy a felhaszn�l� interakci�ba tudjon l�pni a j�t�kkal.
	 * Ezen k�v�l a tesztel�st is nagyban t�mogatja.
	 */
	public void readInput(){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			
			while (true){
				
				String line = br.readLine();
				String[] cmd = line.split(" ");
				
				if (cmd[0].equals("newgame")) map.createMap(cmd[1]);
				else if (cmd[0].equals("buildtunnel")) buildTunnel(cmd[1]);
				else if (cmd[0].equals("changeswitch")) changeSwitch(cmd[1]);
				else if (cmd[0].equals("tick")){
					for(int i = 0; i < Integer.parseInt(cmd[1]); i++) tick();
				}
				else if (cmd[0].equals("loadCommands")) loadCommands(cmd[1]);	
				else if (cmd[0].equals("timerstart")){
					Timer t = new Timer("Timerthread");
					t.start();
				}
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	/**
	 * A loadCommands parancs megval�s�t�s��rt felel.
	 * Beolvassa egy f�jlb�l a megl�v� parancsokat ahelyett, hogy egyes�vel k�ne be�rni �ket.
	 * @param fileName A beolvasand� f�jl neve.
	 */
	public void loadCommands(String fileName){
		
		String line;
		try {
			PrintStream original = System.out;
			PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
			System.setOut(out);
			
		    InputStream fis = new FileInputStream(fileName);
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);
		    while ((line = br.readLine()) != null) {
		    	
		    	String cmd[] = line.split(" ");
		    	
		    	if (cmd[0].equals("newgame")) map.createMap(cmd[1]);
		    	else if (cmd[0].equals("buildtunnel")) buildTunnel(cmd[1]);
				else if (cmd[0].equals("changeswitch")) changeSwitch(cmd[1]);
				else if (cmd[0].equals("tick")){
					for(int i = 0; i < Integer.parseInt(cmd[1]); i++) tick();
				}
				else if (cmd[0].equals("timerstart")){
					Timer t = new Timer("Timerthread");
					t.start();
				}
		    	
		    }
		    
		    System.setOut(original);
		    System.out.println("Commands loaded.");
		    System.out.println("Commands executed.");
		    System.out.println("Result logged to log file.");
		    br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * A locomotives list�hoz �j Locomotiv elemet ad.
	 * @param loco Az �j Locomotiv. 
	 */
	public void addLoco(Locomotiv loco){
		locomotives.add(loco);
	}
	/**
	 * A cws list�hoz �j CoalWagon elemet ad.
	 * @param cw Az �j CoalWagon.
	 */
	public void addCW(CoalWagon cw){
		cws.add(cw);
	}
	/**
	 * A pcs list�hoz �j PassangerCar elemet ad.
	 * @param pc Az �j PassangerCar.
	 */
	public void addPC(PassangerCar pc){
		pcs.add(pc);
	}
	/**
	 * A param�terk�nt megadott azonos�t�j� Wagon objektummal t�r vissza.
	 * @param part A keresett Wagon azonos�t�ja.
	 * @return A part azonos�t�j� Wagon.
	 */
	public Wagon getWagon(String part){
		for (PassangerCar pc : pcs){
			if (pc.getId().equals(part))
				return pc;
		}
		for (Locomotiv loco : locomotives){
			if (loco.getId().equals(part))
				return loco;
		}
		for (CoalWagon cw : cws){
			if (cw.getId().equals(part))
				return cw;
		}
		return null;
	}
	/**
	 * A param�terk�nt megadott azonos�t�j� Wagon objektummal t�r vissza.
	 * @param part A keresett Locomotiv azonos�t�ja.
	 * @return A part azonos�t�j� Locomotiv.
	 */
	public Locomotiv getLoco(String part){
		for (Locomotiv loco : locomotives){
			if (loco.getId().equals(part))
				return loco;
		}
		return null;
	}
	/**
	 * A param�terk�nt megadott azonos�t�j� PassangerCar objektummal t�r vissza.
	 * @param part A keresett PassangerCar azonos�t�ja.
	 * @return A part azonos�t�j� PassangerCar.
	 */
	public PassangerCar getPC(String part){
		for (PassangerCar pc : pcs){
			if (pc.getId().equals(part))
				return pc;
		}
		return null;
	}
	/**
	 * A param�terk�nt megadott azonos�t�j� CoalWagon objektummal t�r vissza.
	 * @param part A keresett CoalWagon azonos�t�ja.
	 * @return A part azonos�t�j� CoalWagon.
	 */
	public CoalWagon getCW(String part){
		for (CoalWagon cw : cws){
			if (cw.getId().equals(part))
				return cw;
		}
		return null;
	}
	
	public void addElement(ElementView ev){
		views.addElement(ev);
	}
	
	public void startTimer(){
		Timer t = new Timer("Timerthread");
		t.start();
	}
}
