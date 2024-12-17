package com.example.ejemplo_uno.servicios;

import com.example.ejemplo_uno.dto.RequestVehiculo;
import com.example.ejemplo_uno.dto.ResponseVehiculo;
import com.example.ejemplo_uno.modelos.Usuario;
import com.example.ejemplo_uno.modelos.Vehiculo;
import com.example.ejemplo_uno.repositorios.IUsuarioRepositorio;
import com.example.ejemplo_uno.repositorios.IVehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServicio {

    @Autowired
    IVehiculoRepositorio iVehiculoRepositorio;

    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;

    //Operaciones Crud a realizar en la base de datos

    //Operacion Create

    public ResponseVehiculo guardarVehiculo(RequestVehiculo request) throws Exception {
        try {
            // Validar y obtener el usuario asociado
            Usuario usuario = iUsuarioRepositorio.findById(request.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Crear y configurar el vehículo
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setUsuario(usuario);
            vehiculo.setMarca(request.getMarca());
            vehiculo.setModelo(request.getModelo());
            vehiculo.setPlaca(request.getPlaca());
            vehiculo.setNombre(request.getNombre());
            vehiculo.setValor(request.getValor());

            // Guardar el vehículo en la base de datos
            Vehiculo vehiculoGuardado = iVehiculoRepositorio.save(vehiculo);

            // Crear la respuesta basada en el vehículo guardado
            ResponseVehiculo response = new ResponseVehiculo();
            response.setIdVehiculo(vehiculoGuardado.getIdVehiculo());
            response.setIdVehiculo(vehiculoGuardado.getUsuario().getIdUsuario());
            response.setPlaca(vehiculoGuardado.getPlaca());
            response.setMarca(vehiculoGuardado.getMarca());
            response.setModelo(vehiculoGuardado.getModelo());
            response.setNombre(vehiculo.getNombre());
            response.setValor(vehiculo.getValor());

            return response;
        } catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }



    //Operaciones Read

    //Buscar por ID
    public Vehiculo buscarVehiculoPorId (Integer idVehiculo)throws Exception{
        try{
            Optional<Vehiculo> vehiculoOptional = iVehiculoRepositorio.findById(idVehiculo);
            if (vehiculoOptional.isPresent()){
                return vehiculoOptional.get();
            }else{
                throw new RuntimeException("Vehiculo con ID " + idVehiculo + " no se encuentra en la base de datos");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Buscar todos los Vehiculos
    public List<Vehiculo> buscarVehiculos()throws  Exception{
        try{
            return iVehiculoRepositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Operación Update
    public ResponseVehiculo actualizarVehiculo (Integer idVehiculo, RequestVehiculo datosVehiculoActualizo)throws Exception{
        try{
            Optional<Vehiculo> vehiculoOptional = iVehiculoRepositorio.findById(idVehiculo);
            if(vehiculoOptional.isEmpty()){
                throw new RuntimeException("Vehiculo con ID " + idVehiculo + " no se encuentra en la base de datos");
            }
            Vehiculo vehiculoExistente = vehiculoOptional.get();
            vehiculoExistente.setMarca(datosVehiculoActualizo.getMarca());
            vehiculoExistente.setModelo(datosVehiculoActualizo.getModelo());
            vehiculoExistente.setNombre(datosVehiculoActualizo.getNombre());
            vehiculoExistente.setValor(datosVehiculoActualizo.getValor());
            vehiculoExistente.setActivo(datosVehiculoActualizo.getActivo());

            Vehiculo vehiculoActualizado = iVehiculoRepositorio.save(vehiculoExistente);

            // Convertir a un objeto de respuesta y devolverlo
            ResponseVehiculo response = new ResponseVehiculo();
            response.setIdVehiculo(vehiculoActualizado.getIdVehiculo());
            response.setPlaca(vehiculoActualizado.getPlaca());
            response.setMarca(vehiculoActualizado.getMarca());
            response.setModelo(vehiculoActualizado.getModelo());
            response.setNombre(vehiculoActualizado.getNombre());
            response.setValor(vehiculoActualizado.getValor());
            response.setActivo(vehiculoActualizado.getActivo());

            return response;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Operacion Delete

    public void eliminarVehiculo(Integer idVehiculo)throws Exception{
        try{
            if (!iVehiculoRepositorio.existsById(idVehiculo)) {
                throw new RuntimeException("Vehiculo con ID " + idVehiculo + " no se encuentra en la base de datos");
            }else {

                iVehiculoRepositorio.deleteById(idVehiculo);
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
