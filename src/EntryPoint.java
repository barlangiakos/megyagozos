/**
 * A bel�p�si pontot val�s�tja meg, ami tulajdonk�ppen olyan s�ndarab, amin kereszt�l vonatok �rkezhetnek be a p�ly�ra.
 * @author Tajti
 *
 */
public class EntryPoint extends Rail{
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 */
	public EntryPoint(String id){
		super(id);
	}
	/**
	 * A vonat �p�t�s k�r�st tov�bb�tja a TrainFactory sz�m�ra.
	 * @param latest A legutolj�ra l�trehozott vonatelemek azonos�t�ja.
	 * @return A meg�p�lt vonat Locomotivja.
	 */
	public Locomotiv generateTrain(int latest){
		Locomotiv newLoco = TrainFactory.getTrainFactory().buildTrain(latest, this); 
		System.out.println(newLoco.getId() + " entered.");
		return newLoco;
	};
	
}
