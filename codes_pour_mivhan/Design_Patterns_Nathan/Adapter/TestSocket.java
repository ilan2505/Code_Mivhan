package DesignPatterns.Adapter;
/**
 One of the great real life example of Adapter design
 pattern is mobile charger. Mobile battery needs 3 volts
 to charge but the normal socket produces either 120V (US)
 or 240V (India). So the mobile charger works as an
 adapter between mobile charging socket and the wall socket
*/
class Volt {
    private int volts;
    public Volt(int v){
        this.volts=v;
    }
    public int getVolts() {
        return volts;
    }
    public void setVolts(int volts) {
        this.volts = volts;
    }
}
class Socket {
    public Volt getVolt(){
        return new Volt(120);
    }
}
interface SocketAdapter {
    public Volt get120Volt();
    public Volt get12Volt();
    public Volt get3Volt();
}

public class TestSocket{
}
