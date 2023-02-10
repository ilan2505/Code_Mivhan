package Atomic;

//http://www.journaldev.com/1095/java-atomic-operations-atomicinteger-example

public class JavaNotAtomic {
	/**
	 * @param args
	 * @throws InterruptedException
	 * Atomic operations are performed in a single unit of task without interference from other operations. 
	 * Atomic operations are necessity in multi-threaded environment to avoid data inconsistency. 
	 * Let�s create a simple multi-threaded program where every thread increments the shared count variable 4 times. 
	 * So if there are two threads, after they finish count value should be 8.
	 */
	public static void main(String[] args) throws InterruptedException {

		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	} 
}
class ProcessingThread implements Runnable {
	private int count;
	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			processSomething(i);
			count++;
		}
	}
	public int getCount() {
		return this.count;
	}
	private void processSomething(int i) {
		// processing some job
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/**
If you will run above program, you will notice that count value varies between 5,6,7,8.
The reason is because count++ is not an atomic operation. 
So by the time one threads read it�s value and increment it by one, 
other thread has read the older value leading to wrong result.
 */ 