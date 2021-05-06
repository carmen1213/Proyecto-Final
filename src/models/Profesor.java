package models;

public class Profesor {
    String nombre;
    int id_profesor;

    public Profesor(String nombre, int id_profesor) {
        this.nombre = nombre;
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
}
