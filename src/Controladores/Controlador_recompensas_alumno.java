package Controladores;

import BDutils.conexionbasedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador_recompensas_alumno {
    private static Connection conn;
    //Metodo para conectar la clase con la base de datos, accediendo con datos de conexion que se encuentran en la clase conexionbasedatos

    /**
     * Metodo para conectarse a la base de datos
     */
    public Controlador_recompensas_alumno() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    public static String getCursoAlumno(String nombre) {
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "SELECT curso FROM alumno_cursos where Alumnos = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setString(1, nombre);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()) {
                //Mientras que los resultados tengan datos, guarda los mismos en el array
                String curso = alumnosAsignatura.getString(1);
                return curso;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
