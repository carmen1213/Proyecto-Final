import Controladores.Controlador_horario;
import Interfaz.Metodos_repetitivos;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class horario extends JFrame {
    private Controlador_horario controlhorario = new Controlador_horario();

        horario(){
            super("Horario");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
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



            String[]horas = {"8:15:00-9:10:00","9:10:00-10:05:00","10:05:00-11:00:00","11:00:00-11:30:00","11:30:00-12:25:00","12:25:00-13:20:00","13:20:00-14:15:00"};
            String[] cols = {"Horario", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
            String[] hora_inicial =horas[0].split("-");
            String hora1 = hora_inicial[0];
            String hora2 = hora_inicial[1];
            String[][] horario_matriz = new String[7][7];


            for (int i = 0; i < 5; i++) {
                horario_matriz = new String[][]{{horas[0], controlhorario.getAsignatura(controlhorario.getasignaturas("8:15:00")).getNombre(), controlhorario.getAsignatura().get(3).getNombre(), controlhorario.getAsignatura().get(6).getNombre(), controlhorario.getAsignatura().get(1).getNombre(), controlhorario.getAsignatura().get(5).getNombre()}, {horas[1], controlhorario.getAsignatura().get(0).getNombre(), controlhorario.getAsignatura().get(4).getNombre(), controlhorario.getAsignatura().get(6).getNombre(), controlhorario.getAsignatura().get(1).getNombre(), controlhorario.getAsignatura().get(0).getNombre()}, {horas[2], controlhorario.getAsignatura().get(0).getNombre(), controlhorario.getAsignatura().get(5).getNombre(), controlhorario.getAsignatura().get(6).getNombre(), controlhorario.getAsignatura().get(1).getNombre(), controlhorario.getAsignatura().get(0).getNombre()}, {horas[3], "DESCANZO", "DESCANZO", "DESCANZO", "DESCANZO", "DESCANZO"}, {horas[4], controlhorario.getAsignatura().get(2).getNombre(), controlhorario.getAsignatura().get(5).getNombre(), controlhorario.getAsignatura().get(4).getNombre(), controlhorario.getAsignatura().get(0).getNombre(), controlhorario.getAsignatura().get(1).getNombre()}, {horas[5], controlhorario.getAsignatura().get(2).getNombre(), controlhorario.getAsignatura().get(5).getNombre(), controlhorario.getAsignatura().get(4).getNombre(), controlhorario.getAsignatura().get(0).getNombre(), controlhorario.getAsignatura().get(1).getNombre()}, {horas[6], controlhorario.getAsignatura().get(2).getNombre(), controlhorario.getAsignatura().get(5).getNombre(), controlhorario.getAsignatura().get(3).getNombre(), controlhorario.getAsignatura().get(0).getNombre(), controlhorario.getAsignatura().get(3).getNombre()}};
            }

            for (int k = 0; k < horario_matriz.length; k++) {
                for (int j = 0; j < horario_matriz[k].length; j++) {
                    System.out.print(horario_matriz[k][j] + " ");
                }
                System.out.println();
            }
            JTable jt=new JTable(horario_matriz,cols);
            jt.setBounds(30,40,200,300);
            JScrollPane sp=new JScrollPane(jt);
            jt.setBounds(30, 40, 200, 300);
            JScrollPane scrollpane = new JScrollPane(jt);


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

