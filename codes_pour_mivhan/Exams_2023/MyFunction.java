package Exams_2023;
interface function{
    double f(double x);
}
class Zero implements function{
    public Zero() {;} // nothing to do.
    public double f(double x) {return 0;}
}
class Monom implements function{
    private final double _a;
    private final int _b;
    public Monom (double a, int b) {_a=a;_b=b;}
    public double f(double x) {
        return _a * Math.pow(x,_b);
    }
}
class RoundFunction implements function {
    public double f(double x) {
        return (int) (x + 0.5);
    }
}
class Sum implements function{
    private final function _f1;
    private final function _f2;
    public Sum (function f1, function f2) {
        _f1=f1;_f2=f2;
    }
    public double f(double x) {
        return _f1.f(x) + _f2.f(x);
    }
    public String toString() {return ""+_f1+"+"+_f2;}
}
class Comp implements function {
    private final function _f1;
    private final function _f2;

    public Comp(function f1, function f2) {
        _f1 = f1;
        _f2 = f2;
    }
    public double f(double x) {
        //double g = _f1.f(x);
        //return _f2.f(g);
        return _f2.f(x) * _f1.f(x);
    }
}

class Polynom implements function {
    public static final function _MINUS1 = new Monom(-1,0);
    private function _ans;
    public Polynom() {
        _ans = new Zero();
    }
    public String toString() {return _ans.toString(); }
    public double f(double x) {return _ans.f(x);}
    public void add(Monom m) { _ans = new Sum(_ans,m);}
    public void add(Polynom p) { _ans = new Sum(_ans,p);}
    public void sub(Polynom p) {
        function mp = new Comp(_MINUS1, p);
        	_ans = new Sum(_ans, mp); }
    public void mul(Monom m) { _ans = new Comp(m,_ans);}
}
public class MyFunction {
    public static void main(String[] args) {
        Monom m1 = new Monom(1.5, 2);
        Monom m2 = new Monom(-3.5, 4);
        Monom m3 = new Monom(3, 0);
        Polynom p = new Polynom();
        p.add(m1);
        p.add(m2);
        p.mul(m3);
        System.out.println(p);
        double d = 2;
        System.out.println("p(" + d + ") = " + p.f(d));
    } // console output: (0+1.5x^2+-3.5x^4) (3.0x^0), p(2.0) = -150.0
}

