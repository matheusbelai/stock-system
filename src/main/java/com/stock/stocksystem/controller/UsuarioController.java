package com.stock.stocksystem.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stock.stocksystem.model.Produto;
import com.stock.stocksystem.model.Usuario;
import com.stock.stocksystem.service.ServiceExc;
import com.stock.stocksystem.service.ServiceUsuario;
import com.stock.stocksystem.util.Util;

import jakarta.servlet.http.HttpSession;


@Controller
public class UsuarioController {
    


    @Autowired
    private ServiceUsuario serviceUsuario;

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

    @GetMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("produto", new Produto());
        return mv;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(Usuario usuario) throws Exception{
        ModelAndView mv = new ModelAndView();
        serviceUsuario.salvarUsuario(usuario);
        mv.setViewName("redirect:/");       
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView logar( @Validated Usuario usuario, BindingResult br,  HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        if(br.hasErrors()){
            mv.setViewName("Login/login");
        }

        Usuario userLogin = serviceUsuario.loginUser(usuario.getUsers(), Util.md5(usuario.getSenha()));
        if(userLogin == null){
            mv.addObject("msg", "Usuario não encontrado");
        }else{
            session.setAttribute("usuarioLogado", userLogin);
            return index();
        }
        return mv;
    }

}
