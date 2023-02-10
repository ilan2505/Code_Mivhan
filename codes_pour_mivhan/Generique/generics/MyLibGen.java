package generics;

import java.util.Arrays;


public class MyLibGen {
	public static <T> boolean eq(T a, T b){
		return a.equals(b);
	}
	public static <T> void print(T arr[]){
		for (T val : arr) System.out.print(val + " ");
		System.out.println();
	}
	public static <T extends Comparable<T>> T max(T a, T b){
		return a.compareTo(b) > 0 ? a : b;

	}
	public static <T extends Comparable<T>> T min(T a, T b){
		return a.compareTo(b) < 0 ? a : b;

	}
	public static <T extends Comparable<T>> int maxElement(T[] arr){
		int ind = 0;
		for (int i=1; i<arr.length; i++){
			if (arr[ind].compareTo(arr[i]) < 0) ind = i;
		}
		return ind;
	}
	public static <T  extends Comparable<T>> void insertionSort(T[] arr){
		for (int i=1; i <arr.length; i++){
			int j = i;
			while (j>0 && arr[j].compareTo(arr[j-1]) < 0){
				T temp = arr[j]; 
				arr[j] = arr[j-1]; 
				arr[j-1] = temp;
				j = j-1;
			}			
		}		
	}

	public static void main(String[] args) {
		String a=new String("x"), b = new String("x");
		String m = max(a, b);
		System.out.println("max(x,b) = "+m);
		Integer i=9, j=99, k;
		k = max(i, j);
		System.out.println("max(9,99) = "+k);
	///////
		m = min(a, b);
		System.out.println("min(x,b) = "+m);
		k = min(i, j);
		System.out.println("min(9,99) = "+k);
	///////
		System.out.println("x == b? "+eq(a, b));
		System.out.println("x == x? "+eq(a, a));
	///////
		Integer []arr = {7,54,8,3,4,0,2};
		System.out.println(maxElement(arr));
		MyLibGen.print(arr);
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(maxElement(arr));
	}
}
