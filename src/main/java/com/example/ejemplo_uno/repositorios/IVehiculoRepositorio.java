package com.example.ejemplo_uno.repositorios;

import com.example.ejemplo_uno.modelos.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepositorio extends JpaRepository<Vehiculo, Integer> {

}
