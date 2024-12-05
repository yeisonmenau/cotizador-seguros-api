package com.cotizador.cotizador_seguros_api.repositorios;

import com.cotizador.cotizador_seguros_api.modelos.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepositorio extends JpaRepository<Vehiculo, Integer> {
}
