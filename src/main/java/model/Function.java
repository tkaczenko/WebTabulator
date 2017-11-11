package model;

/**
 * Created by tkaczenko on 23.02.17.
 */
public abstract class Function {
    double a;

    public abstract double function(double x);

    public void setA(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }
}
