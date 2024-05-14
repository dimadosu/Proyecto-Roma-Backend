package com.roma.proyectobackendroma.repository;


import com.roma.proyectobackendroma.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
