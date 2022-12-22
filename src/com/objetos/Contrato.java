package com.objetos;

import java.sql.Date;

public class Contrato {
    private Integer idRuta;
    private Integer ciConductor;
    private String placa;
    private Integer ciCliente;
    private Integer ciEmpleado;
    private Integer nitSucursal;
    private Date fechaRegContrato;
    private Date fechaSalida;
    private Date fechaLlegada;
    private float montoTotal;

    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public Integer getCiConductor() {
        return ciConductor;
    }

    public void setCiConductor(Integer ciConductor) {
        this.ciConductor = ciConductor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getCiCliente() {
        return ciCliente;
    }

    public void setCiCliente(Integer ciCliente) {
        this.ciCliente = ciCliente;
    }

    public Integer getCiEmpleado() {
        return ciEmpleado;
    }

    public void setCiEmpleado(Integer ciEmpleado) {
        this.ciEmpleado = ciEmpleado;
    }

    public Integer getNitSucursal() {
        return nitSucursal;
    }

    public void setNitSucursal(Integer nitSucursal) {
        this.nitSucursal = nitSucursal;
    }

    public Date getFechaRegContrato() {
        return fechaRegContrato;
    }

    public void setFechaRegContrato(Date fechaRegContrato) {
        this.fechaRegContrato = fechaRegContrato;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }
}
