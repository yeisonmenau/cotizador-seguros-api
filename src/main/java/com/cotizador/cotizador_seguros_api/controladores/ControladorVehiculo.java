package com.cotizador.cotizador_seguros_api.controladores;

import com.cotizador.cotizador_seguros_api.dto.Request;
import com.cotizador.cotizador_seguros_api.dto.Response;
import com.cotizador.cotizador_seguros_api.modelos.Usuario;
import com.cotizador.cotizador_seguros_api.modelos.Vehiculo;
import com.cotizador.cotizador_seguros_api.servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehiculos")
public class ControladorVehiculo {

    @Autowired
    VehiculoServicio vehiculoServicio;

    //llamamos al que guarda el vehiculo
    @PostMapping
    public ResponseEntity<Response> guardar(@RequestBody Request datos)throws Exception{
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehiculoServicio.guardarVehiculo(datos));
    }
    //llamamos al metodo que busca
    public ResponseEntity<?>buscar()throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.buscarVehiculo());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
