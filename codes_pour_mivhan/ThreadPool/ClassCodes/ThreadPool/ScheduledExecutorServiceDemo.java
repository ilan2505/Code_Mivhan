package ThreadPool;

import java.util.concurrent.*;
/**
 * @author Elizabeth
 * schedule (Callable task, long delay, TimeUnit timeunit)
 * 		This method schedules the given Callable for execution after the given delay. 
 * 		The method returns a ScheduledFuture which you can use to either cancel the task before it has started executing, 
 * 		or obtain the result once it is executed. 
 
 *		schedule (Runnable task, long delay, TimeUnit timeunit)  - This method works like the method version 
 *		taking a Callable as parameter, except a Runnable cannot return a value, 
 *		so the ScheduledFuture.get() method returns null when the task is finished.
 */
public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

		ScheduledFuture<String> scheduledFuture = scheduledExecutorService.schedule(new Callable<String>() {
			public String call() throws Exception {
				System.out.println("Executed!");
				return "Called!";
			}
		}, 5,TimeUnit.SECONDS);
		String res=null;
		try {
			res = scheduledFuture.get();
			System.out.println("result = "+res);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		if (scheduledFuture.isDone()){
			System.out.println("Done!");
			scheduledExecutorService.shutdown();
		}
	}

}
