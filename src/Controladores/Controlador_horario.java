package Controladores;

import BDutils.conexionbasedatos;
import models.Asignatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */
public class Controlador_horario {
    private static Connection conn;

    /**
     * Metodo para conectarse a la base de datos
     */

    //Metodo para conectar la clase con la base de datos, accediendo con datos de conexion que se encuentran en la clase conexionbasedatos
    public Controlador_horario() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }
    //Selecciona mediante una consulta a la base de datos, el nombre de las asignaturas de la base de datos

    /**
     * Pide primero el id de la asignatura para su utilizacion y a continuacion realiza una consulta a la base de datos para obtener los nombres de las asignaturas  que tengan ese id
     * @param id_asignatura parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return Devuelve un objeto asignatura con los nombres de las asignaturas obt
     */
    public Asignatura getnombre_asignatura(int id_asignatura) {
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

    /**
     *Pide primero para usar el metodo la hora de inicio de la asignatura y el dia de la semana. Para asi realizar una consulta a la base de datos obteniendo asi el nombre de las asignaturas que cumplen con esos parametros
     * @param horario parametro que despues se utiliza para realizar la consulta a la base de datos
     * @param dia_semana parametro que despues se utiliza para realizar la consulta a la base de datos
     * @return devuelve un int con los diferentes
     */
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
                return id_asignatura;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    /**
     *Pide primero para usar el metodo los datos obtenidos anteriormente. Para asi realizar una consulta a la base de datos obteniendo asi los nombre de las asignaturas que cumplen con esos parametros
     * @return Devuelve un array de objetos asigatura con los datos obtenidos
     * @param getasignaturas Pide los resultados obtenidos en el metodo anterior para poder realizar la consulta deseada
     */
    public ArrayList<Asignatura> getAsignatura(int getasignaturas) {
        ArrayList<Asignatura> asignatura = new ArrayList<Asignatura>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String SQL = "Select nombre, id_asignatura FROM view_name";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
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

    /**
     *Pide primero para usar el metodo la hora de inicio de la asignatura. Para asi realizar una consulta a la base de datos obteniendo asi el identificador de las asignaturas que cumplen con esos parametros
     * @param hora_incio Pide la hora de inicio de la asignatura que se desea obtener su identificador.
     * @return devuelve un String con los identifiadores de las asignaturas
     */
    public int getasignaturas(String hora_incio) {
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

    /**
     *Pide primero para usar el metodo el identificador de la asignatura. Para asi realizar una consulta a la base de datos obteniendo asi la hora de inicio y hora de fin de esa asignatura.
     * @param id_asignatura Pide el identificador  de la asignatura que se desea obtener su hora de inicio y su hora fin.
     * @return devuelve una lista con los diferentes horarios
     */
    public ArrayList<String> gethorariosAsignatura(int id_asignatura) {
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

    /**
     *Pide primero para usar el metodo el objeto creado anteriormente con la hora de inicio, el dia de la semana que se desee obtener los datos y el objetoc con las horas fin. Para asi realizar una consulta a la base de datos obteniendo asi el identificador que cumple con esos parametros.
     * @param hora_incio pide el objeto anteriormente creado con las horas de inicio, para poder realizar las consultas
     * @param dia_semana pide el dia de las semana, para realizar correctamente la consulta
     * @param hora_fin pide la hora fin, para poder realizar correctamente la consulta
     * @return devuelve una lista con los diferentes identificadores
     */
    public ArrayList<Integer> getidAsignatua_horario(Object hora_incio, String  dia_semana, Object hora_fin) {
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
