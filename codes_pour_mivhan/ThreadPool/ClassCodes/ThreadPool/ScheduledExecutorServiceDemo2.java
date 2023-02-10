package ThreadPool;
// http://tutorials.jenkov.com/java-util-concurrent/scheduledexecutorservice.html#scheduledexecutorservice-shutdown
import java.util.concurrent.*;
/**
	•scheduleAtFixedRate (Runnable, long initialDelay, long period, TimeUnit timeunit)
		This method schedules a task to be executed periodically. 
		The task is executed the first time after the initialDelay, and then recurringly every time the period expires. 
		If any execution of the given task throws an exception, the task is no longer executed. 
		If no exceptions are thrown, the task will continue to be executed until the ScheduledExecutorService is shut down. 
		If a task takes longer to execute than the period between its scheduled executions, 
		the next execution will start after the current execution finishes. 
		The scheduled task will not be executed by more than one thread at a time.

	•scheduleWithFixedDelay (Runnable, long initialDelay, long period, TimeUnit timeunit)
		This method works very much like scheduleAtFixedRate() except that the period is interpreted differently. 
		In the scheduleAtFixedRate() method the period is interpreted as a delay between the start of the previous execution, 
		until the start of the next execution. 
		In this method, however, the period is interpreted as the delay between the end of the previous execution, 
		until the start of the next. The delay is thus between finished executions, not between the beginning of executions. 
 */
class Job implements Runnable {
	public void run() {
		System.out.print("job:  ");
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(i+ ", ");
		}
		System.out.println();
	}
}
public class ScheduledExecutorServiceDemo2 {
	
	public static void testScheduleWithFixedDelay(){//The delay is between the start of the previous execution
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
		scheduledExecutorService.scheduleAtFixedRate(new Job(), 0, 2, TimeUnit.SECONDS);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(scheduledExecutorService.isTerminated());
		scheduledExecutorService.shutdown();
		System.out.println(scheduledExecutorService.isTerminated());
	}
	public static void testScheduleAtFixedRate(){//The delay is between the end of the previous execution
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
		scheduledExecutorService.scheduleAtFixedRate(new Job(), 0, 2, TimeUnit.SECONDS);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scheduledExecutorService.shutdown();
	}

	public static void main(String[] args) {
		testScheduleWithFixedDelay();
		//testScheduleAtFixedRate();
	}

}
