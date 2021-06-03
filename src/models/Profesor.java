package models;

public class Profesor {

    //Variables para crear el objeto Profesor
    String nombre;
    int id_profesor;

    /**
     * crea un constructor con los parametros
     * @param nombre crea los parametros
     * @param id_profesor crea los parametros
     */
    //Creacion del constructor para definir que datos debe tener ese objeto
    public Profesor(String nombre, int id_profesor) {
        this.nombre = nombre;
        this.id_profesor = id_profesor;
    }

    /**
     *
     * @return devuelve el nombre del profesor
     */
    //Metodo que sirve para obtener el nombre del profesor ya creado
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre Modifica el nombre
     */
    //Metodo que permite cambiar el nombre del profesor ya creado anteriormente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return devuelve el identificador del profesor
     */
    //Metodo que sirve para obtener el identificador del profesor ya creado
    public int getId_profesor() {
        return id_profesor;
    }

    /**
     *
     * @param id_profesor modifica el identificador del profesor
     */
    //Metodo que permite cambiar el identificador del profesor ya creado anteriormente
    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
}
