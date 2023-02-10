package GenericComparable;

import java.util.ArrayList;
import java.util.Arrays;

public class MyVectorGeneric<T extends Comparable<T>> {
	private int size;
	private final int INIT_SIZE = 10;
	private T [] data;
	////////// iterator
	
	@SuppressWarnings("unchecked")
	public MyVectorGeneric(){
		size = 0;
		//data = (T [])(new Object[INIT_SIZE]); //Ljava.lang.Object; cannot be cast to [Ljava.lang.Comparable;
		data = (T [])(new Comparable[INIT_SIZE]);
		//data = new T[INIT_SIZE]; ERROR!
	}
	public void add(T value){
		if (size == data.length) resize();
		data[size++] = value;
	}
	@SuppressWarnings("unchecked")
	private void resize(){
		T [] temp = (T [])(new Comparable[data.length+INIT_SIZE]);
		for (int i = 0; i<data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	public int size(){return size;}
	
	public T elementAt(int i){
		return data[i];
	}
	public int capacity(){return data.length;}
	
	public String toString(){
		String s = "[";
		for (int i = 0; i<size; i++){
			s = s + data[i] + ", ";
		}
		s  = s + "]";
		return s;
	}
	public void sort(){
		T [] temp = (T [])(new Comparable[size]);
		temp = Arrays.copyOf(data, size);
		Arrays.sort(temp);
		data = Arrays.copyOf(temp, size);
	}
	/////////////// MyIterator
	public static void main(String[] args) {
		MyVectorGeneric<String> mvg = new MyVectorGeneric<String>();
		mvg.add("python");
		mvg.add("c");
		mvg.add("pascal");
		mvg.add("fortran");
		System.out.println(mvg.toString());
		mvg.sort();
		System.out.println(mvg.toString());
		//////////
		MyVectorGeneric<Integer> mvgInt = new MyVectorGeneric<Integer>();
		mvgInt.add(5);
		mvgInt.add(2);
		mvgInt.add(7);
		mvgInt.add(4);
		System.out.println(mvgInt.toString());
		mvgInt.sort();
		System.out.println(mvgInt.toString());
		/////////
		MyVectorGeneric<Character> mvgObj = new MyVectorGeneric<Character>();
		mvgObj.add('x');
		mvgObj.add('b');
		mvgObj.add('t');
		mvgObj.add('f');
		System.out.println(mvgObj.toString());
		mvgObj.sort();
		System.out.println(mvgObj.toString());
		//////////////////
		MyVectorGeneric<Point> vp = new MyVectorGeneric<>();
	//	vp.add(new Shape());//ERROR!!!
		vp.add(new Point(0,1));
		vp.add(new Point(0,10));
		vp.add(new Point(0,7));
		vp.add(new Point(0,3));
		System.out.println(vp);
		vp.sort();
		System.out.println(vp);
		/////
		ArrayList<Shape> ar = new ArrayList<>();
		ar.add(new Point(3,4,"red"));
		
		MyVectorGeneric vp2 = new MyVectorGeneric();
		vp2.add(new Point(0,7));
		vp2.add(7);
		vp2.add(3.25);
		System.out.println(vp2);
	}

}
