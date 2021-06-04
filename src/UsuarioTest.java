package Test;

import models.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void getNombre() {
        Usuario instancia = new Usuario("Laura","Profesor");
        System.out.println(instancia.getNombre());
    }

    @Test
    void setNombre() {
        Usuario instancia = new Usuario("Laura","Profesor");
        instancia.setNombre("Juan");
    }

    @Test
    void getTipoUsuario() {
        Usuario instancia = new Usuario("Laura","Alumno");
        System.out.println(instancia.getTipoUsuario());
    }

    @Test
    void setTipoUsuario() {
        Usuario instancia = new Usuario("Laura","Alumno");
        instancia.setTipoUsuario("Profesor");
    }

    @Test
    void testToString() {
        Usuario instancia = new Usuario("Laura","Profesor");
        System.out.println(instancia);
    }
}