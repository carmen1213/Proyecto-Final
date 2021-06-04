package Test;

import models.Alumno;

class AlumnoTest {

    @org.junit.jupiter.api.Test
    void getNombre() {
        Alumno instance = new Alumno("Salva",2);
        instance.getNombre();
        System.out.println(instance.getNombre());
    }

    @org.junit.jupiter.api.Test
    void setNombre() {
        Alumno instancia2 = new Alumno("pepe",2);
        instancia2.setNombre("alma");
        System.out.println("setnombre()");
    }

    @org.junit.jupiter.api.Test
    void getId() {
        System.out.println("getid");
        Alumno testGetid = new Alumno("pepe",3);
        System.out.println(testGetid.getId());
    }

    @org.junit.jupiter.api.Test
    void setId() {
        Alumno instancia2 = new Alumno("Lucia",5);
        instancia2.setId(2);
        System.out.println("setnombre()");
    }
}