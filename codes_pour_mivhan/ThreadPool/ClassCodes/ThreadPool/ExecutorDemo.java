package ThreadPool;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//import java.util.concurrent.*;
/**
 * The Callable interface is similar to Runnable, in that both are designed
 * for classes whose instances are potentially executed by another thread. 
 * A Runnable, however, does not return a result and cannot throw a checked exception. 
 */
class MyThread implements Callable<String>{
	int id;
	MyThread(int i){
		id = i;
	}
	@Override
	public String call() throws Exception {
		boolean negative = true;
		double pi=0.0; // Initializes to 0.0, by default
		long t1 = new Date().getTime();// get current UTC time in milliseconds
		System.out.println("Thread id = "+id+" started!");
		for (long i = 3; i < 1000000000L; i=i+2){
			if (negative)
				pi = pi - (1.0 / i);
			else
				pi = pi + (1.0 / i);
			negative = !negative;
		}
		pi = pi + 1.0;
		pi = pi*4.0;
		System.out.println ("Finished calculating PI");
		System.out.println("Thread id = "+id+" finished!");
		long t2 = new Date().getTime();// get current UTC time in milliseconds
		return "Thread id = "+ id + ",  running time was " + (t2 - t1) + ", pi = " + pi;
	}

}
public class ExecutorDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int num = 3;
		ExecutorService pool = Executors.newFixedThreadPool(num);
		Future<String> results[] = new Future[num];
		long start = System.currentTimeMillis();
		for (int i=1; i<=num; i++){
			results[i-1] = pool.submit(new MyThread(i));
			//			 System.out.println("Thread "+i+" returned value: "+results[i-1].get());
		}

		for (int i=1; i<=num; i++){ try{ String ans = results[i-1].get();
		System.out.println("Thread "+i+" returned value: "+ans);
		}catch(ExecutionException|InterruptedException e){ e.printStackTrace(); } }
		long end = System.currentTimeMillis();
		System.out.println("time = "+(end-start)+" ms");
		pool.shutdown();
	}

}
