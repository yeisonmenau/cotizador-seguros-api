package com.example.ejemplo_uno.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;

    @Column(length = 50)
    private String marca;

    private Integer modelo;

    @Column(length = 10)
    private String placa;

    @Column(length = 50)
    private String nombre;

    private Float valor;

    private Boolean activo = true;


    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "id_usuario", nullable = false, updatable = false)
    private Usuario usuario;

    public Vehiculo() {
    }

    public Vehiculo(Integer idVehiculo, String marca, Integer modelo, String placa, String nombre, Float valor, Boolean activo, Usuario usuario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.nombre = nombre;
        this.valor = valor;
        this.activo = activo;
        this.usuario = usuario;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
