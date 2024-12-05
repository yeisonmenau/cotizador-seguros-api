package com.cotizador.cotizador_seguros_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Integer idVehiculo;

    private Integer userId;

    private String placa;

    private String marca;

    private Integer modelo;

    public Response() {
    }

    public Response(Integer idVehiculo, Integer userId, String placa, String marca, Integer modelo) {
        this.idVehiculo = idVehiculo;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
