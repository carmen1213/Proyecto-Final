


import models.Alumno;
import models.Asignatura;
import models.Asistencia;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class tabla extends JFrame{

    private JTable jTableAlumnos;
    private ControladorTabla controlador = new ControladorTabla();
    static ArrayList<String> resultadosdam = new ArrayList<>();
    private JComboBox asignatura;
    private JLabel titulop;
    private JButton guardar;
    private JButton modificar;
    private static Connection conn;
     private ArrayList<Asignatura> asignaturas = controlador.getAsignaturaProfesor(2);
    private UtilDateModel date = new UtilDateModel();
    public tabla() throws SQLException {
        super("Listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(227, 247, 193));
        //this.setResizable(false);
        //setLayout(new FlowLayout());

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

        listas.DatePicker fecha = new listas.DatePicker(LocalDate.now());

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
        fecha.setEditable(false);

        //ArrayList<String> nombresAlumnos = controlador.getNombreAlumnoxAsignatura(3);
        //DefaultTableModel model = generarModeloTabla(nombresAlumnos);

        ArrayList<Alumno> alumnosAsignatura = controlador.getAlumnosxAsignaturaA(asignaturas.get(asignatura.getSelectedIndex()).getId());
        System.out.println(controlador.getAlumnosxAsignaturaA(asignaturas.get(asignatura.getSelectedIndex()).getId()));
        DefaultTableModel model = generarModeloTablaAlumno(alumnosAsignatura);

        jTableAlumnos = new JTable(model){
            //private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return Boolean.class;
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
        botones.setLayout(new GridLayout(1,3));
        botones.setBackground(new Color(227, 247, 193));
        botones.add(new JLabel());
        botones.add(new JLabel());
        JPanel guardarm = new JPanel();
        guardarm.setBackground(new Color(227, 247, 193));
        guardar = new JButton("Guardar");
        modificar = new JButton("Modificar");

        System.out.println(asignaturas.get(asignatura.getSelectedIndex()).getId());
        System.out.println(asignaturas.get(1).getId());

        // ArrayList<Asistencia> asistencia = controlador.getAsignaturaProfesor(2);

        guardar.addActionListener(new guardarinformacion());

        guardarm.add(guardar);
        guardarm.add(modificar);
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




    public JTable getjTableAlumnos() {
        return jTableAlumnos;
    }



//    private AncestorListener guardarAsistencia() {
//
//
//    }

//    private DefaultTableModel generarModeloTabla(ArrayList<String> nombresAlumnos){
//        String[] cols = { "Nombre","Asistencia"};
//        DefaultTableModel model = new DefaultTableModel(cols,0);
//        for (int i = 0; i < nombresAlumnos.size(); i++) {
//            Object[] data = {nombresAlumnos.get(i), false};
//            model.addRow(data);
//        }
//        return model;
//    }

    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Alumno> nombresAlumnos){
        String[] cols = {"Nombre","Asistencia"};
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i).getNombre(), false};
            model.addRow(data);
        }
        return model;
    }

    public static void main()throws SQLException
    {
        tabla tabla = new tabla();
    }

    private class guardarinformacion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            conexionbasedatos conexion;
            conexion = new conexionbasedatos();
            conn = conexion.conectarMySQL();
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Object asistencia = null;
            for (int i = 0; i < jTableAlumnos.getRowCount(); i++) {
                asistencia = jTableAlumnos.getValueAt(0,1);
                System.out.println(asistencia);
                if (asistencia.equals(false)){
                    asistencia = 1;
                }else{
                    asistencia = 0;
                }

            }
            try {
                Object resultados =  stmt.executeUpdate("INSERT INTO asistencia (id_alumno,asiste,id_asignatura,dia_semana,fecha) " + "VALUES('"+asignaturas.get(1).getId()+"','"+asistencia+"','"+asignaturas.get(asignatura.getSelectedIndex()).getId()+"','"+null+"','"+date.getValue()+"')");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}