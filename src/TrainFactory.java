/**
 * Egyetlen metódusa vonatokat állít elõ.
 * Ez csak abban segít, hogy átláthatóbb legyen a kód, és ne kelljen mindig összekapcsolni még a vonat elemeket is. (Singleton)
 * @author Tajti
 *
 */
public class TrainFactory {
	private TrainFactory() {}
	private static TrainFactory trainfactory = new TrainFactory();
	/**
	 * Visszaadja az egyetlen TrainFactory példányt.
	 * @return Az egyetlen TrainFactory példány.
	 */
	public static TrainFactory getTrainFactory() {
		return trainfactory;
	}
	/**
	 * Felépít egy vonatot, összekapcsolja az elemeket, és visszatér annak Locomotivjával, így elérhetõ marad a teljes vonat.
	 * @param latest Az utoljára létrehozott vonatelemek azonosítójának sorszáma.
	 * @param ep Az EntryPoint, ahova le kell tenni a vonatot.
	 * @return Az új vonat Locomotivja.
	 */
	public Locomotiv buildTrain(int latest, EntryPoint ep){
		Locomotiv loco = new Locomotiv("L" + Integer.toString(latest));
		PassangerCar pc1 = new PassangerCar("PC" + Integer.toString(latest), "green");
		PassangerCar pc2 = new PassangerCar("PC" + Integer.toString(latest+1), "red");
		PassangerCar pc3 = new PassangerCar("PC" + Integer.toString(latest+2), "blue");
		CoalWagon cw = new CoalWagon("CW" + Integer.toString(latest));
		loco.setRear(pc1);
		pc1.setFront(loco);
		pc1.setRear(cw);
		cw.setFront(pc1);
		cw.setRear(pc2);
		pc2.setFront(cw);
		pc2.setRear(pc3);
		pc3.setFront(pc2);
		loco.setCurrentRail(ep);
		int x = ep.getView().getX();
		int y = ep.getView().getY();
		LocomotivView lv1 = new LocomotivView(x, y, 80, 23);
		PassengerCarView pcv1 = new PassengerCarView(x, y, 80, 23, pc1);
		pc1.setView(pcv1);
		pcv1.setImage("img/" + pc1.getColor() + "rightpc.jpg");
		PassengerCarView pcv2 = new PassengerCarView(x, y, 80, 23, pc2);
		pc2.setView(pcv2);
		pcv2.setImage("img/" + pc2.getColor() + "rightpc.jpg");
		
		PassengerCarView pcv3 = new PassengerCarView(x, y, 80, 23, pc3);
		pc3.setView(pcv3);
		pcv3.setImage("img/" + pc3.getColor() + "rightpc.jpg");
		
		CoalWagonView cwv = new CoalWagonView(x, y, 80, 23);
		cw.setView(cwv);
		cwv.setImage("img/cwright.jpg");
		loco.setView(lv1);
		lv1.setImage("img/locomotivright.jpg");
		Controller.getController().addElement(pcv3);
		Controller.getController().addElement(pcv2);
		Controller.getController().addElement(cwv);
		Controller.getController().addElement(pcv1);
		Controller.getController().addElement(lv1);
		pc1.setCurrentRail(ep);
		cw.setCurrentRail(ep);
		pc2.setCurrentRail(ep);
		pc3.setCurrentRail(ep);
		loco.setEntering(true);
		pc1.setEntering(true);
		pc2.setEntering(true);
		pc3.setEntering(true);
		cw.setEntering(true);
		return loco;
	};
}
