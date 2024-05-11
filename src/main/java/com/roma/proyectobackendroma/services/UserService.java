package com.roma.proyectobackendroma.services;

import com.roma.proyectobackendroma.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //listartodo
    List<Usuario> findAll();

    //crud devuelve un optional
    Optional<Usuario> findById(Integer id);

    Usuario save(Usuario usuario);

    Optional<Usuario> update (Usuario usuario, Integer id);

    void remote(Integer id);

    Optional<Usuario> findByCorreo(String correo);

    Optional<Usuario> login (String correo, String clave);
}
