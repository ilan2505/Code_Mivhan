package deadlock;

public class Deadlock {
	public static Thread t1,t2;

	public static void main(String[] args) {
		final Object resource1 = new Object();
		final Object resource2 = new Object();
		// t1 tries to lock resource1 then resource2
		t1 = new Thread() {
			public void run() {
				// Lock resource 1
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				synchronized (resource2) {
					System.out.println("Thread 1: locked resource 2");
				}
				System.out.println("t1 DONE!");
			}
		};

		// t2 tries to lock resource2 then resource1
		t2 = new Thread() {
			public void run() {
				// the second thread waits for first thread to terminate
				// deadlock does not occur
				/*
				 * try { t1.join(); } catch (InterruptedException e) {}
				 */				
					synchronized (resource2) {
					System.out.println("Thread 2: locked resource 2");
						synchronized (resource1) {
							System.out.println("Thread 2: locked resource 1");
					}
				}
				System.out.println("t2 DONE!");
			}
		};

		t1.start();
		t2.start();
	}

}
