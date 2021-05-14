package Controladores;

import BDutils.conexionbasedatos;
import models.Profesor;
import models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */
public class Controlador_login {
    private static Connection conn;

    //Metodo para conectar la clase con la base de datos, accediendo con datos de conexion que se encuentran en la clase conexionbasedatos
    public Controlador_login() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    //Selecciona mediante una consulta a la base de datos, el nombre de los usuarios, la contraseña, el tipo de usuario (profesor,alumno,etc) y el nombre de ese usuairo de la base de datos

    /**
     * Metodo para la obtencion y almacenamiento de los datos de los usuarios
     * @return devuelve los datos obtenidos
     */
    public ArrayList<String> getdatosdellogin(){
        //Crea un array de tipo String para almacenar los diferentes datos
        ArrayList<String> resultado = new ArrayList<>();
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String consulta = "SELECT nombre_usuario, contraseña, tipo_usuario,nombre FROM login";
        try {

            PreparedStatement pt = conn.prepareStatement(consulta);
            ResultSet login = pt.executeQuery();
            while (login.next()){
                //Mientras que los resultados tengan datos, guarda los mismos en el array
                resultado.add(login.getString(1));
                resultado.add(login.getString(2));
                resultado.add(login.getString(3));
                resultado.add(login.getString(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }

    //Metodo que obtiene los datos de nombre de usuario y el tipo de usuario de la base de datos y pregunta a la persona los datos que ingresa en el login

    /**
     * Metodo que obtiene los datos correspondientes de la base de datos para poder iniciar seccion en la aplicacion
     * @param usuario Pide a la persona el usuario ingresado en el inicio
     * @param contraseña Pide a la persona la contraseña ingresado en el inicio
     * @return devuelve nulo si no encuentra resultados en la base de datos
     */
    public Usuario iniciarSesion(String usuario, String contraseña) {
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String sql = "SELECT nombre, tipo_usuario FROM login WHERE nombre_usuario = ? AND contraseña = ?";
        try {

            PreparedStatement pt = conn.prepareStatement(sql);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de usuario y contraseña que le envia la persona
            pt.setString(1, usuario);
            pt.setString(2, contraseña);
            ResultSet login = pt.executeQuery();
            while (login.next()) {
                //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Notas donde almacena esos datos obtenidos
                String nombreUsuario = login.getString(1);
                String tipoUsuario = login.getString(2);
                return new Usuario(nombreUsuario, tipoUsuario);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //Metodo que obtiene el identificador del profesor de la base de datos mediante una consulta
    /**
     * Metodo que obtiene de la tabla de profesor de la base de datos el identificador, comparandolo con las asignaturas que imparte el mismo
     * @param usuario Pide a la persona el usuario ingresado en el inicio
     * @param contraseña Pide a la persona la contraseña ingresado en el inicio
     * @return devuelve nulo si no encuentra resultados en la base de datos
     */
    public Profesor getIdProfesor(String usuario, String contraseña) {
        //Conecta con la base de datos y realiza a la misma la consulta correspondiente
        String sql = "SELECT id_profesor FROM profesor WHERE id_usuario IN(" +
                "SELECT id_login FROM login WHERE nombre_usuario = ? AND contraseña = ?" +
                ");";
        try {
            PreparedStatement pt = conn.prepareStatement(sql);
            //Ingresa el dato faltante en la consulta, reemplazando el signo de pregunta por el dato de usuario y contraseña que le envia la persona
            pt.setString(1, usuario);
            pt.setString(2, contraseña);
            ResultSet login = pt.executeQuery();
            //Mientras que los resultados tengan datos, guarda los mismos en las diferentes variables y crea un objeto Notas donde almacena esos datos obtenidos
            while (login.next()) {

                int id_profesor = login.getInt(1);
                return new Profesor(usuario, id_profesor);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
