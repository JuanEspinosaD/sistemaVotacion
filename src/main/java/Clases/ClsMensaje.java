package Clases;

/**
 *
 * @author Juan Espinosa
 */
public class ClsMensaje {
    
    public final static String OK="OK";
    public final static String ERROR="ERROR";
    public final static String ADVERTENCIA="ADVERTENCIA";

    private String tipo;
    private String texto;

    public ClsMensaje(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

}
