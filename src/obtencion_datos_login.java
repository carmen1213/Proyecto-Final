import models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class obtencion_datos_login {
    private static Connection conn;

    public obtencion_datos_login() {
        conexionbasedatos conexion;
        conexion = new conexionbasedatos();
        conn = conexion.conectarMySQL();
    }

    public ArrayList<String> getdatosdellogin(){
        ArrayList<String> resultado = new ArrayList<>();
        String consulta = "SELECT nombre_usuario, contraseña, tipo_usuario,nombre FROM login";
        try {
            PreparedStatement pt = conn.prepareStatement(consulta);
            ResultSet login = pt.executeQuery();
            while (login.next()){
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

    public Usuario iniciarSesion(String usuario, String contraseña) {
        String sql = "SELECT nombre, tipo_usuario FROM login WHERE nombre_usuario = ? AND contraseña = ?";
        try {
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1, usuario);
            pt.setString(2, contraseña);
            ResultSet login = pt.executeQuery();
            while (login.next()) {
                String nombreUsuario = login.getString(1);
                String tipoUsuario = login.getString(2);
                return new Usuario(nombreUsuario, tipoUsuario);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
