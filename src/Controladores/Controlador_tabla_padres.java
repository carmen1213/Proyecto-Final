package Controladores;

import BDutils.conexionbasedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador_tabla_padres {
    private static Connection conn;
    public Controlador_tabla_padres() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }
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
    public String getpadre(String usuario, String contraseña) {
        ArrayList<String> nombre_alumno = new ArrayList<String>();
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
