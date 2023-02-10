package Volatile;

public class TestSingletonAB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/// Check Singleton_A
		Singleton_A a1 = Singleton_A.getInstance();
		System.out.println(a1);
		Singleton_A a2 = a1;
		System.out.println(a2);
/*		try {
			Singleton_A a = Singleton_A.class.newInstance();
			System.out.println(a);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println("A: creation error");
			e.printStackTrace();
		}
*/	/// Check Singleton_B
		Singleton_B b = Singleton_B.getInstance();
		System.out.println(b);
		Singleton_B b2 = Singleton_B.getInstance();
		System.out.println(b2);
/*		try {
			Singleton_B b3 = Singleton_B.class.newInstance();
			System.out.println(b3);
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println("B: creation error");
			e.printStackTrace();
		}
*/	}

}
