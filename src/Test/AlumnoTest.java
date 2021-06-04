package Test;

import models.Alumno;

class AlumnoTest {

    @org.junit.jupiter.api.Test
    void getNombre() {
        Alumno instancia = new Alumno("Salva",2);
        instancia.getNombre();
        System.out.println(instancia.getNombre());
    }

    @org.junit.jupiter.api.Test
    void setNombre() {
        Alumno instancia = new Alumno("pepe",2);
        instancia.setNombre("alma");
        System.out.println("setnombre()");
    }

    @org.junit.jupiter.api.Test
    void getId() {
        Alumno testGetid = new Alumno("pepe",3);
        System.out.println(testGetid.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {
        Alumno instancia = new Alumno("Lucia",5);
        instancia.setId(2);
        System.out.println("setnombre()");
    }
}