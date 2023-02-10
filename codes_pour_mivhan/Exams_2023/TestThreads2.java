package Exams_2023;

public class TestThreads2 implements Runnable {
    public void run() {
        System.out.print("One ");
    }

    public static void main(String[] args) {
        Thread th = new Thread(new TestThreads2());
        th.start();
        th.start();
        System.out.println(th.getState());
    }
}