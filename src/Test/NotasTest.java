package Test;


import models.Alumno;
import models.Asignatura;
import models.Notas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotasTest {

    @Test
    void getAlumno() {
        Alumno alumno = new Alumno("pepe",0);
        Asignatura asignatura = new Asignatura("Matematicas",2);
        Notas instancia = new Notas(alumno,asignatura,10);
        System.out.println(instancia.getAlumno().getNombre());
        System.out.println(instancia.getAlumno().getId());
    }

    @Test
    void setAlumno() {
        Alumno alumno = new Alumno("pepe",0);
        Asignatura asignatura = new Asignatura("Matematicas",2);
        Notas instancia = new Notas(alumno,asignatura,10);
        alumno.setNombre("juan");
        instancia.setAlumno(alumno);
    }

    @Test
    void getAsignatura() {
        Alumno alumno = new Alumno("pepe",0);
        Asignatura asignatura = new Asignatura("Lengua",2);
        Notas instancia = new Notas(alumno,asignatura,10);
        System.out.println(instancia.getAsignatura().getNombre());
        System.out.println(instancia.getAsignatura().getId());
    }

    @Test
    void setAsignatura() {
        Alumno alumno = new Alumno("Juanita",0);
        Asignatura asignatura = new Asignatura("Sociales",2);
        Notas instancia = new Notas(alumno,asignatura,10);
        asignatura.setNombre("FOl");
        instancia.setAsignatura(asignatura);
    }

    @Test
    void getNota() {
        Alumno alumno = new Alumno("Luz",0);
        Asignatura asignatura = new Asignatura("Sociales",2);
        Notas instancia = new Notas(alumno,asignatura,3);
        System.out.println(instancia.getNota());
    }

    @Test
    void setNota() {
        Alumno alumno = new Alumno("Luz",0);
        Asignatura asignatura = new Asignatura("Sociales",2);
        Notas instancia = new Notas(alumno,asignatura,7);
        instancia.setNota(1);
    }

    @Test
    void testToString() {
        Alumno alumno = new Alumno("Luz",0);
        Asignatura asignatura = new Asignatura("Sociales",2);
        Notas instancia = new Notas(alumno,asignatura,7);
        System.out.println(instancia);
    }
}