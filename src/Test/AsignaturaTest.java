package Test;

import models.Alumno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsignaturaTest {

    @Test
    void getNombre() {
        Alumno instance = new Alumno("Lengua",2);
        instance.getNombre();
        System.out.println(instance.getNombre());
    }

    @Test
    void setNombre() {
        Alumno instancia2 = new Alumno("Filosofia",2);
        instancia2.setNombre("Computacion");
        System.out.println("setnombre()");
    }

    @Test
    void getId() {
        Alumno instance = new Alumno("Matematica",5);
        instance.getNombre();
        System.out.println(instance.getId());
    }

    @Test
    void setId() {
        Alumno instancia2 = new Alumno("Bases de datos",7);
        instancia2.setId(2);
        System.out.println("setid()");
    }
}