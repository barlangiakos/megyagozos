/**
 * Olyan meg�ll�, ahonnan az utasok felsz�llhatnak, ha a felsz�ll�si felt�telek teljes�lnek.
 * Feladata biztos�tani azt, hogy az egyes szem�lysz�ll�t� vagonokba sz�llhasssanak is fel utasok.
 * @author Tajti
 *
 */
public class OnStation extends Station{
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 * @param color A be�ll�tand� sz�n.
	 */
	public OnStation(String id, String color) {
		super(id, color);
	}

	@Override
	/**
	 * Ha egy kocsi a meg�ll�hoz �rkezett, �s felsz�llhatnak r� utasok, akkor ez a met�dus ellen�rzi,
	 * hogy a param�terk�nt adott sz�n megegyezik-e a meg�ll� sz�n�vel, �s ha igen,
	 * akkor a w empty attrib�tum�t hamisra �ll�tja (ezzel felsz�lltak az utasok).
	 * @param color A kocsi sz�ne.
	 * @param w A kocsi, amelyik a meg�ll�hoz �rkezett.
	 */
	public boolean arrive(String color, Wagon w) {
		if (this.color.equals(color)){
			w.setEmpty(false);
			System.out.println("Passengers got on " + w.getId() + ".");
			return true;
		}
		return false;
	}
	
}
