package io.github.tkaczenko.lab2spring.module;

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