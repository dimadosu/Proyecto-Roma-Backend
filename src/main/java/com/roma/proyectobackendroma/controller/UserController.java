package com.roma.proyectobackendroma.controller;

import com.roma.proyectobackendroma.models.Usuario;
import com.roma.proyectobackendroma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //guardar usuario
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usuario));
    }

    //eliminar usuario
    @DeleteMapping("{id}")
    public void deleteUser(Integer id){
        userService.remote(id);
    }

    @PostMapping("/login/{correo}/con/{clave}")
    public ResponseEntity<?> loginUser(@PathVariable String correo, @PathVariable String clave){
        Optional<Usuario> usuarioOptional = userService.login(correo, clave);
        if(usuarioOptional.isPresent()){
            //retornamos el usuario y lo mandamos en el cuerpo de la respsueta http
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
