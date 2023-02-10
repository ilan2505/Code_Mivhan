package first;

class TheThread implements Runnable {
	String name; // name of thread
	Thread t;
	TheThread(String threadname) {
		name = threadname;
		t = new Thread(this, name);
		System.out.println("New thread: " + t);
		t.start(); // Start the thread
	} 
	// This is the entry point for thread.
	public void run() {
		try {
			for(int i = 10; i > 0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.println("into thread "+name + " interrupted.");}
		System.out.println(name + " exiting.");
	}
}

public class JoinInterrupt_Demo {
	public static void main(String args[]) {
		TheThread obj = new TheThread("One");
		System.out.println("Thread One is alive: "+ obj.t.isAlive());
		// wait for threads to finish
		try {
			System.out.println("Waiting for threads to finish.");
			obj.t.join(500);
			if (obj.t.isAlive()){
				obj.t.interrupt();
				System.out.println("Thread One is alive immediatly after interrupt?: "+ obj.t.isAlive());
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		// This sleep allows to thread obj.t to die
        try {
            Thread.sleep(1);
          } 
        catch (InterruptedException e) {}
		System.out.println("Thread One is alive: "+ obj.t.isAlive());
		System.out.println("Main thread exiting.");
	}
}
/**
	New thread: Thread[One,5,main]
	Thread One is alive: true
	Waiting for threads to finish.
	One: 5
	One: 4
	One interrupted.
	One exiting.
	Thread One is alive: false
	Main thread exiting.
 */
