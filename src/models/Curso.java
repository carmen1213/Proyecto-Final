package models;

public class Curso {
    String nombre_curso;
    String nombre_alumno;

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public Curso(String nombre_curso, String nombre_alumno) {
        this.nombre_curso = nombre_curso;
        this.nombre_alumno = nombre_alumno;
    }
}
