package com.stock.stocksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stocksystem.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    
    


}
