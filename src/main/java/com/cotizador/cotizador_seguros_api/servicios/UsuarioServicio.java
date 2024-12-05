package com.cotizador.cotizador_seguros_api.servicios;

import com.cotizador.cotizador_seguros_api.modelos.Usuario;
import com.cotizador.cotizador_seguros_api.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    //Llamando al repositorio de usuario
    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;
    //Se crean métodos para definir las operaciones a realizar en la BD

    //1.Registrar un usuario
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception{
        try {
            return iUsuarioRepositorio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //2. Buscar todos los usuarios
    public List<Usuario> buscarUsuario()throws Exception{
        try{
            return iUsuarioRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
