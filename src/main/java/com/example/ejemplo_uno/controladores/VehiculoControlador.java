package com.example.ejemplo_uno.controladores;

import com.example.ejemplo_uno.dto.RequestVehiculo;
import com.example.ejemplo_uno.modelos.Vehiculo;
import com.example.ejemplo_uno.servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoControlador {

    @Autowired
    private VehiculoServicio vehiculoServicio;

    // Operación Create
    @PostMapping
    public ResponseEntity<?> guardarVehiculo(@RequestBody RequestVehiculo datosVehiculo) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.guardarVehiculo(datosVehiculo));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Operación Read: Buscar vehículo por ID
    @GetMapping("/{idVehiculo}")
    public ResponseEntity<?> buscarVehiculoPorId(@PathVariable("idVehiculo") Integer idVehiculo) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.buscarVehiculoPorId(idVehiculo));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Operación Read: Buscar todos los vehículos
    @GetMapping
    public ResponseEntity<?> listarVehiculos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.buscarVehiculos());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Operación Update
    @PutMapping("/{idVehiculo}")
    public ResponseEntity<?> actualizarVehiculo(@PathVariable("idVehiculo") Integer idVehiculo, @RequestBody Vehiculo datosVehiculoActualizo) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.actualizarVehiculo(idVehiculo,datosVehiculoActualizo));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(error.getMessage());
        }
    }

    // Operación Delete
    @DeleteMapping("/{idVehiculo}")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable("idVehiculo") Integer idVehiculo) {
        try {
            vehiculoServicio.eliminarVehiculo(idVehiculo);
            return ResponseEntity.ok("Vehículo con ID " + idVehiculo + " eliminado exitosamente");
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(error.getMessage());
        }
    }
}