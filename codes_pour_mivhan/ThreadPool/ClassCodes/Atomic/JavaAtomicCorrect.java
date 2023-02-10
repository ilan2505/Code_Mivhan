package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * solve this issue, we will have to make sure that increment operation on count is atomic, 
 * we can do that using Synchronization but Java 5 java.util.concurrent.atomic 
 * provides wrapper classes for int and long that can be used to achieve this atomically 
 * without usage of Synchronization.
 * @author Elizabeth
 *
 */
public class JavaAtomicCorrect {

	public static void main(String[] args) throws InterruptedException {

		ProcessingThreadCorrect pt = new ProcessingThreadCorrect();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());
	}

}


class ProcessingThreadCorrect implements Runnable {
	private AtomicInteger count = new AtomicInteger();


	@Override
	public void run() {
		for (int i = 1; i <= 4; i++) {
			processSomething(i);
			count.incrementAndGet();
		}
	}


	public int getCount() {
		return this.count.get();
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
