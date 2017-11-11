package view;

import model.LabFunction;
import service.Tabulator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Input implements Serializable {
    @ManagedProperty(value = "#{tabulator}")
    private Tabulator tabulator;

    private double a;
    private double start;
    private double end;
    private double step;

    public String tabulate() {
        LabFunction labFunction = new LabFunction();
        labFunction.setA(a);
        tabulator.setFunction(labFunction);
        tabulator.setStart(start);
        tabulator.setEnd(end);
        tabulator.setH(step);
        tabulator.tabulate();
        return "tabulate";
    }

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

    public void setTabulator(Tabulator tabulator) {
        this.tabulator = tabulator;
    }
}
