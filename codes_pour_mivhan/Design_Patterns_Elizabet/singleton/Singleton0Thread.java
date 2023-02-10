package singleton;
// The simple singleton
public final class Singleton0Thread {
	private static Singleton0Thread _instance = null;
	int x = 0;
	private Singleton0Thread() {
		x++;
	}
	public int getX() {
		return x;
	}
	public static synchronized Singleton0Thread getInstance() {
		if (_instance == null) {
			_instance = new Singleton0Thread();
			System.out.println("i just created a instance!");
		}
		return _instance;
	}
	public static void main(String[] args) {
		Thread t1 = new Thread("t1") {
			public void run() {
				Singleton0Thread s0 = Singleton0Thread.getInstance();
				System.out.println(s0.getX()+Thread.currentThread().getName());
			}
		};
		Thread t2 = new Thread("t2") {
			public void run() {
				Singleton0Thread s1 = Singleton0Thread.getInstance();
				System.out.println(s1.getX()+Thread.currentThread().getName());
			}
		};
		Thread t3 = new Thread("t3") {
			public void run() {
				Singleton0Thread s2 = Singleton0Thread.getInstance();
				System.out.println(s2.getX()+Thread.currentThread().getName());
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
}
