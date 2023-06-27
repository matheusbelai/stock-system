package com.stock.stocksystem.Enums;

public enum Categoria {
    
    INFORMATICA("Informática"),
    CELULARES("Celular"),
    LIMPEZA("Limpeza");

    private String categoria;

    private Categoria(String cateogria){
        this.categoria = cateogria;
    }

}
