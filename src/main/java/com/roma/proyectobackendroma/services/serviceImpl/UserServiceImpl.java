package com.roma.proyectobackendroma.services.serviceImpl;

import com.roma.proyectobackendroma.models.Usuario;
import com.roma.proyectobackendroma.repository.UserRepository;
import com.roma.proyectobackendroma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> update(Usuario usuario, Integer id) {
        return Optional.empty();
    }

    @Override
    public void remote(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return userRepository.findByCorreo(correo);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> login(String correo, String clave) {
        //buscamos el usuario mediante su correo
        Optional<Usuario> usuarioOptional = this.findByCorreo(correo);
        //verificamos si esta presente
        if(usuarioOptional.isPresent() && usuarioOptional.orElseThrow().getClave().equals(clave)){
            //retornamos ese usuario
            return  usuarioOptional;
        }
        //retornamos un optional vacio
        return Optional.empty();
    }
}
