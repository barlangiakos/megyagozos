/**
 * Olyan megálló, ahová az utasok leszállhatnak, ha a leszállási feltételek teljesülnek.
 * Feladata biztosítani azt, hogy az egyes személyszállító vagonok kiürülhessenek.
 * @author Tajti
 *
 */
public class OffStation extends Station{
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 * @param color A beállítandó szín.
	 */
	public OffStation(String id, String color) {
		super(id, color);
	}
	@Override
	/**
	 * Ha egy kocsi a megállóhoz érkezett, és leszállhatnak róla az utasok, akkor ez a metódus ellenõrzi,
	 * hogy a paraméterként adott szín megegyezik-e a megálló színével, és ha igen, akkor a w-t üresre állítja (ezzel leszállítva az utasokat).
	 * @param color A kocsi színe.
	 * @param w A kocsi, amelyik a megállóhoz érkezett.
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
