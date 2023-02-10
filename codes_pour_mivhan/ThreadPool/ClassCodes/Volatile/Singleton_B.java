package Volatile;

public class Singleton_B {
	private static final Singleton_B instance = new Singleton_B();
	private Singleton_B() {
		j++;
	}
	static int j=0;
	public String toString(){
		return "j = " + j;
	}
	public static Singleton_B getInstance() {
		return instance;
	}
}
