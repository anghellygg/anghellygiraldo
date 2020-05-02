/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGp.modelo;

import java.io.Serializable;

/**
 *
 * @author Anghelly Giraldo
 */
public class Piloto implements Serializable{
    
    private String nombre;
    private short codigo;
    private boolean genero;
    private boolean estado;
    private boolean marca;
    private int cilindraje;
    private boolean color;
    private int modelo;

    public Piloto(String nombre, short codigo, boolean genero, boolean estado, boolean marca, int cilindraje, boolean color, int modelo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.genero = genero;
        this.estado = estado;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getMarca() {
        return marca;
    }

    public void setMarca(boolean marca) {
        this.marca = marca;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    
    
    
    
  @Override
    public String toString() {
       return this.nombre; 
    }  
    
    
      

    
    
}
