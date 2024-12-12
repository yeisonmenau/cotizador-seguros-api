package com.example.ejemplo_uno.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(length = 15, nullable = false, unique = true)
    private String cedula;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String correo;

    @Column(length = 20, nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Vehiculo> vehiculos;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String cedula, String nombre, String correo, String password) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
