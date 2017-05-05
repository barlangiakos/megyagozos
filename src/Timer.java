/**
 * Feladata az idõzítés megvalósítása. A tesztelhetõség miatt az idõzítés alapból ki van kapcsolva, és a timerstart parancs hatására aktiválható.
 * @author Tajti
 *
 */
public class Timer implements Runnable{
	private Thread t;
	private String threadName;
	private boolean running = true;
	/**
	 * Konstruktor.   
	 * @param name Az új szál neve.
	 */
	Timer(String name) {
	   threadName = name;
	}
	/**
	 * A run() metódus implementálása. 5 másodmercenként lépteti a játékot.
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
	 * A start hatására jön létre a szál, és indul el a Timer.   
	 */
	public void start () {
	   if (t == null) {
	      t = new Thread (this, threadName);
	      t.start ();
	   }
	}
	
	public void cancel(){
		running = false;;
	}
}
