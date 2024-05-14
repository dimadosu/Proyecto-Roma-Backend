package com.roma.proyectobackendroma.controller;

import com.roma.proyectobackendroma.models.Proveedor;
import com.roma.proyectobackendroma.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/listar")
    public List<Proveedor> listar(){
        return proveedorService.listAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProveedor(@RequestBody Proveedor proveedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.save(proveedor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){
        Optional<Proveedor> optionalProveedor = proveedorService.findById(id);
        if(optionalProveedor.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalProveedor.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        boolean resultado = proveedorService.delete(id);
        if(resultado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
