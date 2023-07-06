package com.stock.stocksystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stock.stocksystem.dao.UsuarioDAO;
import com.stock.stocksystem.model.Usuario;


@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioDAO usuarioRepositorio;

    @GetMapping("/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login/login");
        return mv;
    }

    @GetMapping("cadastro")
    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("Login/cadastro");
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(Usuario usuario){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/");
        usuarioRepositorio.save(usuario);
        return mv;
    }


}
