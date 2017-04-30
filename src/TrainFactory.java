/**
 * Egyetlen met�dusa vonatokat �ll�t el�.
 * Ez csak abban seg�t, hogy �tl�that�bb legyen a k�d, �s ne kelljen mindig �sszekapcsolni m�g a vonat elemeket is. (Singleton)
 * @author Tajti
 *
 */
public class TrainFactory {
	private TrainFactory() {}
	private static TrainFactory trainfactory = new TrainFactory();
	/**
	 * Visszaadja az egyetlen TrainFactory p�ld�nyt.
	 * @return Az egyetlen TrainFactory p�ld�ny.
	 */
	public static TrainFactory getTrainFactory() {
		return trainfactory;
	}
	/**
	 * Fel�p�t egy vonatot, �sszekapcsolja az elemeket, �s visszat�r annak Locomotivj�val, �gy el�rhet� marad a teljes vonat.
	 * @param latest Az utolj�ra l�trehozott vonatelemek azonos�t�j�nak sorsz�ma.
	 * @param ep Az EntryPoint, ahova le kell tenni a vonatot.
	 * @return Az �j vonat Locomotivja.
	 */
	public Locomotiv buildTrain(int latest, EntryPoint ep){
		Locomotiv loco = new Locomotiv("L" + Integer.toString(latest));
		PassangerCar pc1 = new PassangerCar("PC" + Integer.toString(latest), "green");
		PassangerCar pc2 = new PassangerCar("PC" + Integer.toString(latest+1), "red");
		CoalWagon cw = new CoalWagon("CW" + Integer.toString(latest));
		loco.setRear(pc1);
		pc1.setFront(loco);
		pc1.setRear(cw);
		cw.setFront(pc1);
		cw.setRear(pc2);
		pc2.setFront(cw);
		loco.setCurrentRail(ep);
		int x = ep.getView().getX();
		int y = ep.getView().getY();
		LocomotivView lv1 = new LocomotivView(x, y, 80, 23);
		PassengerCarView pcv1 = new PassengerCarView(x, y, 80, 23);
		pc1.setView(pcv1);
		pcv1.setImage("img/" + pc1.getColor() + "pc.jpg");
		PassengerCarView pcv2 = new PassengerCarView(x, y, 80, 23);
		pc2.setView(pcv2);
		pcv2.setImage("img/" + pc2.getColor() + "pc.jpg");
		CoalWagonView cwv = new CoalWagonView(x, y, 80, 23);
		cw.setView(cwv);
		cwv.setImage("img/cw.jpg");
		loco.setView(lv1);
		lv1.setImage("img/locomotiv.jpg");
		Controller.getController().addElement(pcv2);
		Controller.getController().addElement(cwv);
		Controller.getController().addElement(pcv1);
		Controller.getController().addElement(lv1);
		pc1.setCurrentRail(ep);
		cw.setCurrentRail(ep);
		pc2.setCurrentRail(ep);
		loco.setEntering(true);
		pc1.setEntering(true);
		pc2.setEntering(true);
		cw.setEntering(true);
		return loco;
	};
}
