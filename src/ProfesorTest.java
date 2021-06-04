package Test;

import models.Profesor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfesorTest {

    @Test
    void getNombre() {
        Profesor instancia = new Profesor("Ivan",0);
        System.out.println(instancia.getNombre());
    }

    @Test
    void setNombre() {
        Profesor instancia = new Profesor("Ivan",0);
        instancia.setNombre("Laura");
    }

    @Test
    void getId_profesor() {
        Profesor instancia = new Profesor("Ivan",10);
        System.out.println(instancia.getId_profesor());
    }

    @Test
    void setId_profesor() {
        Profesor instancia = new Profesor("Ivan",2);
        instancia.setId_profesor(8);
    }
}