package controller;

import model.LabFunction;
import service.Tabulator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tkaczenko on 22.02.17.
 */
//@WebServlet("/")
public class MainController extends HttpServlet {
    private final Tabulator tabulator;

    @Inject
    public MainController(Tabulator tabulator) {
        this.tabulator = tabulator;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("function", LabFunction.ExpressionType.values());
        if (tabulator.getFunction() != null) {
            tabulator.tabulate();
            req.setAttribute("a", tabulator.getFunction().getA());
            req.setAttribute("start", tabulator.getStart());
            req.setAttribute("end", tabulator.getEnd());
            req.setAttribute("step", tabulator.getH());
            req.setAttribute("tabulator", tabulator);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        String step = req.getParameter("step");
        LabFunction labFunction = new LabFunction();
        labFunction.setA(Double.parseDouble(a));
        tabulator.setFunction(labFunction);
        tabulator.setStart(Double.parseDouble(start));
        tabulator.setEnd(Double.parseDouble(end));
        tabulator.setH(Double.parseDouble(step));
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
