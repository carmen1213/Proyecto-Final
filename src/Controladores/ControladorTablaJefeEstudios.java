package Controladores;

import BDutils.conexionbasedatos;
import models.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class ControladorTablaJefeEstudios {
    private static Connection conn;

    //Metodo para conectar la clase con la base de datos, accediendo con datos de conexion que se encuentran en la clase conexionbasedatos
    public ControladorTablaJefeEstudios() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    /**
     * Metodo pare obtencion y almacenamiento de los datos de las Cursos
     *
     * @return devuelve los datos correspondientes
     */
    public ArrayList<Curso> getAlumnosxCurso(String curso) {
        //Crea un array de tipo Curso (objeto) para almacenar los diferentes datos
        ArrayList<Curso> resultado = new ArrayList<Curso>();

        String SQL = "SELECT Alumnos, curso FROM alumno_cursos WHERE curso = ? ";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setString(1, curso);
            ResultSet alumnosAsignatura = st.executeQuery();
            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (alumnosAsignatura.next()) {
                String nombre = alumnosAsignatura.getString(1);
                String cursos = alumnosAsignatura.getString(2);
                resultado.add(new Curso(nombre, cursos));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultado;
    }

}
