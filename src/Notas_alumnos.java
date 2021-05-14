import Controladores.ControladorTablaNotas;
import Controladores.ControladorTablaProfesores;
import Controladores.Controlador_login;
import models.*;
import models.Notas;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Notas_alumnos  extends JFrame{
    private JTable jTableAlumnos;
    private ControladorTablaNotas controladorNotas = new ControladorTablaNotas();
    private ControladorTablaProfesores controladorProfesores = new ControladorTablaProfesores();
    private JComboBox asignatura;
    private JLabel titulop;
    private JButton guardar;
    private static Connection connecion;
    private Controlador_login controllogin = new Controlador_login();
    private Profesor id_profesor = controllogin.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText());
    private ArrayList<Asignatura> asignaturas = controladorProfesores.getAsignaturaProfesor(2);
    private UtilDateModel date = new UtilDateModel();

    public Notas_alumnos() throws SQLException {
        super("Listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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


        ArrayList<Notas> alumnosAsignatura = controladorNotas.getNotas(3);
        DefaultTableModel model = generarModeloTablaAlumno(alumnosAsignatura);

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


        jTableAlumnos.setBounds(30,40,200,300);
        JScrollPane scrollpane = new JScrollPane(jTableAlumnos);


        JPanel primer = new JPanel();
        primer.setLayout(new GridLayout(2,1));
        primer.setBackground(new Color(227, 247, 193));
        JPanel referencia = new JPanel();
        referencia.setBackground(new Color(227, 247, 193));
        referencia.add(new JLabel(" "));

        JPanel boton = new JPanel();
        boton.setBackground(new Color(227, 247, 193));
        boton.setLayout(new GridLayout(1,3));
        JLabel vacioar = new JLabel(" ");
        vacioar.setBackground(new Color(227, 247, 193));
        JLabel vacioab = new JLabel(" ");
        vacioab.setBackground(new Color(227, 247, 193));

        JPanel guarda = new JPanel();
        guarda.setLayout(new GridLayout(3,1));
        JLabel vacioarriba = new JLabel(" ");
        vacioar.setBackground(new Color(227, 247, 193));
        JLabel vacioabajo = new JLabel(" ");
        vacioab.setBackground(new Color(227, 247, 193));

        JPanel botones =new JPanel();
        botones.setBackground(new Color(227, 247, 193));
        JLabel vacioarr = new JLabel(" ");
        vacioar.setBackground(new Color(227, 247, 193));
        guarda.setBackground(new Color(227, 247, 193));

        guardar = new JButton("Guardar");

        JLabel vacioaba = new JLabel(" ");
        vacioab.setBackground(new Color(227, 247, 193));



        botones.add(vacioarr);
        botones.add(guardar);
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

        add(general,BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);

    }


    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Notas> nombresAlumnos) {

        String[] cols = {"Nombre Alumno", "Nombre Asignatura", "Notas"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i).getAlumno().getNombre(), nombresAlumnos.get(i).getAsignatura().getNombre(), nombresAlumnos.get(i).getNota()};
            model.addRow(data);
        }
        return model;
    }

    public static void main(String[] args) {
        try {
            Notas_alumnos notas_alumnos = new  Notas_alumnos();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void main()throws SQLException
    {
        Notas_alumnos tabla = new Notas_alumnos();
    }

    private class guardarinformaciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
