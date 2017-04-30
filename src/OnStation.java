/**
 * Olyan megálló, ahonnan az utasok felszállhatnak, ha a felszállási feltételek teljesülnek.
 * Feladata biztosítani azt, hogy az egyes személyszállító vagonokba szállhasssanak is fel utasok.
 * @author Tajti
 *
 */
public class OnStation extends Station{
	/**
	 * Konstruktor.
	 * @param id A beállítandó azonosító.
	 * @param color A beállítandó szín.
	 */
	public OnStation(String id, String color) {
		super(id, color);
	}

	@Override
	/**
	 * Ha egy kocsi a megállóhoz érkezett, és felszállhatnak rá utasok, akkor ez a metódus ellenõrzi,
	 * hogy a paraméterként adott szín megegyezik-e a megálló színével, és ha igen,
	 * akkor a w empty attribútumát hamisra állítja (ezzel felszálltak az utasok).
	 * @param color A kocsi színe.
	 * @param w A kocsi, amelyik a megállóhoz érkezett.
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
