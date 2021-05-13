package Controladores;

import BDutils.conexionbasedatos;
import models.Alumno;
import models.Asignatura;
import models.Curso;
import models.Notas;

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

    public ArrayList<String> getidAlumnoxAsignatura(int idAsignatura) {
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

    public ArrayList<Alumno> getAlumnosxAsignaturaA(int idAsignatura){
        ArrayList<Alumno> resultado = new ArrayList<Alumno>();

        String SQL = "SELECT alumnos, id_alumno FROM alumnos_asigntatura where id_asignatura = ?;";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1,idAsignatura);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()){
                String nombre = alumnosAsignatura.getString(1);
                int id = alumnosAsignatura.getInt(2);
                String curso = alumnosAsignatura.getString(3);
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

    private Alumno getAlumno(int idAlumno){
        String SQL = "Select nombre FROM alumnos WHERE id_alumno = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1,idAlumno);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String nombre = rs.getString("nombre");
                return new Alumno(nombre, idAlumno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private Asignatura getAsignatura(int id_asignatura){
        String SQL = "Select nombre FROM asignatura WHERE id_asignatura = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, id_asignatura);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String nombre = rs.getString("nombre");
                return new Asignatura(nombre, id_asignatura);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Curso> getAlumnos(){
        ArrayList<Curso> resultado = new ArrayList<Curso>();

        String SQL = "SELECT Alumnos, curso FROM alumno_cursos WHERE curso = 'Mip' ";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
         //   st.setString(1, curso);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()){
                String nombre = alumnosAsignatura.getString(1);
                String cursos= alumnosAsignatura.getString(2);
                resultado.add(new Curso(nombre,cursos));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Notas> getAlumnosyasignaturas(int id_alumno){
        ArrayList<Notas> resultado = new ArrayList<Notas>();

        String SQL = "SELECT nombre, nombreAsignatura, id_alumno, id_asignatura FROM alumnos_asignatura WHERE id_alumno = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
              st.setInt(1, id_alumno);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()){
                String nombre_alumno = alumnosAsignatura.getString(1);
                String nombre_asignatura= alumnosAsignatura.getString(2);
                Alumno alm = getAlumno(id_alumno);

                //resultado.add(new Notas(alm ,nombre_asignatura));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Notas> getNotas(int id_alumno){
        Alumno alm = getAlumno(id_alumno);
        ArrayList<Notas> resultado = new ArrayList<Notas>();
        String SQL = "Select notas, id_asignaturas FROM notas WHERE id_alumno = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, id_alumno);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                double notas = rs.getDouble("notas");
                int id_asignatura = rs.getInt("id_asignaturas");
                Asignatura asig = getAsignatura(id_asignatura);
                resultado.add(new Notas(alm, asig, notas));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }
}
