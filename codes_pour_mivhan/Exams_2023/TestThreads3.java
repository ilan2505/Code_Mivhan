package Exams_2023;

public class TestThreads3 implements Runnable {
    public void run() {
        System.out.print("One ");
    }
    public static void main(String[] args) {
        Thread th = new Thread(new TestThreads3());
        th.run();
        th.start();
    }
}
