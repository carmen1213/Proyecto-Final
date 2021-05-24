package Controladores;

import BDutils.conexionbasedatos;
import models.Alumno;
import models.Asignatura;
import models.Curso;
import models.Notas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorNotasALumnos {
    private static Connection conn;

    //Utilizando los datos que se encuentran en la clase de conexionbasesdatos accede a la base de datos para mas adelante añadir o obtener datos
    public ControladorNotasALumnos() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    public ArrayList <Integer> getNotasalumnos(){
        ArrayList <Integer> notas = new ArrayList<Integer>();
        Alumno id = getAlumno(3);
        Asignatura asig = getAsignatura(3);

        String SQL = "Select notas FROM notas WHERE id_alumno = 3";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del id_usuario que le envia la persona
           // st.setInt(1,id_alumnos);

            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto alumno donde almacena esos datos obtenidos
            while (rs.next()){
                int idAlumno= rs.getInt("notas");
                notas.add(idAlumno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return notas;
    }

    public   Alumno getAlumno(int idAlumno){
        String SQL = "Select nombre FROM alumno WHERE id_alumno = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del id_usuario que le envia la persona
            st.setInt(1,idAlumno);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto alumno donde almacena esos datos obtenidos
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
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select nombre FROM asignatura WHERE id_asignatura = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setInt(1, id_asignatura);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()){
                String nombre = rs.getString("nombre");
                return new Asignatura(nombre, id_asignatura);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
