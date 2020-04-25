/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGp.controlador;

import com.listase.utilidades.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import listaGp.excepcion.PilotoExcepcion;
import listaGp.modelo.NodoGp;
import listaGp.modelo.Piloto;
import listaGp.modelo.listaGp;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author Anghelly Giraldo
 */
@Named(value = "SesionMotoGP")
@SessionScoped
public class SesionMotoGP implements Serializable{
    private listaGp listaPilotos;
    private Piloto piloto;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private NodoGp ayudante;   
    private String textoVista="Gráfico";
    
    private List listadoPilotos;
    
    private DefaultDiagramModel model;
    
    private short codigoEliminar;
    
    private String codigoDeptoSel;
    
    private short pilotoSeleccionado;
    
    private Piloto pilotoDiagrama;
    
    /**
     * Creates a new instance of SesionInfante
     */
    public SesionMotoGP() {        
    }
    
    @PostConstruct
    private void inicializar()
    {
         
        listaPilotos = new listaGp();        
        //LLenado de la bds
        listaPilotos.adicionarNodo(new Piloto("camila", codigoEliminar, deshabilitarFormulario, deshabilitarFormulario, alInicio, codigoEliminar, alInicio, codigoEliminar));
        ayudante = listaPilotos.getCabeza();
        piloto = ayudante.getDato();     
        //Me llena el objeto List para la tabla
        listadoPilotos = listaPilotos.obtenerListaPilotos();
        pintarLista();
   }

    public short getPilotoSeleccionado() {
        return pilotoSeleccionado;
    }

    public void setPilotoSeleccionado(short pilotoSeleccionado) {
        this.pilotoSeleccionado = pilotoSeleccionado;
    }

    public Piloto getPilotoDiagrama() {
        return pilotoDiagrama;
    }

    public void setPilotoDiagrama(Piloto pilotoDiagrama) {
        this.pilotoDiagrama = pilotoDiagrama;
    }

    public String getCodigoDeptoSel() {
        return codigoDeptoSel;
    }

