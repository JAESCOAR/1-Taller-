package com.software2ex.apiRest.model;

public class Car {
    private Long id;
    private String marca;
    private String modelo;

    public Car (Long id, String marca, String modelo){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Car () {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    
}
