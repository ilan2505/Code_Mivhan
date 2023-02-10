package interfaceExtendsInterface;

interface IVehicle{
	void moveForward(int x );
	boolean moveBack( int x );
	default void turnAlarmOn() {
		System.out.println("Turning the vehicle alarm on.");
	}
	default void turnAlarmOff() {
		System.out.println("Turning the vehicle alarm off.");
	}
}

interface IAirplane extends IVehicle{
	void moveDown(int x);
	void moveUp(int x);
}

class Airplane implements IAirplane{

	@Override
	public void moveForward(int x) {
		System.out.println("Forward " + x + "km");
	}

	@Override
	public boolean moveBack(int x) {
		System.out.println("Back " + x + "km");
		return false;
	}

	@Override
	public void moveDown(int x) {
		System.out.println("Down " + x + "km");
	}

	@Override
	public void moveUp(int x) {
		System.out.println("Up " + x + "km");
	}
	
}
public class TestVehicle {

	public static void main(String[] args) {
		Airplane a = new Airplane();
		a.moveUp(5000);
		a.moveForward(10000);
		a.moveDown(5000);
		a.turnAlarmOn();
		a.turnAlarmOff();
	}
}
