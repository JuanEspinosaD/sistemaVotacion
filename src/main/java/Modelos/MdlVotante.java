
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsVotante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Juan Espinosa
 */
public class MdlVotante {
      ClsJdbc jdbc;

    public MdlVotante() {

        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();

    }
    
    public ClsMensaje agregarVotante(ClsVotante votante) {
        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_votantes VALUES (?,?,?,?,?,?,?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNumeroCedula());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getCorreo());
            sentencia.setString(4, votante.getTelefono());
            sentencia.setString(5, votante.getDireccion());
            sentencia.setString(6, votante.getSexo());
            sentencia.setString(7, votante.getCiudadOrigen());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado un votante exitosamente");
                return mensaje;
            }
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (Exception excepcion) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error" + excepcion.getMessage());
            return mensaje;
        }

    }
    
        public LinkedList<ClsVotante> obtenerVotantes() {

        try {
            LinkedList<ClsVotante> lista = new LinkedList<>();
            String consulta = "SELECT * FROM tbl_votantes";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();
           
            while (resultados.next()) {

                String cedula = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String correo = resultados.getString("correo");
                String telefono = resultados.getString("telefono");
                String direccion = resultados.getString("direccion");
                String sexo = resultados.getString("sexo");
                String ciudadOrigen = resultados.getString("ciudadOrigen");

                ClsVotante votante = new ClsVotante(sexo, cedula, nombre, 
                        correo, telefono, ciudadOrigen, direccion);
                        
        
                lista.add(votante);
                
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }
        
      public ClsMensaje eliminarVotante(String id) {
        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_votantes WHERE id_votante=?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un votante exitosamente");
                return mensaje;
            }
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (Exception excepcion) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error" + excepcion.getMessage());
            return mensaje;
        }

    }
        

}
