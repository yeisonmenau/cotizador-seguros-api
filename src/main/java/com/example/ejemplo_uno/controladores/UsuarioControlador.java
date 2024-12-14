package com.example.ejemplo_uno.controladores;

import com.example.ejemplo_uno.modelos.Usuario;
import com.example.ejemplo_uno.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    // Operación Create
    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario datosUsuario)throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.guardarUsuario(datosUsuario));
        } catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // Operación Read: Buscar por ID
    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer idUsuario) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.buscarUsuarioPorId(idUsuario));
        }catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    // Operación Read: Buscar todos
    @GetMapping
    public ResponseEntity<List<Usuario>> buscarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioServicio.buscarUsuarios();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    // Operación Update
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario datosUsuario) {
        try {
            Usuario usuarioActualizado = usuarioServicio.actualizarUsuario(id, datosUsuario);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Operación Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        try {
            usuarioServicio.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
}
