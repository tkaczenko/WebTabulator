package io.github.tkaczenko.lab2spring.view;

import org.springframework.stereotype.Component;


@Component
public class TabulatorForm {
    private double a;

    private double start;

    private double end;

    private double step;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}
