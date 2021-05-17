package models;

public class Notas {
    Alumno alumno;
    Asignatura asignatura;
    double nota;
    public Notas(Alumno alumno, Asignatura asignatura, double nota) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "alumno=" + alumno +
                ", asignatura=" + asignatura +
                ", nota=" + nota +
                '}';
    }
}
