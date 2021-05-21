import BDutils.conexionbasedatos;
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
import java.sql.Statement;
import java.util.ArrayList;

public class Boletin_alumnos extends JFrame{
    private final JTable jTableAlumnos;
    private final ControladorTablaNotas controladorNotas = new ControladorTablaNotas();
    private final ControladorTablaProfesores controladorProfesores = new ControladorTablaProfesores();
    private JComboBox asignatura;
    private final JLabel titulop;
    private final JButton guardar;
    private static Connection connecion;
    private final Controlador_login controllogin = new Controlador_login();
    private final Profesor id_profesor = controllogin.getIdProfesor(inicio.usuario.getText(), inicio.contrase�a.getText());
    private final ArrayList<Asignatura> asignaturas = controladorProfesores.getAsignaturaProfesor(2);
    private final UtilDateModel date = new UtilDateModel();
    private static Connection conn;

    public Boletin_alumnos() throws SQLException {
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


        ArrayList<Alumno> alumnosAsignatura = controladorProfesores.getAlumnosxAsignaturaA(3);
        DefaultTableModel model = generarModeloTablaAlumno(alumnosAsignatura,asignaturas);

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
        guardar.addActionListener(new Guardar(this ));

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


    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Alumno> nombresAlumnos, ArrayList<Asignatura> asignaturas) {

        String[] cols = {"Nombre Alumno", "Nombre Asignatura", "Notas"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

            for (int j = 0; j < asignaturas.size(); j++) {
                Object[] data = {nombresAlumnos.get(j).getNombre(), asignaturas.get(j).getNombre()};
                model.addRow(data);


        }
        return model;
    }

    public static void main(String[] args) {
        try {
           Boletin_alumnos notas_alumnos = new Boletin_alumnos();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void main()throws SQLException
    {
        Boletin_alumnos tabla = new Boletin_alumnos();
    }

    private class guardarinformaciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private class Guardar implements ActionListener {
        private final Boletin_alumnos notas_alumnos;



        public Guardar(Boletin_alumnos notas_alumnos) {
            this.notas_alumnos = notas_alumnos;
        }

        public void actionPerformed(ActionEvent e) {

                {
                    conexionbasedatos conexion;
                    conexion = new conexionbasedatos();
                    conn = conexion.conectarMySQL();
                    Statement stmt = null;
                    try {
                        stmt = conn.createStatement();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    ArrayList<Asignatura> asignaturaid;

                    Object notas = null;
                    for (int i = 0; i < jTableAlumnos.getRowCount(); i++) {
                        notas = jTableAlumnos.getValueAt(i, 2);

                        System.out.println(notas);

                        try {

                                Object resultados = stmt.executeUpdate("INSERT INTO notas (notas,id_asignaturas,id_alumno) " + "VALUES('" + notas + "','" + asignaturas.get(i).getId() + "','" + 3 + "')");

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }

                }
            }
        }
    }