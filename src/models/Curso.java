package models;

public class Curso {

    //Variables para crear el objeto curso
    String nombre_curso;
    String nombre_alumno;

    //Metodo que sirve para obtener el nombre del curso ya creado
    public String getNombre_curso() {
        return nombre_curso;
    }
    //Metodo que permite cambiar el nombre del curso ya creado anteriormente
    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    //Metodo que sirve para obtener el nombre del alumno ya creado
    public String getNombre_alumno() {
        return nombre_alumno;
    }
    //Metodo que permite cambiar el nombre del alumno ya creado anteriormente
    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    //Creacion del constructor para definir que datos debe tener ese objeto
    public Curso(String nombre_curso, String nombre_alumno) {
        this.nombre_curso = nombre_curso;
        this.nombre_alumno = nombre_alumno;
    }
}
