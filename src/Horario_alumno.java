import BDutils.*;
import Controladores.ControladorTablaProfesores;
import Controladores.Controlador_horario;
import Controladores.Controlador_login;
import models.*;
import models.Alumno;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Horario_alumno extends JFrame {

    private JTable jTableAlumnos;
    private ControladorTablaProfesores controladorProfesores = new ControladorTablaProfesores();
    private Controlador_login controllogin = new Controlador_login();
    private JComboBox asignatura;
    private JLabel titulop;
    private JButton guardar;
    private JButton modificar;
    private static Connection conn;
    private Controlador_horario controlhorario = new Controlador_horario();
   // private Usuario user = control.iniciarSesion(inicio.usuario.getText(), inicio.contraseña.getText());
   // private Profesor id_profesor = control.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText());
//    private ArrayList<Asignatura> asignaturas = controladorProfesores.getAsignaturaProfesor(controllogin.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText()).getId_profesor());
    private UtilDateModel date = new UtilDateModel();

    public Horario_alumno() throws SQLException {
        super("Listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(227, 247, 193));


        JPanel general = new JPanel();
        general.setLayout(new GridLayout(4, 1));
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


        JPanel combo = new JPanel();
        combo.setLayout(new GridLayout(3, 1));
        combo.setBackground(new Color(227, 247, 193));


      ArrayList<Horario> alumnosAsignatura = controlhorario.getAsignaturas(1,"8:15:00","11:00:00");
      DefaultTableModel model = generarModeloTablaAlumno(alumnosAsignatura);

        jTableAlumnos = new JTable(model) {
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



        general.add(titulo);
        general.add(opciones);
        general.add(scrollpane);
        general.add(primer);

        add(general,BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);

    }


    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Horario> nombresAlumnos) {

        String[] cols = {"Horario", "Lunes","Martes","Miercoles","Jueves","Viernes"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (int i = 0; i < 5; i++) {
            Object[] data = { nombresAlumnos.get(i).getAsignatura()};
            model.addRow(data);
        }
        return model;
    }

    public static void main()throws SQLException
    {
        Horario_alumno horario = new Horario_alumno();
    }

    public static void main(String[] args) {
        try {
            new  Horario_alumno();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    }
