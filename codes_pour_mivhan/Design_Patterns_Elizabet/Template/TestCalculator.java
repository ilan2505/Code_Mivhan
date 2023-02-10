package DesignPatterns.Template;

import java.util.Random;
import java.util.Scanner;

abstract class AbstractCalculator {  
	public final double euclideanNorm() {  
		int[] vector = this.read();  
		int total = 0;  
		for(int element:vector) {  
			total = total + (element*element);    
		}
		return Math.sqrt(total);  
	}  
	public abstract int[] read();  
} 
class ConsoleCalculator extends AbstractCalculator {
	private final int size;
	public ConsoleCalculator(int size){
		this.size = size;
	}
	public int[] read() {
		int [] data = new int[size];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < data.length; i++) {
			System.out.print("get number: ");
			data[i] = scanner.nextInt();
		}
		scanner.close();
		return data; 
	}
}
class RandomCalculator extends AbstractCalculator {
	private final int size;
	public RandomCalculator(int size) {
		this.size = size;
	}
	public int[] read() {
		int [] data = new int[size];
		Random generator = new Random(12);
		for (int i = 0; i < data.length; i++) {
			data[i] = generator.nextInt(10);
		}
		return data;
	}
}

public class TestCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("get size: ");
		int n = scanner.nextInt();
		AbstractCalculator calculator = new ConsoleCalculator(n);
		double res = calculator.euclideanNorm();
		System.out.println("ConsoleCalculator res = "+res);
		
		calculator = new RandomCalculator(n);
		res = calculator.euclideanNorm();
		System.out.println("RandomCalculator res = "+res);
		scanner.close();

	}

}
