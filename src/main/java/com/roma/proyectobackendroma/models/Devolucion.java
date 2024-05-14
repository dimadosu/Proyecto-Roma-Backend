package com.roma.proyectobackendroma.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "devoluciones")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private int cantidad;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @PrePersist
    public void Prepersit(){
        this.fecha = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "id_devolucion")
    private TipoDevolucion tipoDevolucion;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Devolucion(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoDevolucion getTipoDevolucion() {
        return tipoDevolucion;
    }

    public void setTipoDevolucion(TipoDevolucion tipoDevolucion) {
        this.tipoDevolucion = tipoDevolucion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
