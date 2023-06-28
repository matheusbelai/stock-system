package com.stock.stocksystem.Enums;

public enum Status {
    
    ESTOQUE("Estoque"),
    ESGOTADO("Esgotado");

    private String status;

    private Status(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    
}
