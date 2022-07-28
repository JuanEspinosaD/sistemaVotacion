package Clases;



/**
 *
 * @author Juan Espinosa
 */
public class ClsVotante extends ClsPersona {

    private String sexo;

    public ClsVotante(String sexo, String numeroCedula, String nombre, 
            String correo, String telefono, String ciudadOrigen, String direccion) {
        super(numeroCedula, nombre, correo, telefono, ciudadOrigen, direccion);
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
    
    

}
