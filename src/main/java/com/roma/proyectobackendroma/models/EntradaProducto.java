package com.roma.proyectobackendroma.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entradaProductos")
public class EntradaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private int stock;

    //inserta la fecha de manera automatica cuando se manda el objeto
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @PrePersist
    public void Prepersit(){
        this.fecha = new Date();
    }


    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public EntradaProducto(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
