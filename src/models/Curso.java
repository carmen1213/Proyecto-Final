package models;

public class Curso {

    //Variables para crear el objeto curso
    String nombre_curso;
    String nombre_alumno;

    /**
     *
     * @return devuelve el nombre del curso
     */
    //Metodo que sirve para obtener el nombre del curso ya creado
    public String getNombre_curso() {
        return nombre_curso;
    }

    /**
     *
     * @param nombre_curso modifica el nombre del curso
     */
    //Metodo que permite cambiar el nombre del curso ya creado anteriormente
    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    /**
     *
     * @return devuelve el nombre del alumno
     */
    //Metodo que sirve para obtener el nombre del alumno ya creado
    public String getNombre_alumno() {
        return nombre_alumno;
    }

    /**
     *
     * @param nombre_alumno modifica el nombre del alumno
     */
    //Metodo que permite cambiar el nombre del alumno ya creado anteriormente
    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    /**
     *  crea un constructor con los parametros
     * @param nombre_curso crea los parametros
     * @param nombre_alumno crea los parametros
     */
    //Creacion del constructor para definir que datos debe tener ese objeto
    public Curso(String nombre_curso, String nombre_alumno) {
        this.nombre_curso = nombre_curso;
        this.nombre_alumno = nombre_alumno;
    }
}
