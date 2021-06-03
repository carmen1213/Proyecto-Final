package Controladores;

import BDutils.conexionbasedatos;
import models.Alumno;
import models.Asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */
public class ControladorNotasALumnos {
    private static Connection conn;
    /**
     * Metodo para conectarse a la base de datos
     */
    //Utilizando los datos que se encuentran en la clase de conexionbasesdatos accede a la base de datos para mas adelante añadir o obtener datos
    public ControladorNotasALumnos() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    /**
     *
     * @param id parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return
     */
    public ArrayList<String> getnobreALumnos(int id) {
        ArrayList<String> resultado = new ArrayList<String>();

        String SQL = "SELECT nombre FROM alumnos_asignatura WHERE id_alumno = ?  ";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, id);
            ResultSet alumnosAsignatura = st.executeQuery();
            while (alumnosAsignatura.next()) {
                String nombre = alumnosAsignatura.getString(1);
                resultado.add(nombre);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultado;
    }

    /**
     *
     * @param text parametro que despues se utiliza para realizar la consulta a la base de datos
     * @param contraseñaText parametro que despues se utiliza para realizar la consulta a la base de datos
     * @param id_alumno parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve una lista con los diferentes objetos asignatura creados con los datos obtenidos
     */
    public ArrayList<Asignatura> getasignaturas(String text, String contraseñaText, int id_alumno) {
        ArrayList<Asignatura> resultado = new ArrayList<Asignatura>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente

        String SQL = "SELECT nombreAsignatura, id_asignatura FROM alumnos_asignatura WHERE id_asignatura IN ( SELECT id_asignaturas FROM notas WHERE id_asignaturas = id_asignatura AND id_alumno = ?)";
        try {
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_alumno que le envia la persona
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setInt(1, id_alumno);
            //Obtiene los resultados
            ResultSet alumnosAsignatura = st.executeQuery();
            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos

            while (alumnosAsignatura.next()) {
                String nombre = alumnosAsignatura.getString(1);
                int id_asig = alumnosAsignatura.getInt(2);
                resultado.add(new Asignatura(nombre, id_asig));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultado;
    }

    /**
     *
     * @param usuarioText parametro que despues se utiliza para realizar la consulta a la base de datos
     * @param text parametro que despues se utiliza para realizar la consulta a la base de datos
     * @param nombre parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve una lista con los nombres de las asignaturas obtenidos
     */
    public ArrayList<String> getasignaturas(String usuarioText, String text, String nombre) {
        ArrayList<String> notas = new ArrayList<String>();

        String SQL = "Select nombreAsignatura FROM alumnos_asignatura WHERE nombre = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del nombre que le envia la persona
            st.setString(1, String.valueOf(nombre));
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto alumno donde almacena esos datos obtenidos
            while (rs.next()) {
                String nombres = rs.getString("nombreAsignatura");
                notas.add(nombres);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return notas;
    }

    /**
     *
     * @param id_alumno parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return Una lista con las diferentes notas
     */
    public ArrayList<Integer> getNotasalumnos(int id_alumno) {
        ArrayList<Integer> notas = new ArrayList<Integer>();


        String SQL = "Select notas FROM notas WHERE id_alumno = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del id_alumno que le envia la persona
            st.setInt(1, id_alumno);

            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto alumno donde almacena esos datos obtenidos
            while (rs.next()) {
                int idAlumno = rs.getInt("notas");
                notas.add(idAlumno);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return notas;
    }

    /**
     *
     * @param idAlumno parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve un objeto alumno con sus respectivos resultados obtenidos
     */
    public Alumno getAlumno(int idAlumno) {
        String SQL = "Select nombre FROM alumno WHERE id_alumno = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del id_alumno que le envia la persona
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

    /**
     *
     * @param nombre parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve un objeto alumno con sus respectivos datos obtenidos
     */
    public Alumno getAlumnoid(String nombre) {
        String SQL = "Select id_alumno FROM alumno WHERE nombre = ?";
        try {
            //Conecta con la base de datos y realiza a la misma la consulta correspondiente
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato del nombre que le envia la persona
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

    /**
     *
     * @param id_asignatura parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve un objeto asignatura con los datos correspondientes obtenidos
     */
    public Asignatura getAsignatura(int id_asignatura) {
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
}
