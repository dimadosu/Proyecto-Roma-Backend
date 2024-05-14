package com.roma.proyectobackendroma.controller;

import com.roma.proyectobackendroma.models.Categoria;
import com.roma.proyectobackendroma.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCategoria(@RequestBody Categoria categoria){

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id){

        Optional<Categoria> optionalCategoria = categoriaService.findById(id);

        if(optionalCategoria.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalCategoria.orElseThrow());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/listar")
    public List<Categoria> listar(){
        return categoriaService.listAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar (@PathVariable Integer id){
        Optional<Categoria> optionalCategoria = categoriaService.findById(id);
        if(optionalCategoria.isPresent()){
            categoriaService.delete(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
