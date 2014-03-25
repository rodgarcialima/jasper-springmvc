package br.com.mobhub.jasper.controller;

import br.com.mobhub.jasper.service.CalcService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class IndexController {

    @Inject private CalcService calcService;

    @RequestMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("soma", calcService.soma(10, 20));
        return "index";
    }

}
