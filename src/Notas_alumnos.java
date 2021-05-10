import BDutils.conexionbasedatos;
import models.*;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
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

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Notas_alumnos  extends JFrame{
    private JTable jTableAlumnos;
    private ControladorTabla controlador = new ControladorTabla();
    static ArrayList<String> resultadosdam = new ArrayList<>();
    private JComboBox asignatura;
    private JLabel titulop;
    private JButton guardar;
    private JButton modificar;
    private static Connection connecion;
    private obtencion_datos_login control = new obtencion_datos_login();
   // private Profesor id_profesor = control.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText());
    private ArrayList<Asignatura> asignaturas = controlador.getAsignaturaProfesor(2);
    private UtilDateModel date = new UtilDateModel();

    public Notas_alumnos() throws SQLException {
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


        ArrayList<Notas> alumnosAsignatura = controlador.getAlumnosyasignaturas(3);
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


        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 3));
        botones.setBackground(new Color(227, 247, 193));
        botones.add(new JLabel());
        botones.add(new JLabel());
        JPanel guardarm = new JPanel();
        guardarm.setBackground(new Color(227, 247, 193));
        guardar = new JButton("Guardar");



        guardar.addActionListener(new guardarinformaciones());

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


    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Notas> nombresAlumnos) {

        String[] cols = {"Nombre Alumno", "Nombre Asignatura", "Notas"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i).getNombre_alumno(), nombresAlumnos.get(i).getAsignatura()};
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
