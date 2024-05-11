package com.roma.proyectobackendroma.repository;

import com.roma.proyectobackendroma.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {

    //consulta jpa con los atributos de la clase
    Optional<Usuario> findByCorreo(String correo);
}
