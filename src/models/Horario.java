package models;
/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class Horario {
    //Variables para crear el objeto Horario
String hora_inicio;
int dia_semana;
int asignatura;
String hora_fin;

    //Metodo que sirve para obtener la hora de inicio del objeto horario ya creado
    public String getHora_inicio() {
        return hora_inicio;
    }
    //Metodo que permite cambiar la hora de inicio ya creada anteriormente
    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    //Metodo que sirve para obtener el dia de la semana del objeto horario ya creado
    public int getDia_semana() {
        return dia_semana;
    }
    //Metodo que permite cambiar el dia de la semana ya creada anteriormente
    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }
    //Metodo que sirve para obtener la asignatura del objeto horario ya creado
    public int getAsignatura() {
        return asignatura;
    }
    //Metodo que permite cambiar la asignatura ya creada anteriormente
    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }
    //Metodo que sirve para obtener la hora de fin del objeto horario ya creado
    public String getHora_fin() {
        return hora_fin;
    }
    //Metodo que permite cambiar la hora fin ya creada anteriormente
    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    //Creacion del constructor para definir que datos debe tener ese objeto
    public Horario(String hora_inicio, int dia_semana, int asignatura, String hora_fin) {
        this.hora_inicio = hora_inicio;
        this.dia_semana = dia_semana;
        this.asignatura = asignatura;
        this.hora_fin = hora_fin;
    }
}
