package Controladores;
import Clases.ClsCandidato;
import Clases.ClsMensaje;
import Modelos.MdlCandidato;
import java.util.LinkedList;

/**
 *
 * @author Juan Espinosa
 */
public class CtlCandidato {

    MdlCandidato modeloCandidato;

    public CtlCandidato() {

        this.modeloCandidato = new MdlCandidato();
    }
    
    
     public LinkedList<ClsCandidato> obtenerCandidatos(){
         LinkedList<ClsCandidato> listaCandidatos=this.modeloCandidato.obtenerCandidatos();
        
        return listaCandidatos;
    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = this.modeloCandidato.agregarCandidato(candidato);
      
        return mensaje;
    }
    
    public ClsMensaje eliminarCandidato(String id){
        
        ClsMensaje mensaje = this.modeloCandidato.eliminarCandidato(id);
      
        return mensaje;
    }

}
