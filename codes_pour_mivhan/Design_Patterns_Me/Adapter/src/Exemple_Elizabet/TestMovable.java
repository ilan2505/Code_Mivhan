package Exemple_Elizabet;
/** First, we'll create the original interface Movable
 * which is supposed to return
 * the speed of some luxury cars in miles per hour:*/
interface Movable {
    // returns speed in MPH
    double getSpeed();
}

/** We'll now create one concrete
 implementation of this interface: */
class BugattiVeyron implements Movable {
    double speed;
    public BugattiVeyron(double speed){
        this.speed = speed;
    }
    @Override
    public double getSpeed() {
        return speed;
    }
}

/** Now we'll create an adapter interface MovableAdapter
 * that will be based on the same Movable class.
 * It may be slightly modified to yield different results
 * in different scenarios: */
interface MovableAdapter {
    // returns speed in KM/H
    double getSpeed();
}

/** The implementation of this interface will consist
 * of private method convertMPHtoKMPH() that will be used
 * for the conversion: */
class MovableAdapterImpl implements MovableAdapter {
    private final Movable luxuryCars;
    // standard constructor
    public MovableAdapterImpl(Movable luxCar){
        luxuryCars = luxCar;
    }
    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }
    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}

public class TestMovable {
    public static void main(String[] args) {
        Movable bugattiVeyron = new BugattiVeyron(268);
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
        double speed = bugattiVeyronAdapter.getSpeed();
        System.out.println("The speed of the Veyron is : "+ speed);    //The speed of the Veyron is : 431.30312
    }
}
