package models;

public class Asignatura {

    //Variables para crear el objeto asignatura
    String nombre;
    int id;

    /**
     *
     * @return devuelve el nombre de las asignaturas
     */
    //Metodo que sirve para obtener el nombre de la asignatura ya creada
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre modifica el nombre de las asignaturas
     */

    //Metodo que permite cambiar el nombre de la asignatura ya creada anteriormente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return devuelve el id de las asignaturas
     */
    //Metodo que sirve para obtener el identificador de la asignatura ya creada
    public int getId() {
        return id;
    }

    /**
     *
     * @param id modifica el id de las asignaturas
     */
    //Metodo que permite cambiar el identificador de la asignatura ya creada anteriormente
    public void setId(int id) {
        this.id = id;
    }

    /**
     *  crea un constructor con los parametros
     * @param nombre crea los parametros
     * @param id crea los parametros
     */
    //Creacion del constructor para definir que datos debe tener ese objeto
    public Asignatura(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
}
