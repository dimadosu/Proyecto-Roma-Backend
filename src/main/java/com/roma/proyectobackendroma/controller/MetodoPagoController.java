package com.roma.proyectobackendroma.controller;

import com.roma.proyectobackendroma.models.Cliente;
import com.roma.proyectobackendroma.models.MetodoPago;
import com.roma.proyectobackendroma.services.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping("/listar")
    public List<MetodoPago> listar(){
        return metodoPagoService.listAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarMetodo(@RequestBody MetodoPago metodoPago){
        return ResponseEntity.status(HttpStatus.CREATED).body(metodoPagoService.save(metodoPago));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
        Optional<MetodoPago> optionalMetodoPago = metodoPagoService.findById(id);
        if(optionalMetodoPago.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalMetodoPago.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        boolean resultado = metodoPagoService.delete(id);
        if(resultado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
