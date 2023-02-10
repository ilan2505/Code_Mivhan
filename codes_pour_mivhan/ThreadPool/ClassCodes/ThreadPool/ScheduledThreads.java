//http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ThreadPoolExecutor.html
package ThreadPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Job1 implements Runnable {
	public void run() {
		System.out.println("Job 1");
	}
}

class Job2 implements Runnable {
	public void run() {
		System.out.print("job 2:  ");
		for(int i=0;i<4;i++){
			System.out.print(i+ ", ");
		}
		System.out.println();
	}
}
/**
scheduleAtFixedRate method: 
	Creates and executes a periodic action that becomes
    enabled first after the given initial delay, and subsequently with the given period; 
    that is executions will commence after initialDelay then initialDelay+period, 
    then initialDelay + 2 * period, and so on. 
    If any execution of the task encounters an exception, subsequent executions are suppressed. 
    Otherwise, the task will only terminate via cancellation or termination of the executor. 
    If any execution of this task takes longer than its period, 
    then subsequent executions may start late, but will not concurrently execute.

	Parameters:
		command - the task to execute
		initialDelay - the time to delay first execution
		period - the period between successive executions
		unit - the time unit of the initialDelay and period parameters 

ScheduledThreadPoolExecutor constructor Parameters: 
		corePoolSize - the number of threads to keep in the pool, 
		even if they are idle, unless allowCoreThreadTimeOut is set 

A ThreadPoolExecutor will automatically adjust the pool size (see getPoolSize()) according 
	to the bounds set by corePoolSize (see getCorePoolSize()) and maximumPoolSize (see getMaximumPoolSize()). 
	When a new task is submitted in method execute(java.lang.Runnable), and fewer than corePoolSize threads are running, 
	a new thread is created to handle the request, even if other worker threads are idle. 
	If there are more than corePoolSize but less than maximumPoolSize threads running, 
	a new thread will be created only if the queue is full. 
	By setting corePoolSize and maximumPoolSize the same, you create a fixed-size thread pool. 
	By setting maximumPoolSize to an essentially unbounded value such as Integer.MAX_VALUE, 
	you allow the pool to accommodate an arbitrary number of concurrent tasks.
	Most typically, core and maximum pool sizes are set only upon construction, 
	but they may also be changed dynamically using setCorePoolSize(int) and setMaximumPoolSize(int).
 */
public class ScheduledThreads {
	public static void test1(){
		ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(5);		    
		stpe.scheduleAtFixedRate(new Job1(), 0, 4, TimeUnit.SECONDS);
		System.out.println("stpe.getQueue().size: "+stpe.getQueue().size());
		System.out.println("stpe.getQueue().remainingCapacity: "+stpe.getQueue().remainingCapacity());
		stpe.scheduleAtFixedRate(new Job2(), 1, 2, TimeUnit.SECONDS);
		System.out.println("getCorePoolSize: "+stpe.getCorePoolSize());
		System.out.println("getMaximumPoolSize: "+stpe.getMaximumPoolSize());
		System.out.println("getPoolSize: "+stpe.getPoolSize());
		System.out.println("stpe.getQueue().remainingCapacity: "+stpe.getQueue().remainingCapacity());
		System.out.println("stpe.getQueue().size: "+stpe.getQueue().size());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			shutdown(stpe);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		test1();
	}
/**
awaitTermination method:
 		Blocks until all tasks have completed execution after a shutdown request, 
		or the timeout occurs, or the current thread is interrupted, whichever happens first.
	Parameters:
		timeout - the maximum time to wait
		unit - the time unit of the timeout argument 
	Returns:
		true if this executor terminated and false if the timeout elapsed before termination 
*/
	public static  void shutdown(ScheduledThreadPoolExecutor executor) throws InterruptedException {
		executor.shutdown();
		System.out.println(executor.awaitTermination(30, TimeUnit.SECONDS));
		executor.shutdownNow();
	}

}
