/**
 * Olyan meg�ll�, ahov� az utasok lesz�llhatnak, ha a lesz�ll�si felt�telek teljes�lnek.
 * Feladata biztos�tani azt, hogy az egyes szem�lysz�ll�t� vagonok ki�r�lhessenek.
 * @author Tajti
 *
 */
public class OffStation extends Station{
	/**
	 * Konstruktor.
	 * @param id A be�ll�tand� azonos�t�.
	 * @param color A be�ll�tand� sz�n.
	 */
	public OffStation(String id, String color) {
		super(id, color);
	}
	@Override
	/**
	 * Ha egy kocsi a meg�ll�hoz �rkezett, �s lesz�llhatnak r�la az utasok, akkor ez a met�dus ellen�rzi,
	 * hogy a param�terk�nt adott sz�n megegyezik-e a meg�ll� sz�n�vel, �s ha igen, akkor a w-t �resre �ll�tja (ezzel lesz�ll�tva az utasokat).
	 * @param color A kocsi sz�ne.
	 * @param w A kocsi, amelyik a meg�ll�hoz �rkezett.
	 */
	public boolean arrive(String color, Wagon w) {
		if (this.color.equals(color) && w.getFront().checkFrontEmpty()){
			w.setEmpty(true);
			System.out.println("Passengers got off " + w.getId() + ".");
			return true;
		}
		return false;
	}

}
