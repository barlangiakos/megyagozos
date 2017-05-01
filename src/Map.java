
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * A pálya statikus elemeit tárolja. A felhasználó a Controlleren keresztül tudja befolyásolni a pálya néhány (nem összes) objektumát.
 * Ezen kívül a Map feladata a pálya létrehozása a pályafájlok alapján, és a létrehozott elemek összekapcsolása, eltárolása is.
 * @author Tajti
 *
 */
public class Map {
	
	private ArrayList<Rail> rails;
	private ArrayList<EntryPoint> entryPoints;
	private ArrayList<Switch> switches;
	private ArrayList<TunnelSpace> tunnelSpaces;
	private ArrayList<CrossRail> crossRails;
	private ArrayList<OffStation> offStations;
	private ArrayList<OnStation> onStations;
	private int counter = 0;
	/**
	 * Konstruktor.
	 */
	public Map(){
		rails = new ArrayList<Rail>();
		entryPoints = new ArrayList<EntryPoint>();
		switches = new ArrayList<Switch>();
		tunnelSpaces = new ArrayList<TunnelSpace>();
		crossRails = new ArrayList<CrossRail>();
		offStations = new ArrayList<OffStation>();
		onStations = new ArrayList<OnStation>();
	}
	/**
	 * A megadott azonosítójú Switch állását váltja.
	 * @param id A váltandó Switch azonosítója.
	 */
	public void changeSwitch(String id){
		for (Switch sw : switches){
			if(sw.getId().equals(id))
				sw.changeRail();
		}
	}
	/**
	 * A megadott azonosítójú TunnelSpacen alagútszájat épít/bont le.
	 * @param id A TunnelSpace azonosítója.
	 */
	public void build (String id){
		for(TunnelSpace t : tunnelSpaces){
			if(t.getId().equals(id)) TunnelController.getTunnelController().connectTunnels(t);
		}
	}
	/**
	 * A pályán lévõ elsõ EntryPoint-tól új vonat behozását kéri.
	 * @param latest A legutoljára generált vonatelemek azonosítói.
	 * @return A kész vonat Locomotivja.
	 */
	public Locomotiv generateTrain(int latest){
		Locomotiv l = entryPoints.get(counter).generateTrain(latest);
		if (counter < entryPoints.size()-1)
			counter++;
		return l;
	}
	
