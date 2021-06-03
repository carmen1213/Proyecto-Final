package Controladores;

import BDutils.conexionbasedatos;
import models.Asignatura;
import models.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador_cursos_material_profesores {

    private static Connection conn;

    /**
     * Metodo para conectarse a la base de datos
     */
    public Controlador_cursos_material_profesores() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    /**
     * Pide primero el id del profesor como paramentro papra la utilizacion y a continuacion realiza una consulta a la base de datos para obtener el curso que tiene a ese profesor
     * @param idProfesor parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve los nombres de los cursos obtenidos
     */
    public static String getCursoProfesor(int idProfesor) {

        String SQL = "SELECT curso FROM profesores_cursos where id_profesor = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, idProfesor);
            ResultSet alumnosAsignatura = st.executeQuery();
            System.out.println(alumnosAsignatura);
            while (alumnosAsignatura.next()) {
                String nombre = alumnosAsignatura.getString(1);
                return nombre;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
