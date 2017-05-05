import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Biztosítja, hogy a felhasználó be tudjon avatkozni a játék menetébe: tudja állítani a váltókat, tudjon alagút szájakat építeni/lebontani.
 * Ezen kívül képes a vonatok mozgatásának kezdeményezésére, új vonat behozására, valamint a játék végének ellenõrzésére (Singleton osztály).
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
	private Timer t = new Timer("Timerthread");
	/**
	 * Konstruktor. Inicializálja a Controllert.
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
	 * Singleton osztály, ezzel a metódussal érhetõ el az egyetlen pédánya.
	 * @return A Controller egyetlen példánya.
	 */
	public static Controller getController() {
		return controller;
	}
	/**
	 * Lépteti a játékot, így ezen belül történik a vonatok mozgatása, a játék végének ellenõrzése.
	 * Esetlegesen az új vonatot hoz be a pályára.
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
	 * Az id azonosítójú TunnelSpace-re való alagút száj építését/lebontását kezdeményezi (továbbítja a Maphez).
	 * @param id A felépítendõ/lebontandó alagútszáj azonosítója.
	 */
	public void buildTunnel(String id){
		map.build(id);
	};
	/**
	 * Az id azonosítójú Switch állásának változtatását kezdeményezi (továbbítja a Maphez).
	 * @param id A váltandó váltó azonosítója.
	 */
	public void changeSwitch(String id){
		map.changeSwitch(id);
	};
	/**
	 * Vonatok ütközése esetén a vereséget kezeli (leáll az alkalmazás).
	 */
	public void lose(){
		//System.exit(0);
		t.cancel();
		JFrame frame = new JFrame();
		frame.setSize(900, 720);
		frame.add(new JLabel(new ImageIcon("img/lz.jpg")));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		views.close();
		
	};
	/**
	 * Olvassa a bemenetet a standard inputról. A bemenet függvényében hív meg további metódusokat.
	 * Ez a metódus biztosítja, hogy a felhasználó interakcióba tudjon lépni a játékkal.
	 * Ezen kívül a tesztelést is nagyban támogatja.
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
	 * A loadCommands parancs megvalósításáért felel.
	 * Beolvassa egy fájlból a meglévõ parancsokat ahelyett, hogy egyesével kéne beírni õket.
	 * @param fileName A beolvasandó fájl neve.
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
	 * A locomotives listához új Locomotiv elemet ad.
	 * @param loco Az új Locomotiv. 
	 */
	public void addLoco(Locomotiv loco){
		locomotives.add(loco);
	}
	/**
	 * A cws listához új CoalWagon elemet ad.
	 * @param cw Az új CoalWagon.
	 */
	public void addCW(CoalWagon cw){
		cws.add(cw);
	}
	/**
	 * A pcs listához új PassangerCar elemet ad.
	 * @param pc Az új PassangerCar.
	 */
	public void addPC(PassangerCar pc){
		pcs.add(pc);
	}
	/**
	 * A paraméterként megadott azonosítójú Wagon objektummal tér vissza.
	 * @param part A keresett Wagon azonosítója.
	 * @return A part azonosítójú Wagon.
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
	 * A paraméterként megadott azonosítójú Wagon objektummal tér vissza.
	 * @param part A keresett Locomotiv azonosítója.
	 * @return A part azonosítójú Locomotiv.
	 */
	public Locomotiv getLoco(String part){
		for (Locomotiv loco : locomotives){
			if (loco.getId().equals(part))
				return loco;
		}
		return null;
	}
	/**
	 * A paraméterként megadott azonosítójú PassangerCar objektummal tér vissza.
	 * @param part A keresett PassangerCar azonosítója.
	 * @return A part azonosítójú PassangerCar.
	 */
	public PassangerCar getPC(String part){
		for (PassangerCar pc : pcs){
			if (pc.getId().equals(part))
				return pc;
		}
		return null;
	}
	/**
	 * A paraméterként megadott azonosítójú CoalWagon objektummal tér vissza.
	 * @param part A keresett CoalWagon azonosítója.
	 * @return A part azonosítójú CoalWagon.
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
		t.start();
	}
}
