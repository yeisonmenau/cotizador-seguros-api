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
            vehiculo.setPlaca(request.getPlaca());
            vehiculo.setMarca(request.getMarca());
            vehiculo.setModelo(request.getModelo());

            // Guardar el vehículo en la base de datos
            Vehiculo vehiculoGuardado = iVehiculoRepositorio.save(vehiculo);

            // Crear la respuesta basada en el vehículo guardado
            ResponseVehiculo response = new ResponseVehiculo();
            response.setIdVehiculo(vehiculoGuardado.getIdVehiculo());
            response.setIdVehiculo(vehiculoGuardado.getUsuario().getIdUsuario());
            response.setPlaca(vehiculoGuardado.getPlaca());
            response.setMarca(vehiculoGuardado.getMarca());
            response.setModelo(vehiculoGuardado.getModelo());

            return response;
        } catch (RuntimeException e) {
            // Manejo de excepciones específicas
            throw e;
        } catch (Exception error) {
            // Manejo de excepciones generales
            throw new RuntimeException("Error al guardar el vehículo: " + error.getMessage(), error);
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
    public Vehiculo actualizarVehiculo (Integer idVehiculo, Vehiculo datosVehiculoActualizo)throws Exception{
        try{
            Optional<Vehiculo> vehiculoOptional = iVehiculoRepositorio.findById(idVehiculo);

            if(vehiculoOptional.isEmpty()){
                throw new RuntimeException("Vehiculo con ID " + idVehiculo + " no se encuentra en la base de datos");
            }
            Vehiculo vehiculoExistente = vehiculoOptional.get();
            vehiculoExistente.setMarca(datosVehiculoActualizo.getMarca());
            vehiculoExistente.setModelo(datosVehiculoActualizo.getModelo());
            vehiculoExistente.setPlaca(datosVehiculoActualizo.getPlaca());
            vehiculoExistente.setUsuario(datosVehiculoActualizo.getUsuario());
            return iVehiculoRepositorio.save(vehiculoExistente);
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
