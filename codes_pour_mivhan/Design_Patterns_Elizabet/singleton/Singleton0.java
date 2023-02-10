package singleton;
// The simple singleton
public final class Singleton0 {
	private static Singleton0 _instance = null;
	int i = 0;
	private Singleton0() {
		i++;
	}
	public String toString() {return " "+i;}

	public static Singleton0 getInstance() {
		if (_instance == null)
			_instance = new Singleton0();
		return _instance;
	}
	public static void main(String[] args) {
		
	}

}
