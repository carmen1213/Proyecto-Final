


import models.Alumno;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

public class tabla extends JFrame{
    private JTable jTableAlumnos;
    private ControladorTabla controlador = new ControladorTabla();
    static ArrayList<String> resultadosdam = new ArrayList<>();
    private JComboBox asignatura;
    private JLabel titulop;
    private JButton guardar;
    private JButton modificar;

    public tabla(){
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
        UtilDateModel date = new UtilDateModel();
        date.setDate(2021, 3, 23);
        date.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(date);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBackground(new Color(227, 247, 193));
        opciones.add(datePicker);

        JPanel combo = new JPanel();
        combo.setLayout(new GridLayout(3,1));
        combo.setBackground(new Color(227, 247, 193));
        asignatura = new JComboBox();
        asignatura.setBackground(new Color(227, 247, 193));
        //ArrayList<Asignatura> asignaturas = controlador.getAsignaturaProfesor(idProfesor);
        asignatura.addItem("Programacion");
        asignatura.addItem("Bases de datos");
        combo.add(asignatura);
        opciones.add(combo);
        fecha.setEditable(false);

        //ArrayList<String> nombresAlumnos = controlador.getNombreAlumnoxAsignatura(3);
        //DefaultTableModel model = generarModeloTabla(nombresAlumnos);

        ArrayList<Alumno> alumnosAsignatura = controlador.getAlumnosxAsignaturaA(3);
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

    private DefaultTableModel generarModeloTabla(ArrayList<String> nombresAlumnos){
        String[] cols = { "Nombre","Asistencia"};
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i), false};
            model.addRow(data);
        }
        return model;
    }

    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Alumno> nombresAlumnos){
        String[] cols = { "Nombre","Asistencia"};
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
}