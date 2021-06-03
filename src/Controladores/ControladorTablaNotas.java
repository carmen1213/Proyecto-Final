package Controladores;

import BDutils.conexionbasedatos;
import models.Alumno;
import models.Asignatura;
import models.Notas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorTablaNotas {
    private static Connection conn;


    //Metodo para conectar la clase con la base de datos, accediendo con datos de conexion que se encuentran en la clase conexionbasedatos

    public ControladorTablaNotas() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    public Alumno getidAlumno(String nombre) {
        String SQL = "Select id_alumno FROM alumno WHERE nombre = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del id_usuario que le envia la persona
            st.setString(1, nombre);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto alumno donde almacena esos datos obtenidos
            while (rs.next()) {
                int idAlumno = rs.getInt("id_alumno");
                return new Alumno(nombre, idAlumno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    //Selecciona pidiento el id del usuario a la persona y mediante una consulta a la base de datos, el nombre de los alumnos de la base de datos

    /**
     * Metodo para obtencion y almacenamiento de los datos de los alumnos
     *
     * @param idAlumno Pide al usuario el identificador del usuario que quiere saber los datos
     * @return
     */
    public Alumno getAlumno(int idAlumno) {
        String SQL = "Select nombre FROM alumnos WHERE id_alumno = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del id_usuario que le envia la persona
            st.setInt(1, idAlumno);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto alumno donde almacena esos datos obtenidos
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                return new Alumno(nombre, idAlumno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //Selecciona pidiento el id de la asignatura a la persona y mediante una consulta a la base de datos, obtiene el nombre de la asignatua de la base de datos

    /**
     * Metodo para obtencion y almacenamiento de los datos de las asignaturas
     *
     * @param id_asignatura Pide al usuario el identificador de la asignatura que quiere saber los datos
     * @return
     */

    private Asignatura getAsignatura(int id_asignatura) {
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select nombre FROM asignatura WHERE id_asignatura = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setInt(1, id_asignatura);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                return new Asignatura(nombre, id_asignatura);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    //Selecciona pidiento el id del alumno a la persona y mediante una consulta a la base de datos, obtiene el valor de las notas de ese alumno y el identificador de la asignatua de la base de datos

    /**
     * @param id_alumno
     * @return
     */
    public ArrayList<Notas> getNotas(int id_alumno) {
        //
        Alumno alm = getAlumno(id_alumno);
        ArrayList<Notas> resultado = new ArrayList<Notas>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select notas, id_asignatura FROM notas WHERE id_alumno = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, id_alumno);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                double notas = rs.getDouble("notas");
                int id_asignatura = rs.getInt("id_asignatura");
                Asignatura asig = getAsignatura(id_asignatura);
                resultado.add(new Notas(alm, asig, notas));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }

    public int getid_asignatura(int id_profesor) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select id_asignatura FROM profesor_asignatura WHERE id_profesor = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, id_profesor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id_asignatura = rs.getInt("id_asignatura");
                resultado.add(id_asignatura);
                return id_asignatura;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
