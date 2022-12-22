package com.objetos;

import java.sql.Time;

public class Ruta {
    private Integer id;
    private String destino;
    private Time tiempoViaje;
    private String origen;
    private float distancia;
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Time getTiempoViaje() {
        return tiempoViaje;
    }

    public void setTiempoViaje(Time tiempoViaje) {
        this.tiempoViaje = tiempoViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