	public void create(){
		EntryPoint ep = new EntryPoint("ep");
		entryPoints.add(ep);
		RailView vEp = new RailView(0,50, 80, 24);
		vEp.setImage("img/rail.jpg");
		ep.setView(vEp);
		vEp.setModel(ep);
		
		Rail r1 = new Rail("r1");
		ep.setRail2(r1);
		r1.setRail1(ep);
		RailView vr1 = new RailView(80, 50, 80, 24);
		vr1.setImage("img/rail.jpg");
		r1.setView(vr1);
		vr1.setModel(r1);
		rails.add(r1);
		
		Rail r2 = new Rail("r2");
		r1.setRail2(r2);
		r2.setRail1(r1);
		RailView vr2 = new RailView(160, 50, 80, 24);
		vr2.setImage("img/rail.jpg");
		r2.setView(vr2);
		vr2.setModel(r2);
		rails.add(r2);
		
		Rail r3 = new Rail("r3");
		RailView vr3 = new RailView(320, 74, 24, 80);
		vr3.setImage("img/rail2.jpg");
		r3.setView(vr3);
		vr3.setModel(r3);
		rails.add(r3);
		
		Rail r4 = new Rail("r4");
		RailView vr4 = new RailView(320, 234, 24, 80);
		vr4.setImage("img/rail2.jpg");
		r4.setView(vr4);
		vr4.setModel(r4);
		rails.add(r4);
		
		Rail r5 = new Rail("r5");
		RailView vr5 = new RailView(210, 344, 80, 24);
		vr5.setImage("img/rail.jpg");
		r5.setView(vr5);
		vr5.setModel(r5);
		rails.add(r5);
		
		CrossRail cr1 = new CrossRail("cr1");
		cr1.setRail1(r5);
		cr1.setRail3(r4);
		r4.setRail2(cr1);
		RailView vcr1 = new RailView(290, 314, 80, 80);
		vcr1.setImage("img/cr.jpg");
		cr1.setView(vcr1);
		vcr1.setModel(cr1);
		crossRails.add(cr1);
		
		Rail r6 = new Rail("r6");
		r6.setRail1(cr1);
		cr1.setRail2(r6);
		RailView vr6 = new RailView(370, 344, 80, 24);
		vr6.setImage("img/rail.jpg");
		r6.setView(vr6);
		vr6.setModel(r6);
		rails.add(r6);
		
		Rail r7 = new Rail("r7");
		r7.setRail1(cr1);
		cr1.setRail4(r7);
		RailView vr7 = new RailView(320, 394, 24, 80);
		vr7.setImage("img/rail2.jpg");
		r7.setView(vr7);
		vr7.setModel(r7);
		rails.add(r7);
		
		Rail r8 = new Rail("r8");
		r8.setRail1(r2);
		r8.setRail2(r3);
		r3.setRail1(r8);
		r2.setRail2(r8);
		RailView vr8 = new RailView(240, 50, 80, 24);
		vr8.setImage("img/rail.jpg");
		r8.setView(vr8);
		vr8.setModel(r8);
		rails.add(r8);
		
		Switch sw1 = new Switch("sw1");
		sw1.setRail1(r3);
		sw1.setRail2(r4);
		r3.setRail2(sw1);
		r4.setRail1(sw1);
		sw1.addRail(r4);
		SwitchView vsw1 = new SwitchView(310, 154, 80, 80, sw1, "img/switch42.jpg", "img/switch41.jpg");
		sw1.setView(vsw1);
		switches.add(sw1);
		
		Rail r9 = new Rail("r9");
		r9.setRail1(sw1);
		sw1.addRail(r9);
		RailView vr9 = new RailView(390, 210, 80, 24);
		vr9.setImage("img/rail.jpg");
		r9.setView(vr9);
		vr9.setModel(r9);
		rails.add(r9);
		
		Rail r10 = new Rail("r10");
		r10.setRail1(r5);
		r5.setRail2(cr1);
		r5.setRail1(r10);
		RailView vr10 = new RailView(186, 368, 24, 80);
		vr10.setImage("img/rail2.jpg");
		r10.setView(vr10);
		vr10.setModel(r10);
		rails.add(r10);
		
		Switch sw2 = new Switch("sw2");
		sw2.setRail2(r10);
		r10.setRail2(sw2);
		sw2.addRail(r10);
		SwitchView vsw2 = new SwitchView(136, 448, 80, 80, sw2, "img/switch22.jpg", "img/switch21.jpg");
		sw2.setView(vsw2);
		switches.add(sw2);
		
		EntryPoint ep2 = new EntryPoint("ep2");
		entryPoints.add(ep2);
		RailView vEp2 = new RailView(56, 450, 80, 24);
		vEp2.setImage("img/rail.jpg");
		ep2.setView(vEp2);
		vEp2.setModel(ep2);
		ep2.setRail2(sw2);
		sw2.addRail(ep2);
		
		Rail r11 = new Rail("r11");
		r11.setRail1(sw2);
		sw2.setRail1(r11);
		RailView vr11 = new RailView(186, 528, 24, 80);
		vr11.setImage("img/rail2.jpg");
		r11.setView(vr11);
		vr11.setModel(r11);
		rails.add(r11);
		
		Rail r12 = new Rail("r12");
		r12.setRail1(r9);
		r9.setRail2(r12);
		RailView vr12 = new RailView(470, 210, 80, 24);
		vr12.setImage("img/rail.jpg");
		r12.setView(vr12);
		vr12.setModel(r12);
		rails.add(r12);
		
		Rail r13 = new Rail("r13");
		r13.setRail1(r12);
		r12.setRail2(r13);
		RailView vr13 = new RailView(550, 210, 80, 24);
		vr13.setImage("img/rail.jpg");
		r13.setView(vr13);
		vr13.setModel(r13);
		rails.add(r13);
		
		Rail r14 = new Rail("r14");
		r14.setRail1(r13);
		r13.setRail2(r14);
		RailView vr14 = new RailView(630, 210, 80, 24);
		vr14.setImage("img/rail.jpg");
		r14.setView(vr14);
		vr14.setModel(r14);
		rails.add(r14);
		
		OffStation offgreen = new OffStation("offgreen", "green");
		r12.setStation(offgreen);
		StationView voffgreen = new StationView(470,186,80,23);
		voffgreen.setImage("img/greenstation.jpg");
		offgreen.setView(voffgreen);
		offStations.add(offgreen);
		
		Switch sw3 = new Switch("sw3");
		sw3.setRail1(r14);
		r14.setRail2(sw3);
		SwitchView vsw3 = new SwitchView(710, 210, 80, 80, sw3, "img/switch82.jpg", "img/switch81.jpg");
		sw3.setView(vsw3);
		switches.add(sw3);
		
		TunnelSpace ts1 = new TunnelSpace("ts1");
		TunnelSpaceView vts1 = new TunnelSpaceView(870,210,80,24);
		vts1.setImage("img/tsNotBuilt.jpg");
		ts1.setView(vts1);
		vts1.setModel(ts1);
		tunnelSpaces.add(ts1);
		
		Rail r15 = new Rail("r15");
		r15.setRail1(sw3);
		sw3.addRail(r15);
		RailView vr15 = new RailView(766, 290, 24, 80);
		vr15.setImage("img/rail2.jpg");
		r15.setView(vr15);
		vr15.setModel(r15);
		rails.add(r15);
		
		Rail r16 = new Rail("r16");
		r16.setRail1(sw3);
		sw3.setRail2(r16);
		sw3.addRail(r16);
		ts1.setRail1(r16);
		r16.setRail2(ts1);
		RailView vr16 = new RailView(790, 210, 80, 24);
		vr16.setImage("img/rail.jpg");
		r16.setView(vr16);
		vr16.setModel(r16);
		rails.add(r16);
		
		Rail r17 = new Rail("r17");
		r17.setRail1(ts1);
		ts1.setRail2(r17);
		RailView vr17 = new RailView(950, 210, 80, 24);
		vr17.setImage("img/rail.jpg");
		r17.setView(vr17);
		vr17.setModel(r17);
		rails.add(r17);
		
		Rail r18 = new Rail("r18");
		r18.setRail1(r17);
		r17.setRail2(r18);
		RailView vr18 = new RailView(1030, 210, 80, 24);
		vr18.setImage("img/rail.jpg");
		r18.setView(vr18);
		vr18.setModel(r18);
		rails.add(r18);

		
		Controller.getController().addElement(vEp);
		Controller.getController().addElement(vr1);
		Controller.getController().addElement(vr2);
		Controller.getController().addElement(vr3);
		Controller.getController().addElement(vr4);
		Controller.getController().addElement(vr5);
		Controller.getController().addElement(vcr1);
		Controller.getController().addElement(vr6);
		Controller.getController().addElement(vr7);
		Controller.getController().addElement(vr8);
		Controller.getController().addElement(vsw1);
		Controller.getController().addElement(vr9);
		Controller.getController().addElement(vr10);
		Controller.getController().addElement(vsw2);
		Controller.getController().addElement(vEp2);
		Controller.getController().addElement(vr11);
		Controller.getController().addElement(vr12);
		Controller.getController().addElement(vr13);
		Controller.getController().addElement(vr14);
		Controller.getController().addElement(voffgreen);
		Controller.getController().addElement(vsw3);
		Controller.getController().addElement(vts1);
		Controller.getController().addElement(vr15);
		Controller.getController().addElement(vr16);
		Controller.getController().addElement(vr17);
		Controller.getController().addElement(vr18);
	}
	
