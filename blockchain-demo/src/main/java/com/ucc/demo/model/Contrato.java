package com.ucc.demo.model;

public class Contrato {
    private Long id;
    private String comprador;
    private String vendedor;
    private String estado;

    // ✅ Constructor vacío requerido por Jackson
    public Contrato() {
    }

    public Contrato(Long id, String comprador, String vendedor) {
        this.id = id;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.estado = "PENDIENTE";
    }

    // Getters y Setters...

    public Long getId() {
        return id;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
