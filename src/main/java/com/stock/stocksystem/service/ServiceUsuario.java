package com.stock.stocksystem.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.stocksystem.dao.UsuarioDAO;
import com.stock.stocksystem.exceptions.CriptoExistException;
import com.stock.stocksystem.exceptions.UserExistsException;
import com.stock.stocksystem.model.Usuario;
import com.stock.stocksystem.util.Util;

@Service
public class ServiceUsuario {


    @Autowired
    private UsuarioDAO repositorioUsuario;
    
    public void salvarUsuario(Usuario usuario) throws Exception{
        try{
            if(repositorioUsuario.findByUsers(usuario.getUsers()) != null){
                throw new UserExistsException(usuario.getUsers() + " já cadastrado");
            }

            usuario.setSenha(Util.md5(usuario.getSenha()));
        
        }catch(NoSuchAlgorithmException e){
            throw new CriptoExistException("Erro na criptografia da senha");
        }
    
        repositorioUsuario.save(usuario);
    }

    public Usuario loginUser(String users, String senha) throws ServiceExc{
        Usuario userLogin = repositorioUsuario.buscarLogin(users, senha);
        return userLogin;
    }
}

