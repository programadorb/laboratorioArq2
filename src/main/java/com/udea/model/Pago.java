package com.udea.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Pago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String email;
    private Long numeroTarjeta;
    private Long valorTransaccion;
    private String codigoSeguridad;
    private String tipoTarjeta;
    private String fechaVencimiento;
    private String transaccion;
    
    public Pago(){}

    public void setNombre(String nombre){this.nombre=nombre;}
    public String getNombre(){return this.nombre;}

    public void setEmail(String email){this.email=email;}
    public String getEmail(){return this.email;}

    public void setNumeroTarjeta(Long numeroTarjeta){this.numeroTarjeta=numeroTarjeta;}
    public Long getNumeroTarjeta(){return this.numeroTarjeta;}

    public void setCodigoSeguridad(String codigoSeguridad){this.codigoSeguridad=codigoSeguridad;}
    public String getCodigoSeguridad(){return this.codigoSeguridad;}

    public void setTipoTarjeta(String tipoTarjeta){this.tipoTarjeta=tipoTarjeta;}
    public String getTipoTarjeta(){return this.tipoTarjeta;}

    public void setFechaVencimiento(String fechaVencimiento){this.fechaVencimiento=fechaVencimiento;}
    public String getFechaVencimiento(){return this.fechaVencimiento;}

    public void setTransaccion(String transaccion){this.transaccion=transaccion;}
    public String getTransaccion(){return this.transaccion;}

    public void setValorTransaccion(Long valorTransaccion){this.valorTransaccion=valorTransaccion;}
    public Long getValorTransaccion(){return this.valorTransaccion;}

    public void setId(long id){this.id=id;}
    public long getId(){return this.id;}
}