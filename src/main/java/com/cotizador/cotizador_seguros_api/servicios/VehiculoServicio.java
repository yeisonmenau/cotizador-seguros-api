package com.cotizador.cotizador_seguros_api.servicios;

import com.cotizador.cotizador_seguros_api.dto.Request;
import com.cotizador.cotizador_seguros_api.dto.Response;
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
    public Response guardarVehiculo(Request request)throws Exception{
        try{

            Integer userId = request.getUserId();
            Usuario usuario = iUsuarioRepositorio.findById(userId).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setUsuario(usuario);
            vehiculo.setPlaca(request.getPlaca());
            vehiculo.setMarca(request.getMarca());
            vehiculo.setModelo(request.getModelo());


            this.iVehiculoRepositorio.save(vehiculo);
            Response response = new Response();
            response.setIdVehiculo(vehiculo.getIdVehiculo());
            response.setUserId(vehiculo.getUsuario().getIdUsuario());
            response.setPlaca(vehiculo.getPlaca());
            response.setMarca(vehiculo.getMarca());
            response.setModelo(vehiculo.getModelo());

            return response;
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
