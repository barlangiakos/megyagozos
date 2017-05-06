/**
 * Feladata az id�z�t�s megval�s�t�sa. A tesztelhet�s�g miatt az id�z�t�s alapb�l ki van kapcsolva, �s a timerstart parancs hat�s�ra aktiv�lhat�.
 * @author Tajti
 *
 */
public class Timer implements Runnable{
	private Thread t;
	private String threadName;
	private boolean running = true;
	/**
	 * Konstruktor.   
	 * @param name Az �j sz�l neve.
	 */
	Timer(String name) {
	   threadName = name;
	}
	/**
	 * A run() met�dus implement�l�sa. 5 m�sodmercenk�nt l�pteti a j�t�kot.
	 */
	public void run() {
	   try {
	      while(running){
	    	 Controller.getController().tick();
	         Thread.sleep(1000);
	      }
	   }catch (InterruptedException e) {
	      System.out.println("Thread " +  threadName + " interrupted.");
	   }
	}
	/**
	 * A start hat�s�ra j�n l�tre a sz�l, �s indul el a Timer.   
	 */
	public void start () {
	   if (t == null) {
	      t = new Thread (this, threadName);
	      t.start ();
	   }
	}
	/**
	 * le�ll�tja a timert
	 */
	public void cancel(){
		running = false;;
	}
}
