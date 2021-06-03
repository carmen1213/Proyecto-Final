package models;

public class Usuario {

    //Variables para crear el objeto Usuario
    String nombre;
    String tipoUsuario;

    /**
     * crea un constructor con los parametros
     * @param nombre crea los parametros
     * @param tipoUsuario crea los parametros
     */
    //Creacion del constructor para definir que datos debe tener ese objeto
    public Usuario(String nombre, String tipoUsuario) {
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    /**
     *
     * @return devuelve el nombre del usuario
     */
    //Metodo que sirve para obtener el nombre del usuario ya creado
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre modifica el nombre del usuario
     */

    //Metodo que permite cambiar el nombre del usuario ya creado anteriormente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return devuelve el tipo de usuario
     */
    //Metodo que sirve para obtener el tipo de usuario ya creado
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     *
     * @param tipoUsuario modifica el tipo de usuario
     */
    //Metodo que permite cambiar el tipo de usuario ya creado anteriormente
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    /**
     *
     * @return devuelve los datos en el formato para que si se quieren se impriman
     */
    //Metodo que devuelve los diferentes datos del objeto correspondiente
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
