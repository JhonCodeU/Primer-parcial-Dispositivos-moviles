package com.example.primerparcialdispositivosmoviles;

import java.util.Iterator;

public class Product implements Comparable<Product>{

    private int codigo;
    private String nombre;
    private double valor;
    private boolean conIva;
    private String descripcion;
    private String categoria;

    public Product(int codigo, String nombre, double valor, boolean conIva, String descripcion, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
        this.conIva = conIva;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isConIva() {
        return conIva;
    }

    public void setConIva(boolean conIva) {
        this.conIva = conIva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int compareTo(Product o) {
        if (o.getValor()> valor){
            return -1;
        }else if(o.getValor() > valor){
            return 0;
        }else {
            return 1;
        }
    }
}
