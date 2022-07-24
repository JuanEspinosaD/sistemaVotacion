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

                String partido = resultados.getString("partido_politico");
                String campania = resultados.getString("mensaje_campania");
                String cedula = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");

                ClsCandidato candidato= new ClsCandidato(partido, campania, 
                        cedula,nombre,nombre, nombre, nombre, nombre,nombre);
                lista.add(candidato);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }

    }

    public boolean agregarCandidato(ClsCandidato candidato) {

        return true;
    }

}
