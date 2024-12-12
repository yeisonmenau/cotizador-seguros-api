package com.example.ejemplo_uno.dto;

public class ResponseVehiculo {
    private Integer idVehiculo;
    private String placa;
    private String marca;
    private Integer modelo;

    public ResponseVehiculo() {
    }

    public ResponseVehiculo(Integer idVehiculo, String placa, String marca, Integer modelo) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }
}
