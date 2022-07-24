package Controladores;
import Clases.ClsCandidato;
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

    public Boolean agregarCandidato(ClsCandidato candidato) {

        boolean respuesta = this.modeloCandidato.agregarCandidato(candidato);
      
        return true;
    }

}
