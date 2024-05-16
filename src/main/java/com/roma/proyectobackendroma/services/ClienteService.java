package com.roma.proyectobackendroma.services;

import com.roma.proyectobackendroma.models.Cliente;
import com.roma.proyectobackendroma.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listAll(){
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Integer id){
        return clienteRepository.findById(id);
    }

    public boolean delete(Integer id){
        Optional<Cliente> optionalCliente = this.findById(id);
        if(optionalCliente.isPresent()){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
