package models;
/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */
public class Alumno {
    //Variables para crear el objeto alumno
    String nombre;
    int id;

    //Creacion del constructor para definir que datos debe tener ese objeto
    public Alumno(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;

    }

    //Metodo que sirve para obtener el nombre del alumno ya creado
    public String getNombre() {
        return nombre;
    }

    //Metodo que permite cambiar el nombre del alumno ya creado anteriormente
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodo que sirve para obtener el identificador del alumno ya creado
    public int getId() {
        return id;
    }
    //Metodo que permite cambiar el identificador del alumno ya creado anteriormente
    public void setId(int id) {
        this.id = id;
    }
}
