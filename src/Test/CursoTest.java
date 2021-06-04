package Test;

import models.Alumno;
import models.Curso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    @Test
    void getNombre_curso() {
        Curso instancia = new Curso("Economia","Pepe");
        instancia.getNombre_curso();
        System.out.println(instancia.getNombre_curso());
    }

    @Test
    void setNombre_curso() {
        Curso instancia = new Curso("Sociales","juan");
        instancia.setNombre_curso("Naturales");
        System.out.println("setNombre_curso()");
    }

    @Test
    void getNombre_alumno() {
        Curso instancia = new Curso("Salvador","Lula");
        instancia.getNombre_alumno();
        System.out.println(instancia.getNombre_alumno());
    }

    @Test
    void setNombre_alumno() {
        Curso instancia = new Curso("Arte","Juan");
        instancia.setNombre_alumno("Lucas");
        System.out.println("setNombre_alumno()");
    }
}