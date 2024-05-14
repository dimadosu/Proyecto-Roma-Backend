package com.roma.proyectobackendroma.services;

import com.roma.proyectobackendroma.models.Marca;
import com.roma.proyectobackendroma.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listAll(){
        return marcaRepository.findAll();
    }

    public Marca save(Marca marca){
        return marcaRepository.save(marca);
    }

    public Optional<Marca> findById(Integer id){
        return marcaRepository.findById(id);
    }

    public boolean delete (Integer id){
        Optional<Marca> optionalMarca = this.findById(id);
        if(optionalMarca.isPresent()){
            marcaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
