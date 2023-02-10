package DesignPatterns.Template;

import java.util.Arrays;

abstract class AbstractSort {

	abstract boolean needSwap(int a, int b);

	public final void sort(int[] arr){//bubble sort
		boolean flag = true;
		for (int i=0; flag && i <arr.length; i++){
			flag = false;
			for (int j=0; j < arr.length-1-i; j++){
				if(needSwap(arr[j], arr[j+1])){
					flag = true;
					swap(arr, j, j+1);
				}
			}
		}		
	}

	public void swap(int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
class SortUp extends AbstractSort{
	boolean needSwap(int a, int b){
		return a > b;
	}
}
class SortDown extends AbstractSort{
	boolean needSwap(int a, int b){
		return a < b;
	}
}

public class TemplateDemoSort{
	public static void main(String[] args){
		int []array1 = {1,2,7,3,1,0,10,22,19,14,12,16,17};  
		int []array2 = {1,2,7,3,1,0,10,22,19,14,12,16,17};  

		System.out.println("SortDown:");
		AbstractSort sd = new SortDown();
		sd.sort(array1);
		System.out.println(Arrays.toString(array1));
		
		System.out.println("SortUp:");
		AbstractSort su = new SortUp();
		su.sort(array2);
		System.out.println(Arrays.toString(array2));
	}
}