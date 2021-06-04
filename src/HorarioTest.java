package Test;

import models.Horario;
import org.junit.jupiter.api.Test;

class HorarioTest {

    @Test
    void getHora_inicio() {
        Horario instacia = new Horario("8:20:20",3,2,"13:15:00");
        System.out.println(instacia.getHora_inicio());
    }

    @Test
    void setHora_inicio() {
        Horario instacia = new Horario("9:20:20",1,2,"13:20:00");
        instacia.setHora_inicio("5:15:00");
        System.out.println("setHora_inicio()");
    }

    @Test
    void getDia_semana() {
        Horario instacia = new Horario("8:20:00",5,2,"13:15:50");
        System.out.println(instacia.getDia_semana());
    }

    @Test
    void setDia_semana() {
        Horario instacia = new Horario("10:20:20",3,6,"13:15:00");
        instacia.setDia_semana(2);
    }

    @Test
    void getAsignatura() {
        Horario instacia = new Horario("8:20:20",3,6,"13:15:00");
        System.out.println(instacia.getAsignatura());
    }

    @Test
    void setAsignatura() {
        Horario instacia = new Horario("8:20:20",3,2,"3:15:00");
        instacia.setAsignatura(10);
        System.out.println("setAsignatura()");
    }

    @Test
    void getHora_fin() {
        Horario instacia = new Horario("8:20:20",3,2,"13:50:00");
        System.out.println(instacia.getHora_fin());
    }

    @Test
    void setHora_fin() {
        Horario instacia = new Horario("8:20:20",3,2,"10:15:00");
        instacia.setHora_fin("7:15:00");
        System.out.println("setHora_fin()");
    }
}