    public void setCodigoDeptoSel(String codigoDeptoSel) {
        this.codigoDeptoSel = codigoDeptoSel;
    }

    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }

   
     
    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));
         
        if(label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }
         
        return conn;
    }
    

    public short getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setCodigoEliminar(short codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    
    
    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }

    public List getListadoPilotos() {
        return listadoPilotos;
    }

    public void setListadoPilotos(List listadoPilotos) {
        this.listadoPilotos = listadoPilotos;
    }

    

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

  
    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }

    
    public listaGp getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(listaGp listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    
    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    
   
    
    public void guardarPiloto()
    {
        //obtiene el consecutivo
        piloto.setCodigo((short)(listaPilotos.contarNodos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaPilotos.adicionarNodoAlInicio(piloto);
        }
        else
        {
            listaPilotos.adicionarNodo(piloto);
        }  
        //Vuelvo a llenar la lista para la tabla
        listadoPilotos = listaPilotos.obtenerListaPilotos();
        pintarLista();
        deshabilitarFormulario=true;
        JsfUtil.addSuccessMessage("El infante se ha guardado exitosamente");
        
    }
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        piloto = new Piloto(alInicio, codigoEliminar, deshabilitarFormulario, deshabilitarFormulario, alInicio, codigoEliminar, alInicio, codigoEliminar);
    }
    
    public void irAnterior()
    {
        if(ayudante.getAnterior()!=null)
        {
            ayudante = ayudante.getAnterior();
            piloto = ayudante.getDato();
        }        
    }
    
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            piloto = ayudante.getDato();
        }        
    }
    
    public void irPrimero()
    {
        if(listaPilotos.getCabeza()!=null)
        {
            ayudante = listaPilotos.getCabeza();
            piloto = ayudante.getDato();
            
        }
        else
        {
            piloto = new Piloto(alInicio, codigoEliminar, deshabilitarFormulario, deshabilitarFormulario, alInicio, codigoEliminar, alInicio, codigoEliminar);
        }
        listadoPilotos = listaPilotos.obtenerListaPilotos();
        pintarLista();
             
    }
    
    public void irUltimo()
    {
        if(listaPilotos.getCabeza()!=null)
        {            
            while(ayudante.getSiguiente()!=null)
            {
                ayudante = ayudante.getSiguiente();
            }
            piloto=ayudante.getDato();
        }
    }
    
    public void cambiarVistaPilotos()
    {
        if(textoVista.compareTo("Tabla")==0)
        {
            textoVista = "Gráfico";
        }
        else
        {
            textoVista = "Tabla";
        }
    }
    
    public void invertirLista(){
        //Invierte la lista
        listaPilotos.invertirLista();
        irPrimero();
    }
    
    
    public void pintarLista() {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Se establece para que el diagrama pueda tener infinitas flechas
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        ///Adicionar los elementos
        if (listaPilotos.getCabeza() != null) {
            //llamo a mi ayudante
            NodoGp temp = listaPilotos.getCabeza();
            int posX=2;
            int posY=2;
            //recorro la lista de principio a fin
            while(temp !=null)
            {
                //Parado en un elemento
                //Crea el cuadrito y lo adiciona al modelo
                Element ele = new Element(temp.getDato().getCodigo()+" "+
                        temp.getDato().getNombre(), 
                        posX+"em", posY+"em");
                ele.setId(String.valueOf(temp.getDato().getCodigo()));
                //adiciona un conector al cuadrito
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));
                
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));
                model.addElement(ele);                    
                temp=temp.getSiguiente();
                posX=  posX+5;
                posY= posY+6;
            }            
           
            //Pinta las flechas            
            for(int i=0; i < model.getElements().size() -1; i++)
            {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1), 
                        model.getElements().get(i+1).getEndPoints().get(0), "Sig"));
                
                
                model.connect(createConnection(model.getElements().get(i+1).getEndPoints().get(2), 
                        model.getElements().get(i).getEndPoints().get(3), "Ant"));
            }
            
        }
    }
    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
         
        pilotoSeleccionado = Short.valueOf(id.replaceAll("frmPiloto:diagrama-", ""));
        
    }

    public void eliminarPiloto()
    {
        if(codigoEliminar >0)
        {
            //llamo el eliminar de la lista
            try{
                listaPilotos.eliminarPiloto(codigoEliminar);
                irPrimero();
                JsfUtil.addSuccessMessage("Piloto "+codigoEliminar +" eliminado.");
            }
            catch(PilotoExcepcion e)
            {
                JsfUtil.addErrorMessage(e.getMessage());
            }
        }
        else
        {
            JsfUtil.addErrorMessage("El código a eliminar "+codigoEliminar+ " no es válido");
        }
    }
    
    public void eliminarPilotoEnDiagrama()
    {
       
            //llamo el eliminar de la lista
            try{
                listaPilotos.eliminarPiloto(pilotoSeleccionado);
                irPrimero();
                JsfUtil.addSuccessMessage("Piloto "+pilotoSeleccionado +" eliminado.");
            }
            catch(PilotoExcepcion e)
            {
                JsfUtil.addErrorMessage(e.getMessage());
            }
            JsfUtil.addErrorMessage("El código a eliminar "+pilotoSeleccionado+ " no es válido");
        }
        
    
    public void obtenerPilotoDiagrama()
    {
        try {
            pilotoDiagrama = listaPilotos.obtenerPilotos(pilotoSeleccionado);
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlFinal()
    {
        try {
            ///Buscar el infante y guardar los datos en una variable temporal
            Piloto pilTemporal = listaPilotos.obtenerPilotos(pilotoSeleccionado);
            // Eliminar el nodo
            listaPilotos.eliminarPiloto(pilotoSeleccionado);
            // Adicionarlo al final
            listaPilotos.adicionarNodo(pilTemporal);
            
            pintarLista();
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlInicio()
    {
        try {
            ///Buscar el infante y guardar los datos en una variable temporal
            Piloto pilTemporal = listaPilotos.obtenerPilotos(pilotoSeleccionado);
            // Eliminar el nodo
            listaPilotos.eliminarPiloto(pilotoSeleccionado);
            // Adicionarlo al inicio
            listaPilotos.adicionarNodoAlInicio(pilTemporal);
            
            pintarLista();
        } catch (PilotoExcepcion ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
 
   
}
