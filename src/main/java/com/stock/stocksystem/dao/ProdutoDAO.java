package com.stock.stocksystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.domain.Sort;
import com.stock.stocksystem.model.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Long>{
    List<Produto> findAll(Sort sort);
}
