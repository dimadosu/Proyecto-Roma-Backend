package com.roma.proyectobackendroma.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tipoDevoluciones")
public class TipoDevolucion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    public TipoDevolucion(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
