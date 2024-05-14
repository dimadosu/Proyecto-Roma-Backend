package com.roma.proyectobackendroma.controller;

import com.roma.proyectobackendroma.models.Marca;
import com.roma.proyectobackendroma.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/listar")
    public List<Marca> listar(){
        return marcaService.listAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarMarca(@RequestBody Marca marca){
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.save(marca));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
        Optional<Marca> optionalMarca = marcaService.findById(id);
        if(optionalMarca.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalMarca.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        boolean resultado = marcaService.delete(id);
        if(resultado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
