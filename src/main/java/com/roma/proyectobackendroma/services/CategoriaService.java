package com.roma.proyectobackendroma.services;

import com.roma.proyectobackendroma.models.Categoria;
import com.roma.proyectobackendroma.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listAll(){
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void delete (Integer id){
        categoriaRepository.deleteById(id);
    }

    public Optional<Categoria> findById(Integer id){
        return categoriaRepository.findById(id);
    }


}
