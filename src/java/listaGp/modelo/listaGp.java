/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGp.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import listaGp.excepcion.PilotoExcepcion;

/**
 *
 * @author Anghelly Giraldo
 */
public class listaGp implements Serializable{
    private NodoGp cabeza;
    
    public listaGp() {
        
        
    }

    public NodoGp getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoGp cabeza) {
        this.cabeza = cabeza;
    }
    
     public void adicionarNodo(Piloto piloto)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoGp(piloto);
        }
        else
        {
            //Lamo a mi ayudante
            NodoGp temp= cabeza;
            while(temp.getSiguiente()!=null) //Mientras que en siguiente exista algo
            {
                temp= temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new NodoGp(piloto));
        }
        
    }
    
    public void adicionarNodoAlInicio(Piloto piloto)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoGp(piloto);
        }
        else
        {
            NodoGp temp= new NodoGp(piloto);
            temp.setSiguiente(cabeza);
            cabeza= temp;
        }
    }
    
    public short contarNodos()
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            NodoGp temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=null)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    public String obtenerListadoPilotos()
    {
        
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        
        return listarPilotos("");
    }
    
    public String listarPilotos(String listado)
    {
        if(cabeza !=null)
        {
            NodoGp temp= cabeza;            
            while(temp!=null)
            {
                listado += temp.getDato()+"\n";
                temp=temp.getSiguiente();
                
            }
            return listado;
        }
        return "No hay infantes";
    }
    
    
     public List obtenerListaPilotos()
    {
        List<Piloto> listado = new ArrayList<>();
        //Un método recursivo que recoora mis infantes y que sacando la
        // info la adicione een el string
        listarPilotos(listado);
        return listado;
    }
    
    public void listarPilotos(List listado)
    {
        if(cabeza !=null)
        {
            NodoGp temp= cabeza;            
            while(temp!=null)
            {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
                temp=temp.getSiguiente();                
            }            
        }
        
    }
    
    public void invertirLista()
    {
        if(cabeza!=null)
        {
            //Crear una lista temporal la cabeza de la lista temporal está vacía
            listaGp listaTemporal = new listaGp();
            // Llamo un ayudante
            NodoGp temp= cabeza;
            //Recorro la lista de principio a fin
            while(temp!=null)
            {         
               //Parado en cada nodo , se extrae la información y se
                // envía a la otra lista al inicio
                listaTemporal.adicionarNodoAlInicio(temp.getDato());
                temp=temp.getSiguiente();                
            }   
            //Igualo la cabeza de mi lista principal a la cabeza de la lista temporal
            cabeza= listaTemporal.getCabeza();
        }
    }
    
    public short contarPilotosxGenero(boolean genero)
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            NodoGp temp= cabeza;
            short cont=0;
            while(temp!=null)
            {
                if(temp.getDato().isGenero()==genero)
                {
                  cont++;   
                }                
                temp=temp.getSiguiente();
                
            }
            return cont;
        }
    }
    /*
    Receta para eliminar un niño 
 Primero, preguntar el código del niño que desea eliminar.
segundo, preguntar si la cabeza tiene algo, si la cabeza 
es el código a eliminar digo que cabeza=cabeza.siguiente si,no llamó al ayudante 
    y le digo que recorra la lista preguntando si el que sigue existe, si lo que 
    hay en el siguiente es lo que se desea eliminar, 
    le digo al ayudante que en siguiente coloque lo que tiene el siguiente en siguiente 
*/
    public void eliminarPiloto(short codigo ) throws PilotoExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {
                cabeza=cabeza.getSiguiente();
                return;
            }
            else
            {
                NodoGp temp=cabeza;
                while(temp.getSiguiente()!=null)
                {
                    if(temp.getSiguiente().getDato().getCodigo()== codigo)
                    {
                        //el que sigue es el que hay que eliminar
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        return;
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new PilotoExcepcion("El código "+codigo +" no existe en la lista");
            }
        }
        throw new PilotoExcepcion("La lista de piloto está vacía");
    }
    
    
     public Piloto obtenerPilotos(short codigo ) throws PilotoExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {                
                return cabeza.getDato();
            }
            else
            {
                NodoGp temp=cabeza;
                while(temp!=null)
                {
                    if(temp.getDato().getCodigo()== codigo)
                    {                                                
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new PilotoExcepcion("El código "+codigo +" no existe en la lista");
            }
        }
        throw new PilotoExcepcion("La lista de Piloto está vacía");
    }
  

    
}