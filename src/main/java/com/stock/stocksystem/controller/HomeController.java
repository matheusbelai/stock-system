package com.stock.stocksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stock.stocksystem.model.Produto;

@Controller
public class HomeController {
    

    //
    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("produto", new Produto());
        return mv;
    }
}
