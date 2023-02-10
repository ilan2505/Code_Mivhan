package volatileCheck;

public class VTest extends Thread{
	//volatile boolean keepRunning = true;
	boolean keepRunning = true;
	public void setKeepRunning(boolean keepRunning) {
		this.keepRunning = keepRunning;
	}
	int c=0;
	public void run() {
		while (keepRunning) {
			c++;
			//System.out.println("into the thread  "+(c++));
		}
		System.out.println("Thread terminated.");
	}

	public static void main(String[] args) throws InterruptedException {
		VTest t = new VTest();
		t.start();
		Thread.sleep(100);
		t.setKeepRunning(false);
		System.out.println("keepRunning set to false.");
		System.out.println("exit main");

	}

}
