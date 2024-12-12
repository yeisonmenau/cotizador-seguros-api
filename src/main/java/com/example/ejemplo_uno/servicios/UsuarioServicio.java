package com.example.ejemplo_uno.servicios;

import com.example.ejemplo_uno.modelos.Usuario;
import com.example.ejemplo_uno.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;

    //Operaciones Crud a realizar en la base de datos

    //Operacion Create

    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception{
        try{
            return iUsuarioRepositorio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Operaciones Read

    //Buscar por ID
    public Usuario buscarUsuarioPorId(Integer idUsuario){
        Optional<Usuario> usuarioOptional = iUsuarioRepositorio.findById(idUsuario);
        if (usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }else{
            throw new RuntimeException("Usuario con ID " + idUsuario + " no se encuentra en la base de datos");
        }
    }

    //Buscar todos los Usuarios
    public List<Usuario> buscarUsuarios()throws Exception{
        try{
            return iUsuarioRepositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //Operación Update

    public Usuario actualizarUsuario(Integer idUsuario, Usuario datosUsuarioActualizo){
        Optional<Usuario> usuarioOptional = iUsuarioRepositorio.findById(idUsuario);

        if(usuarioOptional.isEmpty()){
            throw new RuntimeException("Usuario con ID " + idUsuario + " no se encuentra en la base de datos");
        }
        Usuario usuarioExistente = usuarioOptional.get();
        usuarioExistente.setNombre(datosUsuarioActualizo.getNombre());
        usuarioExistente.setCorreo(datosUsuarioActualizo.getCorreo());
        usuarioExistente.setPassword(datosUsuarioActualizo.getPassword());
        return iUsuarioRepositorio.save(usuarioExistente);
    }

    //Operacion Delete

    public void eliminarUsuario(Integer idUsuario){
        if (!iUsuarioRepositorio.existsById(idUsuario)) {
            throw new RuntimeException("Usuario con ID " + idUsuario + " no se encuentra en la base de datos");
        } else {
            iUsuarioRepositorio.deleteById(idUsuario);
        }

    }

}
