package com.cotizador.cotizador_seguros_api.repositorios;

import com.cotizador.cotizador_seguros_api.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer>{

}
