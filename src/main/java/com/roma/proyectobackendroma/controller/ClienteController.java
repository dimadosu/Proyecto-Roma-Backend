package com.roma.proyectobackendroma.controller;

import com.roma.proyectobackendroma.models.Cliente;
import com.roma.proyectobackendroma.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public List<Cliente> listar(){
        return clienteService.listAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
        Optional<Cliente> optionalCliente = clienteService.findById(id);
        if(optionalCliente.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalCliente.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        boolean resultado = clienteService.delete(id);
        if(resultado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}