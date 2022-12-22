package com.objetos;

public class Empleado {
    private Integer ci;
    private Integer nitSucursal;
    private String nombre;
    private String direccion;

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public Integer getNitSucursal() {
        return nitSucursal;
    }

    public void setNitSucursal(Integer nitSucursal) {
        this.nitSucursal = nitSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
