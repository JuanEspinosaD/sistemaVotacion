package Controladores;
import Clases.ClsCandidato;
import Modelos.MdlCandidato;

/**
 *
 * @author Juan Espinosa
 */
public class CtlCandidato {

    MdlCandidato modeloCandidato;

    public CtlCandidato() {

        this.modeloCandidato = new MdlCandidato();
    }

    public Boolean agregarCandidato(ClsCandidato candidato) {

        boolean respuesta = this.modeloCandidato.agregarCandidato(candidato);
      
        return true;
    }

}
