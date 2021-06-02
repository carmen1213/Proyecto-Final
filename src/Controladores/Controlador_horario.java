package Controladores;

import BDutils.conexionbasedatos;
import models.Asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador_horario {
    private static Connection conn;

    public Controlador_horario() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

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
                System.out.println(nombre);
                return new Asignatura(nombre, id_asignatura);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int getAsignaturaxhora(String horario, String dia_semana) {

        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select id_asignatura FROM horario WHERE hora_inicio = ? AND dia_semana = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setString(1, horario);
            st.setString(2,dia_semana);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                int id_asignatura = rs.getInt("id_asignatura");
                System.out.println(id_asignatura);
                return id_asignatura;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public ArrayList<Asignatura> getAsignatura() {
        ArrayList<Asignatura> asignatura = new ArrayList<Asignatura>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select nombre, id_asignatura FROM view_name";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            //  st.setString(1, nombre);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                String nombres = rs.getString("nombre");
                int id_asignatura = rs.getInt("id_asignatura");
                asignatura.add(new Asignatura(nombres, id_asignatura));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return asignatura;
    }

    public int getasignaturas(String hora_incio) {
        ArrayList<String> asignatura = new ArrayList<String>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select id_asignatura FROM horario WHERE hora_inicio = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setString(1, hora_incio);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                int nombres = rs.getInt("id_asignatura");
                return nombres;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -4;
    }
    public ArrayList<String> gethorarioAsignatura (int id_asignatura) {
        ArrayList<String> asignatura = new ArrayList<String>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select hora_inicio, hora_fin FROM horario WHERE id_asignatura = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setInt(1, id_asignatura);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                String hora0 = rs.getString("hora_inicio");
                String hora1 = rs.getString("hora_fin");
                asignatura.add(hora0);
                asignatura.add(hora1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return asignatura;
    }

    public ArrayList<Integer> getidAsignatua(Object hora_incio, String  dia_semana, Object hora_fin) {
        ArrayList<Integer> asignatura = new ArrayList<Integer>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select id_asignatura FROM horario WHERE hora_inicio = ? AND dia_semana = ? AND hora_fin = ?";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de id_asignatura que le envia la persona
            st.setString(1, (String) hora_incio);
            st.setString(2, dia_semana);
            st.setString(3, (String) hora_fin);
            //Obtiene los resultados
            ResultSet rs = st.executeQuery();

            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Asignatura donde almacena esos datos obtenidos
            while (rs.next()) {
                int id_asignatura = rs.getInt("id_asignatura");
                asignatura.add(id_asignatura);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return asignatura;
    }
}
