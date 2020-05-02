/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listaenlazada.controlador;

import com.listaenlazada.controlador.util.JsfUtil;
import com.listaenlazada.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Anghelly Giraldo
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String correo;
    private String Contrseña;
    private Usuario usuarioAutenticado;
    @EJB
    private UsuarioFacade coneccionUsuario;
  
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrseña() {
        return Contrseña;
    }

    public void setContrseña(String Contrseña) {
        this.Contrseña = Contrseña;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }
    
    public String ingresar()
    {
        Usuario usuencontrado = coneccionUsuario.find(correo);
        if(usuencontrado !=null)
        {
            if(usuencontrado.getContraseña().equals(Contrseña))
            {
                usuarioAutenticado = usuencontrado;
                return "infantes";
            }
        }
        JsfUtil.addErrorMessage("Datos encontrados");
        return null;
    }
}
