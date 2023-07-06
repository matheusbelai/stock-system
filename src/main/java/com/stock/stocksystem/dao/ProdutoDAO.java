package com.stock.stocksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.stock.stocksystem.model.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Long>{

    List<Produto> findAll(Sort sort);


    @Query("select m from Produto m where m.status = 'ESTOQUE' ")
    public List<Produto> findByStatusEstoque();

    @Query("select m from Produto m where m.status = 'ESGOTADO' ")
    public List<Produto> findByStatusEsgotado();

    
}

