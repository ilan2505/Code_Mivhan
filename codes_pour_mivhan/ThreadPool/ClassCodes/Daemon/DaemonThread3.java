package Daemon;
class MyDaemonThread extends Thread{
	
	public MyDaemonThread(String name){
		super(name);
	}
	public void run(){
		boolean b = true;
		while (b){
			System.out.println(currentThread().getName());
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(currentThread().getName() + " terminated");
	}
}
class RegularThread extends Thread{
	
	public RegularThread(String name){
		super(name);
	}
	public void run(){
		int i=0;
		while (i++<3){
			System.out.println("i = "+i + ", "+currentThread().getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(currentThread().getName() + "  terminated");
	}
}

public class DaemonThread3 {
	public static void main(String[] args) {
		MyDaemonThread daemon = new MyDaemonThread("MyDaemonThread");
		daemon.setDaemon(true);
		daemon.start();
		RegularThread r1 = new RegularThread("R1");
		RegularThread r2 = new RegularThread("R2");
		RegularThread r3 = new RegularThread("R3");
		r1.start();
		r2.start();
		r3.start();
		System.out.println("daemon.isAlive()? " + daemon.isAlive());
		try {
			r1.join();
			r2.join();
			r3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("daemon.isAlive()? " + daemon.isAlive());
		System.out.println("main  terminated");
	}

}
