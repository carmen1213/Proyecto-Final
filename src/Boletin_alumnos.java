import BDutils.conexionbasedatos;
import Controladores.ControladorTablaNotas;
import Controladores.ControladorTablaProfesores;
import Controladores.Controlador_login;
import Interfaz.Metodos_repetitivos;
import models.Alumno;
import models.Asignatura;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Boletin_alumnos extends JFrame {

    private JTable jTableAlumnos;
    private ControladorTablaNotas controladorNotas = new ControladorTablaNotas();
    private ControladorTablaProfesores controladorProfesores = new ControladorTablaProfesores();
    private JButton guardar;
    private Controlador_login controllogin = new Controlador_login();
    private ArrayList<Asignatura> asignaturas = controladorProfesores.getAsignaturaProfesor(controllogin.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText()).getId_profesor());
    private static Connection conn;


    public Boletin_alumnos() throws SQLException {
        super("Listas");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(227, 247, 193));


        JPanel general = new JPanel();
        general.setLayout(new GridLayout(5, 1));
        general.setBackground(new Color(227, 247, 193));


        JPanel opciones = new JPanel();
        opciones.setBackground(new Color(227, 247, 193));
        opciones.setLayout(new GridLayout(1, 4, 12, 0));
        opciones.add(new JLabel(" "));
        opciones.add(new JLabel(" "));

//
        ArrayList<Alumno> alumnosAsignatura = controladorProfesores.getnombreyidxasignatura(controladorNotas.getid_asignatura(controllogin.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText()).getId_profesor()));
        //
        DefaultTableModel model = generarModeloTablaAlumno(alumnosAsignatura, asignaturas);

//
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

        guardar = new JButton("Guardar");
        guardar.addActionListener(new Guardar(this));

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

        general.add(Metodos_repetitivos.Titulo());
        general.add(opciones);
        general.add(scrollpane);
        general.add(primer);
        general.add(boton);

        add(general, BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);

    }

   //
    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Alumno> nombresAlumnos, ArrayList<Asignatura> asignaturas) {
//
        String[] cols = {"Nombre Alumno", "Nombre Asignatura", "Notas"};
        //
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        //Ciclo para ingresar los nombres de los alumnos.
        for (int j = 0; j < nombresAlumnos.size(); j++) {
            for (int i = 0; i < asignaturas.size(); i++) {
                Object[] data = {nombresAlumnos.get(j).getNombre(), asignaturas.get(i).getNombre()};
                model.addRow(data);

            }
        }

        return model;
    }

    public static void main(String[] args) {
        try {
            Boletin_alumnos boletin_alumnos = new Boletin_alumnos();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main() throws SQLException {
        Boletin_alumnos tabla = new Boletin_alumnos();
    }

    private class guardarinformaciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
//
    private class Guardar implements ActionListener {
        private final Boletin_alumnos notas_alumnos;


        public Guardar(Boletin_alumnos notas_alumnos) {
            this.notas_alumnos = notas_alumnos;
        }

        public void actionPerformed(ActionEvent e) {

            {
                //
                conexionbasedatos conexion;
                conexion = new conexionbasedatos();
                notas_alumnos.conn = conexion.conectarMySQL();
                Statement stmt = null;
                try {
                    //
                    stmt = notas_alumnos.conn.createStatement();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                //
                Object notas = null;
                for (int i = 0; i < jTableAlumnos.getRowCount(); i++) {
                    notas = jTableAlumnos.getValueAt(i, 2);
                    System.out.println(notas);

                    try {
                    //
                        Object resultados = stmt.executeUpdate("INSERT INTO notas (notas,id_asignaturas,id_alumno) " + "VALUES('" + notas + "','" + asignaturas.get(i).getId() + "','" + controladorNotas.getidAlumno((String) jTableAlumnos.getValueAt(i,0)).getId() + "')");

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }

            }
        }
    }
}
