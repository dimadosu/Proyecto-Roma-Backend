package com.roma.proyectobackendroma.repository;


import com.roma.proyectobackendroma.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {
}
