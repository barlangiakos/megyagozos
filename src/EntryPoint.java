/**
 * A belépési pontot valósítja meg, ami tulajdonképpen olyan síndarab, amin keresztül vonatok érkezhetnek be a pályára.
 * @author Tajti
 *
 */
public class EntryPoint extends Rail{
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 */
	public EntryPoint(String id){
		super(id);
	}
	/**
	 * A vonat építés kérést továbbítja a TrainFactory számára.
	 * @param latest A legutoljára létrehozott vonatelemek azonosítója.
	 * @return A megépült vonat Locomotivja.
	 */
	public Locomotiv generateTrain(int latest){
		Locomotiv newLoco = TrainFactory.getTrainFactory().buildTrain(latest, this); 
		System.out.println(newLoco.getId() + " entered.");
		return newLoco;
	};
	
}
