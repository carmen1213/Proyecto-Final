package models;

public class Horario {
String hora_inicio;
int dia_semana;
int asignatura;
String hora_fin;

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Horario(String hora_inicio, int dia_semana, int asignatura, String hora_fin) {
        this.hora_inicio = hora_inicio;
        this.dia_semana = dia_semana;
        this.asignatura = asignatura;
        this.hora_fin = hora_fin;
    }
}
