package Controladores;

import BDutils.conexionbasedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class Controlador_tabla_padres {

    private static Connection conn;

    //Metodo para conectar la clase con la base de datos, accediendo con datos de conexion que se encuentran en la clase conexionbasedatos
    /**
     * Metodo para conectarse a la base de datos
     */
    public Controlador_tabla_padres() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    /**
     * Pide primero el nombre del alumno para su utilizacion y a continuacion realiza una consulta a la base de datos para obtener los nombres de los alumnos
     * @param nombre parametro que despues se utiliza para realizar la correcta consulta a la base de datos
     * @return devuelve los nombres de los alumnos obtenidos
     */
    public String getalumno(String nombre) {

        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select alumno FROM view_name3 WHERE nombre = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setString(1,nombre);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                String alumno = rs.getString("alumno");
                return alumno;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Pide primero el nombre del usuario y la contraseña que seran las del login y a continuacion realiza una consulta a la base de datos para obtener los nombres de los padres que cumplen esos parametros
     * @param usuario prametro que despues se utiliza para realizar la consulta a la base de datos
     * @param contraseña prametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve un String con los nombres de los padres obtenidos
     */
    public String getNombrepadre(String usuario, String contraseña) {
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select nombre FROM login WHERE nombre_usuario = ? AND  contraseña = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setString(1, usuario);
            st.setString(2,contraseña);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                String profesor = rs.getString("nombre");
                return profesor;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Pide primero el nombre del usuario y el nombre del padre y a continuacion realiza una consulta a la base de datos para obtener las notas de los alumnos que cumplen esos parametros
     * @param nombre prametro que despues se utiliza para realizar la consulta a la base de datos
     * @param padre prametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve un int con las notas obtenidas anteriormente
     */
    public int getnotas(String nombre, String padre) {

        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select notas FROM view_name3 WHERE alumno = ? AND  nombre = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setString(1, nombre);
            st.setString(2, padre);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                int notas= rs.getInt("notas");
                return notas;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
