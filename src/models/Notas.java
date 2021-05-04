package models;

public class Notas {
    int nota;
    double promedio;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Notas(int nota, double promedio) {
        this.nota = nota;
        this.promedio = promedio;
    }
}
