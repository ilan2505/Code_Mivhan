package DesignPatterns.Strategy;
import java.util.Arrays;
public class TestStrategySorting {
	public static void main(String[] args) {
		Double[] list = {1.0,2.4,7.9,3.2,1.2,0.2,10.2,22.5,19.6,14.0,12.0,16.0,17.0};  
		SortContext<Double> contextDouble = new SortContext<>();

		System.out.println("QuickSort");
		contextDouble.setSorter(new QuickSorter<>());
		contextDouble.sort(list);
		System.out.println(Arrays.toString(list));

		String[] strings = {"a", "x","t","s","e", "q","p","i","o","j"};
		SortContext<String> contextStr = new SortContext<>();
		contextStr.setSorter(new QuickSorter<>());
		contextStr.sort(strings);
		System.out.println(Arrays.toString(strings));
		
		Point []points = {new Point(), new Point(5,7),
				new Point(2,3), new Point(0,1),
				new Point(-10, 10), new Point(0.5, 0.4)};
		SortContext<Point> contextPoint = new SortContext<>();
		contextPoint.setSorter(new QuickSorter<>());
		contextPoint.sort(points);
		System.out.println(Arrays.toString(points));
		
		/////////// bubble sort
		Double[] listB = {1.0,2.4,7.9,3.2,1.2,0.2,10.2,22.5,19.6,14.0,12.0,16.0,17.0};  
		SortContext<Double> contextDoubleB = new SortContext<>();

		System.out.println("BubbleSort");
		contextDoubleB.setSorter(new BubbleSorter<>());
		contextDoubleB.sort(listB);
		System.out.println(Arrays.toString(listB));

		String []stringsB = {"a", "x","t","s","e", "q","p","i","o","j"};
		SortContext<String> contextStrB = new SortContext<>();
		contextStrB.setSorter(new BubbleSorter<>());
		contextStrB.sort(stringsB);
		System.out.println(Arrays.toString(stringsB));
		
		Point []pointsB = {new Point(), new Point(5,7),
				new Point(2,3), new Point(0,1),
				new Point(-10, 10), new Point(0.5, 0.4)};
		SortContext<Point> contextPointB = new SortContext<>();
		contextPointB.setSorter(new BubbleSorter<>());
		contextPointB.sort(pointsB);
		System.out.println(Arrays.toString(pointsB));
	}
}
//QuickSort
//[0.2, 1.0, 1.2, 2.4, 3.2, 7.9, 10.2, 12.0, 14.0, 16.0, 17.0, 19.6, 22.5]
//[a, e, i, j, o, p, q, s, t, x]
//[Strategy_Elizabet.Point@5fd0d5ae, Strategy_Elizabet.Point@2d98a335, Strategy_Elizabet.Point@16b98e56, Strategy_Elizabet.Point@7ef20235, Strategy_Elizabet.Point@27d6c5e0, Strategy_Elizabet.Point@4f3f5b24]
//BubbleSort
//[0.2, 1.0, 1.2, 2.4, 3.2, 7.9, 10.2, 12.0, 14.0, 16.0, 17.0, 19.6, 22.5]
//[a, e, i, j, o, p, q, s, t, x]
//[Strategy_Elizabet.Point@7b23ec81, Strategy_Elizabet.Point@6acbcfc0, Strategy_Elizabet.Point@5f184fc6, Strategy_Elizabet.Point@3feba861, Strategy_Elizabet.Point@5b480cf9, Strategy_Elizabet.Point@6f496d9f]

//Process finished with exit code 0
