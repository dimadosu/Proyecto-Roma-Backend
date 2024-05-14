package com.roma.proyectobackendroma.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "salidaProductos")
public class SalidaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    private int cantidad;


    public SalidaProducto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
