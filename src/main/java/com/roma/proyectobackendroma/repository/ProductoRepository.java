package com.roma.proyectobackendroma.repository;

import com.roma.proyectobackendroma.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
