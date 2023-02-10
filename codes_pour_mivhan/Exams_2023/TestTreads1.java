package Exams_2023;

public class TestTreads1 implements Runnable {
    public void run() {
        System.out.print("One, ");
        System.out.print("Two, ");
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new TestTreads1());
        thread.start();
        System.out.print("Main_1, ");
        try {
            thread.join();
        }
        catch (InterruptedException e)   {e.printStackTrace();}
        System.out.println("Main_2, ");
    }
}
