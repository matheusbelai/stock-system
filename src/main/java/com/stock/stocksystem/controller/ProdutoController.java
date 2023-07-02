package com.stock.stocksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.data.domain.Sort;
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
        mv.setViewName("redirect:/listarProduto");
        produtorepository.save(produto);
        return mv;
    }

    @GetMapping("listarProduto")
    public ModelAndView ListarProduto(Produto produto){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produto/listProduto");
        //mv.addObject("listarProduto", produtorepository.findAll());
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        mv.addObject("listarProduto", produtorepository.findAll(sort));
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView Alterar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produto/alterar");
        Produto produto = produtorepository.getReferenceById(id);
        mv.addObject("produto", produto);
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView Alterar(Produto produto){
        ModelAndView mv = new ModelAndView();
        produtorepository.save(produto);
        mv.setViewName("redirect:/listarProduto");
        return mv;

    }

    @GetMapping("/excluir/{id}")
    public String ExcluirAluno(@PathVariable("id")Long id){
        produtorepository.deleteById(id);
        return "redirect:/listarProduto";
    }

    @GetMapping("filtroProduto")
    public ModelAndView FiltroProduto(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produto/filtroProduto");
        return mv;
    } 

    @GetMapping("produtoEstoque")
    public ModelAndView ProdutoEstoque(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produto/estoqueProduto");
        mv.addObject("produtoEstoque", produtorepository.findByStatusEstoque());
        return mv;
    }

    @GetMapping("produtoEsgotado")
    public ModelAndView produtoEsgotado(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produto/esgotadoProduto");
        mv.addObject("produtoEsgotado", produtorepository.findByStatusEsgotado());
        return mv;
    }

}
