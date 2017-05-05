import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Application osztály, ahonnan az alkalmazás indult.
 * Feladata a bemenetre való várakozás elindítása, átadja a vezérlést a controllernek.
 * @author Tajti
 *
 */

public class Application {
	public static void main(String[] args) throws FileNotFoundException{

		StartScreenView StartScreen = new StartScreenView();

		StartScreen.startButton.addActionListener(e -> {
            StartScreen.dispose();
            Controller.getController().createMap();
            //Controller.getController().startTimer();
        });

		StartScreen.exitButton.addActionListener(e -> {
            System.out.println("Exit");
            System.exit(1);
        });
	}
}
