package first;

class MyThread extends Thread{
	int loop;
	public MyThread(String name, int loop){
		super(name);
		this.loop = loop;
	}
	public void run() {
		for (long i=1; i<=loop; i++) {
			System.out.println("i = "+i+"  "+this.getName());
			try {
				sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName()+ "  DONE!");
	} 
}

public class SimpleThread1 {

	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1", 5);
		MyThread t2 = new MyThread("T2", 10);
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.interrupt();
		System.out.println("main exit");
		SimpleThread1 t = new SimpleThread1();
	}
}
