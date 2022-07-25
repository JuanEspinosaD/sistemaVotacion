package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
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
                String correo = resultados.getString("nombre");
                String telefono = resultados.getString("nombre");
                String direccion = resultados.getString("nombre");
                String partido = resultados.getString("partido_politico");
                String campania = resultados.getString("mensaje_campania");
                String descripcion = resultados.getString("nombre");
                String ciudadOrigen = resultados.getString("nombre");

                ClsCandidato candidato = new ClsCandidato(partido, campania,
                        cedula, nombre, nombre, nombre, nombre, nombre, nombre);
                lista.add(candidato);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean agregarCandidato(ClsCandidato candidato) {

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

            return resultado >= 1;

        } catch (Exception e) {
            return false;
        }

        
    }

}
