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
public class NodoGp implements Serializable{
    
    private Piloto dato;
    private NodoGp siguiente;
    private NodoGp anterior;

    
     public NodoGp(Piloto dato) {
        this.dato = dato;
    }

    public Piloto getDato() {
        return dato;
    }

    public void setDato(Piloto dato) {
        this.dato = dato;
    }

    public NodoGp getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGp siguiente) {
        this.siguiente = siguiente;
    }

    public NodoGp getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoGp anterior) {
        this.anterior = anterior;
    }
    
    
}
