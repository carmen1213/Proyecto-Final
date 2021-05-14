package models;

public class Usuario {

    //Variables para crear el objeto Usuario
    String nombre;
    String tipoUsuario;

    //Creacion del constructor para definir que datos debe tener ese objeto
    public Usuario(String nombre, String tipoUsuario) {
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    //Metodo que sirve para obtener el nombre del usuario ya creado
    public String getNombre() {
        return nombre;
    }

    //Metodo que permite cambiar el nombre del usuario ya creado anteriormente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo que sirve para obtener el tipo de usuario ya creado
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    //Metodo que permite cambiar el tipo de usuario ya creado anteriormente
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    //Metodo que devuelve los diferentes datos del objeto correspondiente
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
