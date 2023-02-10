package DesignPatterns.Strategy;

//This is an interface to describe the individual algorithms.
interface SorterInterface<T> {
	public void sort(T[] list);
}

//Context: The context maintains a reference to a Strategy 
//object and forwards client requests to the strategy. 
//Context may also define an interface to let Strategies 
//access context data.
class SortContext<T> {
	private SorterInterface<T> sorter = null;
	
	public void setSorter(SorterInterface<T> sorter) {
		this.sorter = sorter;
	}
	public SorterInterface<T> getSorter() {
		return sorter;
	}
	public void sort(T[] list) {
		sorter.sort(list);
	}

}

//ConcreteStrategy: Implements Strategy Interface and 
//contains the logic for the algorithm.
class BubbleSorter<T extends Comparable<T>> implements SorterInterface<T> {
	public void sort(T[] a) {
		bubbleSorter(a);
	}
	private void bubbleSorter(T[] list) {
		boolean flag = true;
		for (int i=0; flag && i <list.length; i++){
			flag = false;
			for (int j=0; j < list.length-1-i; j++){
				if( list[j].compareTo(list[j+1]) > 0){ //list[j] > list[j+1]){
					flag = true;
					T temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}		
	}
}//end class BubbleSort


// ConcreteStrategy: Implements Strategy Interface and 
// contains the logic for the algorithm.
class QuickSorter<T extends Comparable<T>> implements SorterInterface<T> {
	public void sort(T[] a) {
		quicksort(a, 0, a.length - 1);
	}
	private void quicksort(T[] a, int left, int right) {
		if (right <= left) return;
		int i = partition(a, left, right);
		quicksort(a, left, i-1);
		quicksort(a, i+1, right);
	}

	private int partition(T[] a, int left, int right) {
		int i = left;
		int j = right;
		while (true) {
			while (a[i].compareTo(a[right]) < 0)
				i++;
			while (a[right].compareTo(a[--j]) < 0)
				if (j == left) break;
			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, i, right);
		return i;
	}

	private void swap(T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}//end class QuickSort
