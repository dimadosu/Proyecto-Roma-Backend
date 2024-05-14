package com.roma.proyectobackendroma.services;

import com.roma.proyectobackendroma.models.Proveedor;
import com.roma.proyectobackendroma.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listAll(){
        return  proveedorRepository.findAll();
    }

    public Proveedor save (Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public boolean delete(Integer id){
        Optional<Proveedor> optionalProveedor = this.findById(id);
        if(optionalProveedor.isPresent()){
            proveedorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Proveedor> findById(Integer id){
        return proveedorRepository.findById(id);
    }
}
