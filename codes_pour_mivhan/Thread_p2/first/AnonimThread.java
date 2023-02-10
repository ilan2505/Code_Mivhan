package first;

public class AnonimThread{
	public static void threadAnonim(){
		Thread t = new Thread(new Runnable() {
			  int i=0;
			  public void run() {
			    try {
			      while (i++<10) {
			        Thread.sleep(500); 
			        System.out.print((i)+" ");
			      }
			    }
			    catch(InterruptedException ex) {}
			  }
			},"thread_runnable");
		t.start();
		System.out.println("name: "+t.getName());
	}
	public static void main(String[] args) {
		threadAnonim();
	}
}
