package com.stock.stocksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stocksystem.model.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Long>{
    
}
