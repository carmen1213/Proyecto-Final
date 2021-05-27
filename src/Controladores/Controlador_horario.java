package Controladores;

import BDutils.conexionbasedatos;
import models.Curso;
import models.Horario;

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

   public ArrayList <Horario> getAsignaturas(int dia, String hora_inicio, String hora_fin){
        ArrayList<Horario> resultado = new ArrayList<Horario>();

    String SQL = "SELECT id_asignatura FROM horario WHERE dia_semana = ? AND hora_inicio = ? AND hora_fin = ?";
    try {
        PreparedStatement st = conn.prepareStatement(SQL);
        st.setString(2, hora_inicio);
        st.setString(3,hora_fin);
        st.setInt(1,dia);
        ResultSet alumnosAsignatura = st.executeQuery();
        while (alumnosAsignatura.next()){
            int id_asignatura = alumnosAsignatura.getInt(1);

            resultado.add(new Horario(hora_inicio,dia,id_asignatura,hora_fin));
            System.out.println(resultado);
        }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
        return null;
}

    public static void main(String[] args) {
        String <Horario> horario = new Horario("8:15:00",2,1,"11:00:00");
        System.out.println(H);
    }
}
