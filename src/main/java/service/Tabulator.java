package service;

import model.Function;
import model.Point;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by tkaczenko on 22.02.17.
 */
@ManagedBean(name = "tabulator")
@javax.faces.bean.ApplicationScoped
@ApplicationScoped
public class Tabulator implements Serializable {
    private Function function;

    private List<Point> results;
    private int size;
    private double start, end, h;

    public void tabulate() {
        calculateSteps();
        results = new ArrayList<>(size);
        double x = start, y;
        for (int i = 0; i < size; i++) {
            y = function.function(x);
            results.add(new Point(x, y));
            x += h;
        }
    }

    int calculateSteps() {
        return size = (int) ((end - start) / h + 1);
    }

    int searchMin() {
        if (results == null) {
            throw new IllegalArgumentException("Need to tabulate, before using");
        }
        return IntStream.range(0, results.size()).boxed()
                .reduce((i, j) -> results.get(i).getY() < results.get(j).getY() ? i : j)
                .orElse(0);
    }

    int searchMax() {
        if (results == null) {
            throw new IllegalArgumentException("Need to tabulate, before using");
        }
        return IntStream.range(0, results.size()).boxed()
                .reduce((i, j) -> results.get(i).getY() > results.get(j).getY() ? i : j)
                .orElse(0);
    }

    double sumOfElem() {
        return results.stream()
                .mapToDouble(Point::getY)
                .sum();
    }

    public double arithmeticMean() {
        return sumOfElem() / results.size();
    }

    public double getX(int index) {
        return results.get(index).getX();
    }

    public double getY(int index) {
        return results.get(index).getY();
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

    public List<Point> getResults() {
        return results;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
