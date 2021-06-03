package models;
/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */
public class Notas {

    //Variables para crear el objeto notas, de tipo alumno son los datos que obtiene del objeto ya creado Alumno y de tipo asignatura son los datos que obtiene del objeto ya creado asignatura
    Alumno alumno;
    Asignatura asignatura;
    double nota;

    /**
     * crea un constructor con los parametros
     * @param alumno crea los parametros
     * @param asignatura crea los parametros
     * @param nota crea los parametros
     */
    //Creacion del constructor para definir que datos debe tener ese objeto
    public Notas(Alumno alumno, Asignatura asignatura, double nota) {
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    /**
     *
     * @return devuelve el alumno
     */
    //Metodo que sirve para obtener del objeto ya creado en la clase Alumno, su respectivo nombre
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     *
     * @param alumno modifica el alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     *
     * @return devuelve la asignatura
     */
    //Metodo que sirve para obtener del objeto ya creado en la clase Asignatura, su respectivo nombre
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     *
     * @param asignatura modifica la asignatura
     */
    //Metodo que permite cambiar el nombre del alumno ya creado anteriormente
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     *
     * @return devuelve la nota
     */
    //Metodo que sirve para obtener el valor de la nota ya creada
    public double getNota() {
        return nota;
    }

    /**
     *
     * @param nota modifica la nota
     */
    //Metodo que permite cambiar el valor de la nota ya creada anteriormente
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     *
     * @return devuelve los datos en el formato para que si se quieren se impriman
     */
    //Metodo que devuelve los diferentes datos del objeto correspondiente
    @Override
    public String toString() {
        return "Notas{" +
                "alumno=" + alumno +
                ", asignatura=" + asignatura +
                ", nota=" + nota +
                '}';
    }
}
