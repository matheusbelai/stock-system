package com.stock.stocksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stock.stocksystem.dao.ProdutoDAO;
import com.stock.stocksystem.model.Produto;

@Controller
public class ProdutoController {
    
    @Autowired
    private ProdutoDAO produtorepository;

    @GetMapping("/insertProduto")
    public ModelAndView InsertProduto(Produto produto){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produto/formProduto");
        mv.addObject("produto", new Produto());
        return mv;
    }

    @PostMapping("CadastrarProduto")
    public ModelAndView CadastrarProduto(Produto produto){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/produto/listProduto");
        produtorepository.save(produto);
        return mv;
    }

    @GetMapping("listarProduto")
    public ModelAndView ListarProduto(Produto produto){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produto/listProduto");
     //   mv.addObject("listarProduto", produtorepository.findAll());
        return mv;
    }
}
