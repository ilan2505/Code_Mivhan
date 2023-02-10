package singleton;

public class TestSigleton0 {

	public static void main(String[] args) {
		// Singleton0 s1 = new Singleton0();
		Singleton0 s1 = Singleton0.getInstance();
		System.out.println(s1);
		Singleton0 s2 = Singleton0.getInstance();
		System.out.println(s2);
		Singleton0 s3 = Singleton0.getInstance();
		System.out.println(s3);
	}

}
