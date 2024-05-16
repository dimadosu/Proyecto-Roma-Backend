package com.roma.proyectobackendroma.services;

import com.roma.proyectobackendroma.models.MetodoPago;
import com.roma.proyectobackendroma.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> listAll(){
        return metodoPagoRepository.findAll();
    }

    public MetodoPago save(MetodoPago metodoPago){
        return metodoPagoRepository.save(metodoPago);
    }

    public Optional<MetodoPago> findById(Integer id){
        return metodoPagoRepository.findById(id);
    }

    public boolean delete(Integer id){
        Optional<MetodoPago> optionalMetodoPago = this.findById(id);
        if(optionalMetodoPago.isPresent()){
            metodoPagoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}