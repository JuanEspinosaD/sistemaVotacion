
package Clases;

/**
 *
 * @author Juan Espinosa
 */
public class ClsCandidato extends ClsPersona {

    private String partido;
    private String mensajeCampania;
    private String descripcion;

    public ClsCandidato(String partido, String mensajeCampania,
            String descripcion, String numeroCedula, String nombre,
            String correo, String telefono, String ciudadOrigen,
            String direccion) {
        super(numeroCedula, nombre, correo, telefono, ciudadOrigen, direccion);
        this.partido = partido;
        this.mensajeCampania = mensajeCampania;
        this.descripcion = descripcion;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getMensajeCampania() {
        return mensajeCampania;
    }

    public void setMensajeCampania(String mensajeCampania) {
        this.mensajeCampania = mensajeCampania;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
