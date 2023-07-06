package com.stock.stocksystem.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stock.stocksystem.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
    

    @Query("select m from Usuario m where m.users = :users")
    public Usuario findByUsers(String users);

    @Query("select b from Usuario b where b.users = :users and b.senha = :senha")
    public  Usuario buscarLogin(String users, String senha);

}
