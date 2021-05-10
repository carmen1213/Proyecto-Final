package models;

public class Notas {
    String nombre_alumno;
    String asignatura;


    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Notas(String nombre_alumno, String asignatura) {
        this.nombre_alumno = nombre_alumno;
        this.asignatura = asignatura;
    }
}
