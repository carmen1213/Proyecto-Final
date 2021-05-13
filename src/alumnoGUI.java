
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static java.awt.Font.BOLD;

public class alumnoGUI extends JFrame {

    private JLabel titulop;
    private JLabel icon;
    private JButton notas;
    private JButton horario;
    private JLabel vacioderecha;
    private JLabel vacioizquierda;
    Font f = new Font("Monospaced", BOLD, 30);


    public alumnoGUI(Usuario user) {
        super("Alumno");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        this.getContentPane().setBackground(new Color(179, 253, 255 ));

        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        general.setBackground(Color.PINK);

        JPanel menu = new JPanel();
        this.getContentPane().setBackground(new Color(179, 253, 255 ));

        JMenuBar barraMenu = new JMenuBar();

        menu.add(barraMenu);


        JMenu expediente = new JMenu("Expediente");
        JMenu quejas = new JMenu("Quejas");
        JMenu cuestionarios = new JMenu("Cuestioarios");
        JMenu tareas = new JMenu("Tareas");


        barraMenu.add(expediente);
        barraMenu.add(quejas);
        barraMenu.add(cuestionarios);
        barraMenu.add(tareas);
        setJMenuBar(barraMenu);

        JPanel principal = new JPanel();
        principal.setLayout(new GridLayout(3, 1));
        principal.setBackground(new Color(179, 253, 255));

        JPanel titulo = new JPanel();
        titulo.setBackground(new Color(179, 253, 255 ));
        titulop = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html> ");
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);

        JPanel logo = new JPanel();
        logo.setBackground(new Color(179, 253, 255));
        icon = new JLabel();
        icon.setBackground(new Color(179, 253, 255));
        icon.setIcon(new ImageIcon("C:\\Users\\carma\\IdeaProjects\\Trabajo final\\imagenes\\alumno.jpg"));

        JPanel botones = new JPanel();
        botones.setBackground(new Color(179, 253, 255));
        botones.setLayout(new GridLayout(1,4));

        JPanel vacioiz = new JPanel();
        vacioiz.setBackground(new Color(179, 253, 255));
        vacioizquierda = new JLabel();
        vacioizquierda.setBackground(new Color(179, 253, 255));

        JPanel nota = new JPanel();
        nota.setLayout(new GridLayout(3,1));
        nota.setBackground(new Color(179, 253, 255));
        JLabel vacioarr = new JLabel();
        notas = new JButton("Notas");
        notas.addActionListener(new guardarnotas());
        JLabel vacioaba = new JLabel();

        JPanel vaciode = new JPanel();
        vaciode.setBackground(new Color(179, 253, 255));
        vacioderecha = new JLabel();
        vacioderecha.setBackground(new Color(179, 253, 255));

        JPanel Horario = new JPanel();
        Horario.setLayout(new GridLayout(3,1));
        Horario.setBackground(new Color(179, 253, 255));
        JLabel vacioar = new JLabel();
        horario = new JButton("Horario");
        horario.setSize(3,4);
        JLabel vacioab = new JLabel();


        vacioiz.add(vacioizquierda);
        nota.add(vacioarr);
        nota.add(notas);
        nota.add(vacioaba);
        vaciode.add(vacioderecha);
        Horario.add(vacioar);
        Horario.add(horario);
        Horario.add(vacioab);


        botones.add(nota);
        botones.add(vacioiz);
        botones.add(vaciode);
        botones.add(Horario);


        logo.add(icon);
        principal.add(titulo);
        principal.add(logo);
        principal.add(botones, BorderLayout.SOUTH);
        general.add(principal);
        add(general);

        setSize(700, 700);
        setVisible(true);
    }

    public static void main(Usuario user) {
        new alumnoGUI(user);

    }


    private class guardarnotas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Notas_alumnos notas_alumnos = new Notas_alumnos();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

