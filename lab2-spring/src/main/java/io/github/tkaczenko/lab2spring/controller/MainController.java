package io.github.tkaczenko.lab2spring.controller;

import io.github.tkaczenko.lab2spring.module.LabFunction;
import io.github.tkaczenko.lab2spring.service.Tabulator;
import io.github.tkaczenko.lab2spring.view.TabulatorForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MainController {
    private final Tabulator tabulator;

    @Autowired
    public MainController(Tabulator tabulator) {
        this.tabulator = tabulator;
    }

    @GetMapping("/")
    public String tabulate(Model model) {
        model.addAttribute("function", LabFunction.ExpressionType.values());
        if (!model.containsAttribute("tabulatorForm")) {
            model.addAttribute("tabulatorForm", new TabulatorForm());
        } else if (tabulator.getFunction() != null) {
            tabulator.tabulate();
            model.addAttribute("a", tabulator.getFunction().getA())
                    .addAttribute("start", tabulator.getStart())
                    .addAttribute("end", tabulator.getEnd())
                    .addAttribute("step", tabulator.getH())
                    .addAttribute("tabulator", tabulator);
        }
        return "index";
    }

    @PostMapping("/")
    public String tabulate(@ModelAttribute("tabulatorForm") @Valid TabulatorForm tabulatorForm, Model model,
                           BindingResult binding, RedirectAttributes attributes) {
        attributes.addFlashAttribute("tabulatorForm", tabulatorForm);
        if (binding.hasErrors()) {
            attributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.customerForm", binding
            );
            return "redirect:/";
        }
        LabFunction labFunction = new LabFunction();
        labFunction.setA(tabulatorForm.getA());
        tabulator.setFunction(labFunction);
        tabulator.setStart(tabulatorForm.getStart());
        tabulator.setEnd(tabulatorForm.getEnd());
        tabulator.setH(tabulatorForm.getStep());
        return "redirect:/";
    }
}
