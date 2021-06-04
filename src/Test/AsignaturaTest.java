package Test;

import models.Alumno;
import models.Asignatura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsignaturaTest {

    @Test
    void getNombre() {
        Asignatura instancia = new Asignatura("Lengua",2);
        instancia.getNombre();
        System.out.println(instancia.getNombre());
    }

    @Test
    void setNombre() {
        Asignatura instancia = new Asignatura("Filosofia",2);
        instancia.setNombre("Computacion");
        System.out.println("setnombre()");
    }

    @Test
    void getId() {
        Asignatura instancia = new Asignatura("Matematica",5);
        instancia.getNombre();
        System.out.println(instancia.getId());
    }

    @Test
    void setId() {
        Asignatura instancia = new Asignatura("Bases de datos",7);
        instancia.setId(2);
        System.out.println("setid()");
    }
}