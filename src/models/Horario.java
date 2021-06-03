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

    /**
     *
     * @return devuelve la hora de inicio
     */
    //Metodo que sirve para obtener la hora de inicio del objeto horario ya creado
    public String getHora_inicio() {
        return hora_inicio;
    }

    /**
     *
     * @param hora_inicio modifica la hora de inicio
     */
    //Metodo que permite cambiar la hora de inicio ya creada anteriormente
    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    /**
     *
     * @return devuelve el dia de la semana
     */
    //Metodo que sirve para obtener el dia de la semana del objeto horario ya creado
    public int getDia_semana() {
        return dia_semana;
    }

    /**
     *
     * @param dia_semana modifica el dia de la semana
     */

    //Metodo que permite cambiar el dia de la semana ya creada anteriormente
    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }

    /**
     *
     * @return devuelve el nombre de la asignatura
     */
    //Metodo que sirve para obtener la asignatura del objeto horario ya creado
    public int getAsignatura() {
        return asignatura;
    }

    /**
     *
     * @param asignatura modifica el nombre de la asignatura
     */
    //Metodo que permite cambiar la asignatura ya creada anteriormente
    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    /**
     *
     * @return  devuelve la hora fin
     */
    //Metodo que sirve para obtener la hora de fin del objeto horario ya creado
    public String getHora_fin() {
        return hora_fin;
    }

    /**
     *
     * @param hora_fin modifica la hora fin
     */
    //Metodo que permite cambiar la hora fin ya creada anteriormente
    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }


    /**
     * crea un constructor con los parametros
     * @param hora_inicio crea los parametros
     * @param dia_semana crea los parametros
     * @param asignatura crea los parametros
     * @param hora_fin crea los parametros
     */
    //Creacion del constructor para definir que datos debe tener ese objeto
    public Horario(String hora_inicio, int dia_semana, int asignatura, String hora_fin) {
        this.hora_inicio = hora_inicio;
        this.dia_semana = dia_semana;
        this.asignatura = asignatura;
        this.hora_fin = hora_fin;
    }
}