	/**
	 * A pályafájl alapján létrehozza a pályát.
	 * Létrehozza a pályaelemeket, összekapcsolja õket, majd eltárolja azokat.
	 * @param fileName A pályaleíró fájl neve.
	 */
	public void createMap(String fileName){
		String line;
		try {
		    InputStream fis = new FileInputStream(fileName);
		    InputStreamReader isr = new InputStreamReader(fis);
		    BufferedReader br = new BufferedReader(isr);
		    while ((line = br.readLine()) != null) {
		        String[] parts = line.split(";");
		        
		        Rail currentrail = null;
            	Rail prevrail = null;
		        
		        switch (parts[0]) {
	            case "Rail":
	            	rails.add(new Rail(parts[1]));
	            	break;
	            case "TunnelRail":
	            	TunnelController.getTunnelController().addRail(new Rail(parts[1]));
	            	break;
	            case "EntryPoint":
	            	entryPoints.add(new EntryPoint(parts[1]));
	            	break;
	            case "Switch":
	            	switches.add(new Switch(parts[1]));
	            	break;
	            case "TunnelSpace":
	            	TunnelSpace t = new TunnelSpace(parts[1]);
	            	if(parts[2].equals("+")){
	            		if(TunnelController.getTunnelController().getT1() == null){
	            			TunnelController.getTunnelController().setT1(t);
	            		}
	            		else TunnelController.getTunnelController().setT2(t);
	            	}
            		tunnelSpaces.add(t);
	            	break;
	            case "CrossRail":
	            	crossRails.add(new CrossRail(parts[1]));
	            	break;
	            case "OnStation":
	            	onStations.add(new OnStation(parts[1], parts[2]));
	            	break;
	            case "OffStation":
	            	offStations.add(new OffStation(parts[1], parts[2]));
	            	break;
	            case "Locomotiv":
	            	currentrail = null;
	            	prevrail = null;
	            	
	            	for(Rail rail : rails){
	            		if(rail.id.equals(parts[2]))
	            			currentrail = rail;
	            		if(rail.id.equals(parts[3]))
	            			prevrail = rail;
	            	}
	            	
	            	for(EntryPoint ep : entryPoints){
	            		if(ep.id.equals(parts[2]))
	            			currentrail = ep;
	            		if(ep.id.equals(parts[3]))
	            			prevrail = ep;
	            	}
	            	
	            	for(Switch sw : switches){
	            		if(sw.id.equals(parts[2]))
	            			currentrail = sw;
	            		if(sw.id.equals(parts[3]))
	            			prevrail = sw;
	            	}
	            	
	            	for(TunnelSpace ts : tunnelSpaces){
	            		if(ts.id.equals(parts[2]))
	            			currentrail = ts;
	            		if(ts.id.equals(parts[3]))
	            			prevrail = ts;
	            	}
	            	
	            	for(CrossRail cr : crossRails){
	            		if(cr.id.equals(parts[2]))
	            			currentrail = cr;
	            		if(cr.id.equals(parts[3]))
	            			prevrail = cr;
	            	}
	            	
	            	Controller.getController().addLoco(new Locomotiv(parts[1], currentrail, prevrail));
	            	break;
	            case "CoalWagon":
	            	currentrail = null;
	            	prevrail = null;
	            	
	            	for(Rail rail : rails){
	            		if(rail.id.equals(parts[2]))
	            			currentrail = rail;
	            		if(rail.id.equals(parts[3]))
	            			prevrail = rail;
	            	}
	            	
	            	for(EntryPoint ep : entryPoints){
	            		if(ep.id.equals(parts[2]))
	            			currentrail = ep;
	            		if(ep.id.equals(parts[3]))
	            			prevrail = ep;
	            	}
	            	
	            	for(Switch sw : switches){
	            		if(sw.id.equals(parts[2]))
	            			currentrail = sw;
	            		if(sw.id.equals(parts[3]))
	            			prevrail = sw;
	            	}
	            	
	            	for(TunnelSpace ts : tunnelSpaces){
	            		if(ts.id.equals(parts[2]))
	            			currentrail = ts;
	            		if(ts.id.equals(parts[3]))
	            			prevrail = ts;
	            	}
	            	
	            	for(CrossRail cr : crossRails){
	            		if(cr.id.equals(parts[2]))
	            			currentrail = cr;
	            		if(cr.id.equals(parts[3]))
	            			prevrail = cr;
	            	}
	            	
	            	Controller.getController().addCW(new CoalWagon(parts[1], currentrail, prevrail));
	            	break;
	            case "PassangerCar":
	            	currentrail = null;
	            	prevrail = null;
	            	
	            	for(Rail rail : rails){
	            		if(rail.id.equals(parts[2]))
	            			currentrail = rail;
	            		if(rail.id.equals(parts[3]))
	            			prevrail = rail;
	            	}
	            	
	            	for(EntryPoint ep : entryPoints){
	            		if(ep.id.equals(parts[2]))
	            			currentrail = ep;
	            		if(ep.id.equals(parts[3]))
	            			prevrail = ep;
	            	}
	            	
	            	for(Switch sw : switches){
	            		if(sw.id.equals(parts[2]))
	            			currentrail = sw;
	            		if(sw.id.equals(parts[3]))
	            			prevrail = sw;
	            	}
	            	
	            	for(TunnelSpace ts : tunnelSpaces){
	            		if(ts.id.equals(parts[2]))
	            			currentrail = ts;
	            		if(ts.id.equals(parts[3]))
	            			prevrail = ts;
	            	}
	            	
	            	for(CrossRail cr : crossRails){
	            		if(cr.id.equals(parts[2]))
	            			currentrail = cr;
	            		if(cr.id.equals(parts[3]))
	            			prevrail = cr;
	            	}
	            	
	            	Controller.getController().addPC(new PassangerCar(parts[1], parts[4], currentrail, prevrail, parts[5]));
	            	break;
	            case "RailInit":
	            	railInit(parts);
	            	break;
	            case "TunnelRailInit":
	            	tunnelrailInit(parts);
	            	break;
	            case "EntryPointInit":
	            	entryPointInit(parts);
	            	break;
	            case "SwitchInit":
	            	switchInit(parts);
	            	break;
	            case "TunnelSpaceInit":
	            	tunnelSpaceInit(parts);
	            	break;
	            case "CrossRailInit":
	            	crossRailInit(parts);
	            	break;
	            case "LocomotivInit":
	            	locomotivInit(parts);
	            	break;
	            case "PCInit":
	            	pcInit(parts);
	            	break;
	            case "CWInit":
	            	cwInit(parts);
	            	break;
		        }
		    }
		    System.out.println("Map Created.");
		    System.out.println("Game Started.");
		    br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a Locomotivokat.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void locomotivInit(String[] parts){
		Locomotiv loco;
		
		loco = Controller.getController().getLoco(parts[1]);
		loco.setFront(null);
		loco.setRear(Controller.getController().getWagon(parts[2]));
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a PassangerCarokat.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void pcInit(String[] parts){
		PassangerCar pc = Controller.getController().getPC(parts[1]);
	
		pc.setFront(Controller.getController().getWagon(parts[2]));
		pc.setRear(Controller.getController().getWagon(parts[3]));
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a CoalWagonokat.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void cwInit(String[] parts){
		CoalWagon cw = Controller.getController().getCW(parts[1]);
		
		cw.setFront(Controller.getController().getWagon(parts[2]));
		cw.setRear(Controller.getController().getWagon(parts[3]));
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a Raileket.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void railInit (String[] parts){
		Rail actrail = null;
    	Rail rail1 = null;
    	Rail rail2 = null;
    	OffStation offs = null;
    	OnStation ons = null;
    	
    	Wagon w = Controller.getController().getWagon(parts[5]);
    	
    	for(Rail rail : rails){
    		if(rail.id.equals(parts[1]))
    			actrail = rail;
    		if(rail.id.equals(parts[2]))
    			rail1 = rail;
    		if(rail.id.equals(parts[3]))
    			rail2 = rail;
    	}
    	
    	actrail.setWagon(w);
    	
    	for(EntryPoint ep : entryPoints){
    		if(ep.id.equals(parts[2]))
    			rail1 = ep;
    		if(ep.id.equals(parts[3]))
    			rail2 = ep;
    	}
    	
    	for(Switch sw : switches){
    		if(sw.id.equals(parts[2]))
    			rail1 = sw;
    		if(sw.id.equals(parts[3]))
    			rail2 = sw;
    	}
    	
    	for(TunnelSpace ts : tunnelSpaces){
    		if(ts.id.equals(parts[2]))
    			rail1 = ts;
    		if(ts.id.equals(parts[3]))
    			rail2 = ts;
    	}
    	
    	for(CrossRail cr : crossRails){
    		if(cr.id.equals(parts[2]))
    			rail1 = cr;
    		if(cr.id.equals(parts[3]))
    			rail2 = cr;
    	}
    	
    	for (OffStation offstation : offStations){
    		if(offstation.id.equals(parts[4]))
    			offs = offstation;
    	}
    	
    	for (OnStation onstation : onStations){
    		if(onstation.id.equals(parts[4]))
    			ons = onstation;
    	}
    	
    	if(parts[2].equals("-"))
    		actrail.setRail1(null);
    	else
    		actrail.setRail1(rail1);
    	
    	if(parts[3].equals("-"))
    		actrail.setRail2(null);
    	else
    		actrail.setRail2(rail2);
    	
    	if(parts[4].equals("-"))
    		actrail.setStation(null);
    	else if (offs == null)
    		actrail.setStation(ons);
    	else
    		actrail.setStation(offs);
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a TunnelSpacek között lévõ Raileket.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void tunnelrailInit (String[] parts){
		Rail actrail = TunnelController.getTunnelController().getRail(parts[1]);
    	Rail rail1 = TunnelController.getTunnelController().getRail(parts[2]);
    	Rail rail2 = TunnelController.getTunnelController().getRail(parts[3]);
    	
    	Wagon w = Controller.getController().getWagon(parts[4]);
    	
    	actrail.setWagon(w);
    	
    	for(TunnelSpace ts : tunnelSpaces){
    		if(ts.id.equals(parts[2]))
    			rail1 = ts;
    		if(ts.id.equals(parts[3]))
    			rail2 = ts;
    	}
    	
    	actrail.setRail1(rail1);
    	actrail.setRail2(rail2);
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a Switcheket.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void switchInit (String[] parts){
		Switch actsw = null;
		Rail rail1 = null;
		Rail rail2 = null;
    	OffStation offs = null;
    	OnStation ons = null;
    	
    	Wagon w = Controller.getController().getWagon(parts[5]);
    	
    	for(Switch sw : switches)
    		if(sw.id.equals(parts[1]))
    			actsw = sw;
    	
    	actsw.setWagon(w);
    	
    	for(int i=6; i < parts.length; i++){
    		for(Rail rail : rails){
    			if(rail.id.equals(parts[i]))
    				actsw.addRail(rail);
    			if(rail.id.equals(parts[3]))
    				rail1 = rail;
    			if(rail.id.equals(parts[4]))
    				rail2 = rail;
    		}
    	}
    	
    	for(int i=6; i < parts.length; i++){
    		for(EntryPoint ep : entryPoints){
    			if(ep.id.equals(parts[i]))
    				actsw.addRail(ep);
    			if(ep.id.equals(parts[3]))
    				rail1 = ep;
    			if(ep.id.equals(parts[4]))
    				rail2 = ep;
    		}
    	}
    	
    	for(int i=6; i < parts.length; i++){
    		for(Switch sw : switches){
    			if(sw.id.equals(parts[i]))
    				actsw.addRail(sw);
    			if(sw.id.equals(parts[3]))
    				rail1 = sw;
    			if(sw.id.equals(parts[4]))
    				rail2 = sw;
    		}
    	}
    	
    	for(int i=6; i < parts.length; i++){
    		for(TunnelSpace ts : tunnelSpaces){
    			if(ts.id.equals(parts[i]))
    				actsw.addRail(ts);
    			if(ts.id.equals(parts[3]))
    				rail1 = ts;
    			if(ts.id.equals(parts[4]))
    				rail2 = ts;
    		}
    	}
    	
    	for(int i=6; i < parts.length; i++){
    		for(CrossRail cr : crossRails){
    			if(cr.id.equals(parts[i]))
    				actsw.addRail(cr);
    			if(cr.id.equals(parts[3]))
    				rail1 = cr;
    			if(cr.id.equals(parts[4]))
    				rail2 = cr;
    		}
    	}

    	for (OffStation offstation : offStations){
    		if(offstation.id.equals(parts[2]))
    			offs = offstation;
    	}
    	
    	for (OnStation onstation : onStations){
    		if(onstation.id.equals(parts[2]))
    			ons = onstation;
    	}
    	
    	if(parts[3].equals("-"))
    		actsw.setRail1(null);
    	else
    		actsw.setRail1(rail1);
    	
    	if(parts[4].equals("-"))
    		actsw.setRail2(null);
    	else
    		actsw.setRail2(rail2);
    	
    	if(parts[2].equals("-"))
    		actsw.setStation(null);
    	else if (offs == null)
    		actsw.setStation(ons);
    	else
    		actsw.setStation(offs);
	}
	/**
	 * A pályaleíró fájl alapján inicializálja az EntryPointokat.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void entryPointInit(String[] parts){
		EntryPoint actep = null;
    	Rail rail2 = null;
    	OffStation offs = null;
    	OnStation ons = null;
    	
    	Wagon w = Controller.getController().getWagon(parts[4]);
    	
    	for(Rail rail : rails){
    		if(rail.id.equals(parts[2]))
    			rail2 = rail;
    	}
    	
    	for(EntryPoint ep : entryPoints){
    		if(ep.id.equals(parts[2]))
    			rail2 = ep;
    		if(ep.id.equals(parts[1]))
    			actep = ep;
    	}
    	
    	actep.setWagon(w);
    	
    	for(Switch sw : switches){
    		if(sw.id.equals(parts[2]))
    			rail2 = sw;
    	}
    	
    	for(TunnelSpace ts : tunnelSpaces){
    		if(ts.id.equals(parts[2]))
    			rail2 = ts;
    	}
    	
    	for(CrossRail cr : crossRails){
    		if(cr.id.equals(parts[2]))
    			rail2 = cr;
    	}
    	
    	for (OffStation offstation : offStations){
    		if(offstation.id.equals(parts[3]))
    			offs = offstation;
    	}
    	
    	for (OnStation onstation : onStations){
    		if(onstation.id.equals(parts[3]))
    			ons = onstation;
    	}
    	
    	actep.setRail1(null);
    	
    	if(parts[2].equals("-"))
    		actep.setRail2(null);
    	else
    		actep.setRail2(rail2);
    	
    	if(parts[3].equals("-"))
    		actep.setStation(null);
    	else if (offs == null)
    		actep.setStation(ons);
    	else
    		actep.setStation(offs);
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a TunnelSpaceket.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void tunnelSpaceInit(String[] parts){
		TunnelSpace actts = null;
    	Rail rail1 = null;
    	Rail rail2 = null;
    	OffStation offs = null;
    	OnStation ons = null;
    	Rail tr = TunnelController.getTunnelController().getRail(parts[6]);
    	Wagon w = Controller.getController().getWagon(parts[5]);
    	
    	for(Rail rail : rails){
    		if(rail.id.equals(parts[2]))
    			rail1 = rail;
    		if(rail.id.equals(parts[3]))
    			rail2 = rail;
    	}
    	
    	for(EntryPoint ep : entryPoints){
    		if(ep.id.equals(parts[2]))
    			rail1 = ep;
    		if(ep.id.equals(parts[3]))
    			rail2 = ep;
    	}
    	
    	for(Switch sw : switches){
    		if(sw.id.equals(parts[2]))
    			rail1 = sw;
    		if(sw.id.equals(parts[3]))
    			rail2 = sw;
    	}
    	
    	for(TunnelSpace ts : tunnelSpaces){
    		if(ts.id.equals(parts[1]))
    			actts = ts;
    		if(ts.id.equals(parts[2]))
    			rail1 = ts;
    		if(ts.id.equals(parts[3]))
    			rail2 = ts;
    	}
    	
    	actts.setWagon(w);
    	actts.setTunnelRail(tr);
    	
    	for(CrossRail cr : crossRails){
    		if(cr.id.equals(parts[2]))
    			rail1 = cr;
    		if(cr.id.equals(parts[3]))
    			rail2 = cr;
    	}
    	
    	for (OffStation offstation : offStations){
    		if(offstation.id.equals(parts[4]))
    			offs = offstation;
    	}
    	
    	for (OnStation onstation : onStations){
    		if(onstation.id.equals(parts[4]))
    			ons = onstation;
    	}
    	
    	if(parts[2].equals("-"))
    		actts.setRail1(null);
    	else
    		actts.setRail1(rail1);
    	
    	if(parts[3].equals("-"))
    		actts.setRail2(null);
    	else
    		actts.setRail2(rail2);
    	
    	if(parts[4].equals("-"))
    		actts.setStation(null);
    	else if (offs == null)
    		actts.setStation(ons);
    	else
    		actts.setStation(offs);
	}
	/**
	 * A pályaleíró fájl alapján inicializálja a CrossRaileket.
	 * @param parts A pályafájlban szereplõ adatok.
	 */
	public void crossRailInit(String[] parts){
		CrossRail actcr = null;
    	Rail rail1 = null;
    	Rail rail2 = null;
    	Rail rail3 = null;
    	Rail rail4 = null;
    	OffStation offs = null;
    	OnStation ons = null;
    	
    	Wagon w = Controller.getController().getWagon(parts[7]);
    	
    	for(Rail rail : rails){
    		if(rail.id.equals(parts[2]))
    			rail1 = rail;
    		if(rail.id.equals(parts[3]))
    			rail2 = rail;
    		if(rail.id.equals(parts[4]))
    			rail3 = rail;
    		if(rail.id.equals(parts[5]))
    			rail4 = rail;
    	}
    	
    	for(EntryPoint ep : entryPoints){
    		if(ep.id.equals(parts[2]))
    			rail1 = ep;
    		if(ep.id.equals(parts[3]))
    			rail2 = ep;
    		if(ep.id.equals(parts[4]))
    			rail3 = ep;
    		if(ep.id.equals(parts[5]))
    			rail4 = ep;
    	}
    	
    	for(Switch sw : switches){
    		if(sw.id.equals(parts[2]))
    			rail1 = sw;
    		if(sw.id.equals(parts[3]))
    			rail2 = sw;
    		if(sw.id.equals(parts[4]))
    			rail3 = sw;
    		if(sw.id.equals(parts[5]))
    			rail4 = sw;
    	}
    	
    	for(TunnelSpace ts : tunnelSpaces){
    		if(ts.id.equals(parts[2]))
    			rail1 = ts;
    		if(ts.id.equals(parts[3]))
    			rail2 = ts;
    		if(ts.id.equals(parts[4]))
    			rail3 = ts;
    		if(ts.id.equals(parts[5]))
    			rail4 = ts;
    	}
    	
    	for(CrossRail cr : crossRails){
    		if(cr.id.equals(parts[1]))
    			actcr = cr;
    		if(cr.id.equals(parts[2]))
    			rail1 = cr;
    		if(cr.id.equals(parts[3]))
    			rail2 = cr;
    		if(cr.id.equals(parts[4]))
    			rail3 = cr;
    		if(cr.id.equals(parts[5]))
    			rail4 = cr;
    	}
    	
    	actcr.setWagon(w);
    	
    	for (OffStation offstation : offStations){
    		if(offstation.id.equals(parts[6]))
    			offs = offstation;
    	}
    	
    	for (OnStation onstation : onStations){
    		if(onstation.id.equals(parts[6]))
    			ons = onstation;
    	}
    	
    	if(parts[2].equals("-"))
    		actcr.setRail1(null);
    	else
    		actcr.setRail1(rail1);
    	
    	if(parts[3].equals("-"))
    		actcr.setRail2(null);
    	else
    		actcr.setRail2(rail2);
    	
    	if(parts[4].equals("-"))
    		actcr.setRail3(null);
    	else
    		actcr.setRail3(rail3);
    	
    	if(parts[5].equals("-"))
    		actcr.setRail4(null);
    	else
    		actcr.setRail4(rail4);
    	
    	if(parts[6].equals("-"))
    		actcr.setStation(null);
    	else if (offs == null)
    		actcr.setStation(ons);
    	else
    		actcr.setStation(offs);
	}
}
