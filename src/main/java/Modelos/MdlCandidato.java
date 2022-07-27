package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Juan Espinosa
 */
public class MdlCandidato {

    ClsJdbc jdbc;

    public MdlCandidato() {

        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();

    }

    public LinkedList<ClsCandidato> obtenerCandidatos() {

        try {
            LinkedList<ClsCandidato> lista = new LinkedList<>();
            String consulta = "SELECT * FROM tbl_candidatos";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();
           
            while (resultados.next()) {

                String cedula = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String correo = resultados.getString("correo");
                String telefono = resultados.getString("telefono");
                String direccion = resultados.getString("direccion");
                String partido = resultados.getString("partido_politico");
                String campania = resultados.getString("mensaje_campania");
                String descripcion = resultados.getString("discripcion");
                String ciudadOrigen = resultados.getString("ciudad_origen");

                ClsCandidato candidato = new ClsCandidato(partido, campania,
                        descripcion, cedula, nombre, correo, telefono,
                        ciudadOrigen, direccion);
                
                lista.add(candidato);
                
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {
        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_candidatos VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNumeroCedula());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getCorreo());
            sentencia.setString(4, candidato.getTelefono());
            sentencia.setString(5, candidato.getDireccion());
            sentencia.setString(6, candidato.getPartido());
            sentencia.setString(7, candidato.getMensajeCampania());
            sentencia.setString(8, candidato.getDescripcion());
            sentencia.setString(9, candidato.getCiudadOrigen());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado un candidato exitosamente");
                return mensaje;
            }
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (Exception excepcion) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error" + excepcion.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje eliminarCandidato(String id) {
        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_candidatos WHERE id_candidato=?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un candidato exitosamente");
                return mensaje;
            }
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error");
            return mensaje;

        } catch (Exception excepcion) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Ha ocurrido un error" + excepcion.getMessage());
            return mensaje;
        }

    }
    
      public ClsMensaje actualizarCandidato(ClsCandidato candidato) {
        ClsMensaje mensaje;

        try {
            String sql = "UPDATE tbl_candidatos SET nombre = ?, correo = ?, telefono = ?, " +
                    " direccion = ?, partido_politico = ?, mensaje_campania = ? ," +
                    " discripcion = ?, ciudad_origen = ? WHERE id_candidato = ?"
                    ;
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            
            sentencia.setString(1, candidato.getNombre());
            sentencia.setString(2, candidato.getCorreo());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getDireccion());
            sentencia.setString(5, candidato.getPartido());
            sentencia.setString(6, candidato.getMensajeCampania());
            sentencia.setString(7, candidato.getDescripcion());
            sentencia.setString(8, candidato.getCiudadOrigen());
            sentencia.setString(9, candidato.getNumeroCedula());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "Has actualizado un candidato exitosamente");
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
