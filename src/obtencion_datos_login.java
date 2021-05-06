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
        String consulta = "SELECT nombre_usuario, contraseña, tipo_usuario FROM login";
        try {
            PreparedStatement pt = conn.prepareStatement(consulta);
            ResultSet login = pt.executeQuery();
            while (login.next()){
                resultado.add(login.getString(1));
                resultado.add(login.getString(2));
                resultado.add(login.getString(3));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultado;
    }
}
