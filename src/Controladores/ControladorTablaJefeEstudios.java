package Controladores;

import BDutils.conexionbasedatos;
import models.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorTablaJefeEstudios {
    private static Connection conn;

    public ControladorTablaJefeEstudios() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    public ArrayList<Curso> getAlumnosxCurso(String curso){
        ArrayList<Curso> resultado = new ArrayList<Curso>();

        String SQL = "SELECT Alumnos, curso FROM alumno_cursos WHERE curso = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setString(1, curso);
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

}
