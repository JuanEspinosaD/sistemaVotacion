
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Juan Espinosa
 */
public class MdlEleccion {

    ClsJdbc jdbc;

    public MdlEleccion() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }

    public ClsMensaje agregarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_elecciones VALUES (?, ?, ?, ?, ?, NOW(), 'abierta')";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, eleccion.getIdEleccion().substring(0, 10));
            sentencia.setString(2, eleccion.getDescripcion());
            sentencia.setString(3, eleccion.getCategoria());
            sentencia.setString(4, eleccion.getFechaInicio());
            sentencia.setString(5, eleccion.getFechaFin());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado una elección exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje asociarCandidato(String idCandidato, String idEleccion) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_candidatos_eleccion VALUES (?, ?, NOW())";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idCandidato);
            sentencia.setString(2, idEleccion);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has asociado un candidato");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsEleccion> obtenerElecciones() {

        try {

            LinkedList<ClsEleccion> lista = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_elecciones";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String idEleccion = resultados.getString("id_eleccion");
                String descripcion = resultados.getString("descripcion");
                String categoria = resultados.getString("categoria");
                String fechaInicio = resultados.getString("fecha_inicion");
                String fechaFin = resultados.getString("fecha_fin");
                String estado = resultados.getString("estado");

                ClsEleccion eleccion = new ClsEleccion(idEleccion, descripcion,
                        categoria,fechaInicio, fechaFin);

                eleccion.setEstado(estado);

                lista.add(eleccion);
            }

            return lista;

        } catch (Exception e) {

            return null;
        }

    }

    public LinkedList<ClsCandidato> obtenerCandidatosEleccion(String idEleccion) {

        try {

            LinkedList<ClsCandidato> lista = new LinkedList<>();

            String consulta = "SELECT tc.* FROM tbl_candidatos_eleccion te,"
                    + " tbl_candidatos tc WHERE te.id_eleccion = ? "
                    + "AND te.id_candidato = tc.id_candidato";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString(1, idEleccion);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String cedula = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String correo = resultados.getString("correo");
                String telefono = resultados.getString("telefono");
                String direccion = resultados.getString("direccion");
                String partido = resultados.getString("partido_politico");
                String mensajeCampania = resultados.getString("mensaje_campania");
                String descripcion = resultados.getString("discripcion");
                String ciudadOrigen = resultados.getString("ciudad_origen");

                ClsCandidato candidato = new ClsCandidato(partido, mensajeCampania, descripcion,
                        cedula, nombre, correo, telefono, ciudadOrigen, direccion
                );
                lista.add(candidato);
            }

            return lista;

        } catch (Exception e) {

            return null;
        }

    }

}