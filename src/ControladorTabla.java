
import models.Alumno;
import models.Asignatura;

import java.sql.*;
import java.util.ArrayList;

public class ControladorTabla {
    private static Connection conn;

    public ControladorTabla() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    public ArrayList<String> getDatosTablaAsistencia(int asignatura){
        ArrayList<String> resultado = new ArrayList<>();
        String SQL = "SELECT nombre FROM alumnos WHERE id_alumno IN(" +
                "SELECT id_alumno FROM alumnos_curso WHERE id_curso IN(" +
                "SELECT id_curso FROM asignatura where id_asignatura = ?" +
                ")" +
                ");";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1,asignatura);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()){
                resultado.add(alumnosAsignatura.getString(1));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }

    public ArrayList<String> getNombreAlumnoxAsignatura(int idAsignatura){
        ArrayList<String> resultado = new ArrayList<>();
        String SQL = "SELECT id_alumno FROM alumnos_asignatura where id_asignatura = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1,idAsignatura);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()){
                resultado.add(alumnosAsignatura.getString(1));
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

}
