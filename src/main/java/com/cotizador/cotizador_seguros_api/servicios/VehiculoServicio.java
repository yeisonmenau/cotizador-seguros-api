package com.cotizador.cotizador_seguros_api.servicios;

import com.cotizador.cotizador_seguros_api.modelos.Usuario;
import com.cotizador.cotizador_seguros_api.modelos.Vehiculo;
import com.cotizador.cotizador_seguros_api.repositorios.IUsuarioRepositorio;
import com.cotizador.cotizador_seguros_api.repositorios.IVehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServicio {

    @Autowired
    IVehiculoRepositorio iVehiculoRepositorio;
    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;



    //1. Método para guardar usuario
    public Vehiculo guardarVehiculo(Vehiculo datosVehiculo)throws Exception{
        try{
            datosVehiculo.setUsuario(1);
            return iVehiculoRepositorio.save(datosVehiculo);
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
    //2. Buscar todos los usuarios
    public List<Vehiculo> buscarVehiculo()throws Exception{
        try{
            return iVehiculoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
