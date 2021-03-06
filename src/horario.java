import Controladores.Controlador_horario;
import Interfaz.Metodos_repetitivos;

import javax.swing.*;
import java.awt.*;

public class horario extends JFrame {
    //Llama al controlador del horario para poder despues hacer las consultas correspondientes a la base de datos
    private final Controlador_horario controlhorario = new Controlador_horario();


    horario() {
        super("Horario");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(227, 247, 193));


        JPanel general = new JPanel();
        general.setLayout(new GridLayout(4, 1));
        general.setBackground(new Color(227, 247, 193));


        JPanel opciones = new JPanel();
        opciones.setBackground(new Color(227, 247, 193));
        opciones.setLayout(new GridLayout(1, 4, 12, 0));
        opciones.add(new JLabel(" "));
        opciones.add(new JLabel(" "));


        JPanel combo = new JPanel();
        combo.setLayout(new GridLayout(3, 1));
        combo.setBackground(new Color(227, 247, 193));

        //Crea un array de tipo Strings con los diferentes horarios de las clases
        String[] horas = {"8:15:00-9:10:00", "9:10:00-10:05:00", "10:05:00-11:00:00", "11:00:00-11:30:00", "11:30:00-12:25:00", "12:25:00-13:20:00", "13:20:00-14:15:00"};
        //Crea un array con las diferentes titulos de las columnas que iran en la tabla de la interfaz
        String[] cols = {"Horario", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        //Crea un array de dos dimenciones para almacenar los datos de las asignaturas con sus respectivos horarios
        String[][] horario_matriz = new String[7][7];

        //Almacena en el array de dos dimensiones los diferentes datos de las asignaturas que obtiene de la base de datos
        for (int i = 0; i < 5; i++) {
            horario_matriz = new String[][]{{horas[0], controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(3).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(6).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(1).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(5).getNombre()}, {horas[1], controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(4).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(6).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(1).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre()}, {horas[2], controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(5).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(6).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(1).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre()}, {horas[3], "DESCANSO", "DESCANSO", "DESCANSO", "DESCANSO", "DESCANSO"}, {horas[4], controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(2).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(5).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(4).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(1).getNombre()}, {horas[5], controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(2).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(5).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(4).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(1).getNombre()}, {horas[6], controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(2).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(5).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(3).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(0).getNombre(), controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).get(3).getNombre()}};
        }

        JTable tabla_horario = new JTable(horario_matriz, cols);
        tabla_horario.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(tabla_horario);
        tabla_horario.setBounds(30, 40, 200, 300);
        JScrollPane scrollpane = new JScrollPane(tabla_horario);


        JPanel primer = new JPanel();
        primer.setLayout(new GridLayout(2, 1));
        primer.setBackground(new Color(227, 247, 193));
        JPanel referencia = new JPanel();
        referencia.setBackground(new Color(227, 247, 193));
        referencia.add(new JLabel(" "));


        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 3));
        botones.setBackground(new Color(227, 247, 193));
        botones.add(new JLabel());
        botones.add(new JLabel());
        JPanel guardarm = new JPanel();
        guardarm.setBackground(new Color(227, 247, 193));


        botones.add(guardarm);
        primer.add(referencia);
        primer.add(botones);


        general.add(Metodos_repetitivos.Titulo());
        general.add(opciones);
        general.add(scrollpane);
        general.add(primer);

        add(general, BorderLayout.CENTER);


        setSize(900, 530);
        setVisible(true);
    }
}

