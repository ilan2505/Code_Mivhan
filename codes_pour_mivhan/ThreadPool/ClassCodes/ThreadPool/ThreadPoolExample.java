package ThreadPool;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* This is a basic example of thread pool executor- FixedThreadPool.
Steps to be followed:
1. Create a task(Runnable Object) to execute
2. Create Executor Pool using Executors
3. Pass tasks to Executor Pool
4. Shutdown the Executor Pool
*/
// Java program to illustrateThreadPool
// Task class to be executed (Step 1)
class Task implements Runnable{
    private final String name;
    public Task(String name) {
        this.name = name;
    }
    // Prints task name and sleeps for 1 sec
    // This Whole process is repeated 3 times
    public void run() {
        try {
            Date date = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
            System.out.println("Initialization Time for"
                    + " task name - "+ name +" = " +ft.format(date));
            for (int i = 1; i<=3; i++) {
                   //prints the initialization time for every task
                    date = new Date();
                    ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - "+
                            name +" = " +ft.format(date));
                    // prints the execution time for every task
                    Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ThreadPoolExample {
        // Maximum number of threads in thread pool
        static final int MAX_T = 3;
        public static void main(String[] args) {
            // creates five tasks
            Runnable r1 = new Task("task 1");
            Runnable r2 = new Task("task 2");
            Runnable r3 = new Task("task 3");
            Runnable r4 = new Task("task 4");
            Runnable r5 = new Task("task 5");
            // creates a thread pool with MAX_T no. of
            // threads as the fixed pool size(Step 2)
            ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
           // passes the Task objects to the pool to execute (Step 3)
            pool.submit(r1);
            pool.submit(r2);
            pool.submit(r3);
            pool.submit(r4);
            pool.submit(r5);

            // pool shutdown ( Step 4)
            pool.shutdown();
            System.out.println("main exit");
         }
    }

