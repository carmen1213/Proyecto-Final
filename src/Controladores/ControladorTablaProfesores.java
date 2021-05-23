package Controladores;
import BDutils.conexionbasedatos;
import models.Alumno;
import models.Asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorTablaProfesores {
    private static Connection conn;

    //Utilizando los datos que se encuentran en la clase de conexionbasesdatos accede a la base de datos para mas adelante añadir o obtener datos
    public ControladorTablaProfesores() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }
    public int getidProfesor(String nombre){
        String SQL = "Select id_profesor FROM profesor WHERE nombre = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del id_usuario que le envia la persona
            st.setString(1,nombre);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto alumno donde almacena esos datos obtenidos
            while (rs.next()){
                int id_profesor = rs.getInt("id_profesor");
                return id_profesor;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    //Obtiene para el id del alumno para poder obtener las asignaturas que le corresponnda, para la tabla de asistencia de la clase de profesor
    public ArrayList<String> getidAlumno(int idAsignatura) {
        ArrayList<String> resultado = new ArrayList<>();
        String SQL = "SELECT id_alumno FROM alumnos_asignatura where id_asignatura = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, idAsignatura);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()) {
                resultado.add(alumnosAsignatura.getString(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }

    /**
     *
     * @param idProfesor
     * @return
     */

    //Obtiene las asignaturas que imparte el profesor, para que aparezcan las mismas en las opciones de la tabla que se encuentra en la misma clase
    public ArrayList<Asignatura> getAsignaturaProfesor(int idProfesor) {
        ArrayList<Asignatura> resultado = new ArrayList<Asignatura>();

        String SQL = "SELECT id_asignatura, nombreAsig FROM asignatura_profesor where id_profesor = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, idProfesor);
            ResultSet alumnosAsignatura = st.executeQuery();
            System.out.println(alumnosAsignatura);
            while (alumnosAsignatura.next()) {
                String nombre = alumnosAsignatura.getString(2);
                int id = alumnosAsignatura.getInt(1);
                resultado.add(new Asignatura(nombre, id));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultado;
    }
    public ArrayList<Alumno> getAlumnosxAsignaturaA(int idAsignatura){
        ArrayList<Alumno> resultado = new ArrayList<Alumno>();

        String SQL = "SELECT nombre, id_alumno FROM alumnos_asignatura where id_asignatura = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1,idAsignatura);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()){
                String nombre = alumnosAsignatura.getString(1);
                int id = alumnosAsignatura.getInt(2);
                resultado.add(new Alumno(nombre, id));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultado;
    }
}