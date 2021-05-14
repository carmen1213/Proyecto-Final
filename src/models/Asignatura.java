package models;

public class Asignatura {

    //Variables para crear el objeto asignatura
    String nombre;
    int id;

    //Metodo que sirve para obtener el nombre de la asignatura ya creada
    public String getNombre() {
        return nombre;
    }

    //Metodo que permite cambiar el nombre de la asignatura ya creada anteriormente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo que sirve para obtener el identificador de la asignatura ya creada
    public int getId() {
        return id;
    }

    //Metodo que permite cambiar el identificador de la asignatura ya creada anteriormente
    public void setId(int id) {
        this.id = id;
    }

    //Creacion del constructor para definir que datos debe tener ese objeto
    public Asignatura(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
}
