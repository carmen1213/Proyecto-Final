import Controladores.ControladorNotasALumnos;
import Controladores.ControladorTablaNotas;
import Controladores.ControladorTablaProfesores;
import Controladores.Controlador_login;
import models.Alumno;
import models.Asignatura;
import models.Notas;
import models.Profesor;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Alumnos_notas extends JFrame {
    private JTable jTableAlumnos;
    private ControladorTablaNotas controladorNotas = new ControladorTablaNotas();
    private ControladorTablaProfesores controladorProfesores = new ControladorTablaProfesores();
    private ControladorNotasALumnos controladorTablanotasAlumnos = new ControladorNotasALumnos();
    private JLabel titulop;
    private Controlador_login controllogin = new Controlador_login();
    private ArrayList<Integer> notitas = controladorTablanotasAlumnos.getNotasalumnos(controllogin.getIdalumno(inicio.usuario.getText(),inicio.contraseña.getText()).getId());


    public Alumnos_notas() throws SQLException {
        super("Listas");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(227, 247, 193));


        JPanel general = new JPanel();
        general.setLayout(new GridLayout(5, 1));
        general.setBackground(new Color(227, 247, 193));

        JPanel titulo = new JPanel();
        titulo.setBackground(new Color(227, 247, 193));
        titulop = new JLabel("Bienvenido");
        titulo.add(titulop);

        JPanel opciones = new JPanel();
        opciones.setBackground(new Color(227, 247, 193));
        opciones.setLayout(new GridLayout(1, 4, 12, 0));
        opciones.add(new JLabel(" "));
        opciones.add(new JLabel(" "));

        ArrayList<Asignatura> asignaturas = controladorTablanotasAlumnos.getasignaturas(inicio.usuario.getText(),inicio.contraseña.getText(),3);
        System.out.println(asignaturas);
        String alumnosAsignatura = controllogin.getIdalumno(inicio.usuario.getText(),inicio.contraseña.getText()).getNombre();
        System.out.println(alumnosAsignatura);
        DefaultTableModel model = generarModeloTablaNotasProfesor(alumnosAsignatura, asignaturas, notitas);

        jTableAlumnos = new JTable(model) {
            //private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    default:
                    case 2:
                        return String.class;

                }
            }
        };


        jTableAlumnos.setBounds(30, 40, 200, 300);
        JScrollPane scrollpane = new JScrollPane(jTableAlumnos);

        JPanel primer = new JPanel();
        primer.setLayout(new GridLayout(2, 1));
        primer.setBackground(new Color(227, 247, 193));
        JPanel referencia = new JPanel();
        referencia.setBackground(new Color(227, 247, 193));
        referencia.add(new JLabel(" "));

        JPanel boton = new JPanel();
        boton.setBackground(new Color(227, 247, 193));
        boton.setLayout(new GridLayout(1, 3));
        JLabel vacioar = new JLabel(" ");
        vacioar.setBackground(new Color(227, 247, 193));
        JLabel vacioab = new JLabel(" ");
        vacioab.setBackground(new Color(227, 247, 193));

        JPanel guarda = new JPanel();
        guarda.setLayout(new GridLayout(3, 1));
        JLabel vacioarriba = new JLabel(" ");
        vacioar.setBackground(new Color(227, 247, 193));
        JLabel vacioabajo = new JLabel(" ");
        vacioab.setBackground(new Color(227, 247, 193));

        JPanel botones = new JPanel();
        botones.setBackground(new Color(227, 247, 193));
        JLabel vacioarr = new JLabel(" ");
        vacioar.setBackground(new Color(227, 247, 193));
        guarda.setBackground(new Color(227, 247, 193));


        JLabel vacioaba = new JLabel(" ");
        vacioab.setBackground(new Color(227, 247, 193));


        botones.add(vacioarr);
        botones.add(vacioaba);

        guarda.add(vacioarriba);
        guarda.add(botones);
        guarda.add(vacioabajo);

        boton.add(vacioar);
        boton.add(vacioab);
        boton.add(guarda);


        primer.add(referencia);

        general.add(titulo);
        general.add(opciones);
        general.add(scrollpane);
        general.add(primer);
        general.add(boton);

        add(general, BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);

    }

    private DefaultTableModel generarModeloTablaNotasProfesor(String alumnosAsignatura, ArrayList<Asignatura> asignaturas, ArrayList<Integer> notitas) {
        String[] cols = {"Nombre Alumno", "Nombre Asignatura", "Notas"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        //Ciclo para ingresar los nombres de los alumnos.


            for (int k = 0; k < notitas.size(); k++) {
                    Object[] data = {alumnosAsignatura, asignaturas.get(k).getNombre(),notitas.get(k) };
                    model.addRow(data);
        }

        return model;
    }
}

