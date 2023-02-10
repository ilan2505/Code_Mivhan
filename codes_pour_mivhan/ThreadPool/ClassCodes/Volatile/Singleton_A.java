package Volatile;

public class Singleton_A {
	private static Singleton_A instance=null;
	private static int i=0;
	public String toString(){
		return "i = "+i;
	}
	// private constructor
	private Singleton_A() {i++;}

	public static Singleton_A getInstance() {//static access method
		if (instance==null) {
			instance = new Singleton_A();
		} 
		return instance;
	}
}
