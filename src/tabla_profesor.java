import BDutils.*;
import Controladores.ControladorTablaProfesores;
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

public class tabla_profesor extends JFrame {

    private JTable jTableAlumnos;
    private ControladorTablaProfesores controladorProfesores = new ControladorTablaProfesores();
    private Controlador_login controllogin = new Controlador_login();
    private JComboBox asignatura;
    private JLabel titulop;
    private JButton guardar;
    private JButton modificar;
    private static Connection conn;
    private Controlador_login control = new Controlador_login();
    private Usuario user = control.iniciarSesion(inicio.usuario.getText(), inicio.contraseña.getText());
    private Profesor id_profesor = control.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText());
    private ArrayList<Asignatura> asignaturas = controladorProfesores.getAsignaturaProfesor(controllogin.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText()).getId_profesor());
    private UtilDateModel date = new UtilDateModel();

    public tabla_profesor() throws SQLException {
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


        date.setDate(2021, 3, 23);
        date.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(date);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBackground(new Color(227, 247, 193));
        opciones.add(datePicker);

        JPanel combo = new JPanel();
        combo.setLayout(new GridLayout(3, 1));
        combo.setBackground(new Color(227, 247, 193));
        asignatura = new JComboBox();
        asignatura.setBackground(new Color(227, 247, 193));



        for (int i = 0; i < asignaturas.size(); i++) {
            asignatura.addItem(asignaturas.get(i).getNombre());
        }

        combo.add(asignatura);
        opciones.add(combo);


        ArrayList<Alumno> alumnosAsignatura = controladorProfesores.getAlumnosxAsignaturaA(asignaturas.get(asignatura.getSelectedIndex()).getId());
        DefaultTableModel model = generarModeloTablaAlumno(alumnosAsignatura);

        jTableAlumnos = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Boolean.class;
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


        guardar = new JButton("Guardar");
        guardar.addActionListener(new guardarinformacion(this));

        guardarm.add(guardar);

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


    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Alumno> nombresAlumnos) {

        String[] cols = {"Nombre", "Asistencia"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i).getNombre(), false};
            model.addRow(data);
        }
        return model;
    }

    public static void main()throws SQLException
    {
        tabla_profesor tabla = new tabla_profesor();
    }


    static class guardarinformacion implements ActionListener {
        private final tabla_profesor tabla;

        public guardarinformacion(tabla_profesor tabla) {
            this.tabla = tabla;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            conexionbasedatos conexion;
            conexion = new conexionbasedatos();
            tabla.conn = conexion.conectarMySQL();
            Statement stmt = null;
            try {
                stmt = tabla.conn.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Object asistencia = null;
            for (int i = 0; i < tabla.jTableAlumnos.getRowCount(); i++) {
                asistencia = tabla.jTableAlumnos.getValueAt(i, 1);

                System.out.println(asistencia);
                if (asistencia.equals(false)) {
                    asistencia = 1;
                } else {
                    asistencia = 0;
                }
                try {
                    Object resultados = stmt.executeUpdate("INSERT INTO asistencia (id_alumno,asiste,id_asignatura,dia_semana,fecha) " + "VALUES('" + tabla.controladorProfesores.getidAlumno(tabla.asignaturas.get(tabla.asignatura.getSelectedIndex()).getId()).get(i) + "','" + asistencia + "','" + tabla.asignaturas.get(tabla.asignatura.getSelectedIndex()).getId() + "','" + null + "','" + tabla.date.getValue() + "')");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }
}