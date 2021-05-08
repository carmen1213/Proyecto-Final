package JefeEstudios;

import models.Alumno;
import models.Curso;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.awt.Font.BOLD;

public class Listas extends JFrame {
    private ControladorTabla controlador = new ControladorTabla();
    private JTable jTableAlumnos;
    private JLabel titulop;
    Font f = new Font("fantasy", BOLD, 30);

    public Listas(){
        super("Listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.PINK);

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(3, 1));
        general.setBackground(Color.PINK);

        JPanel titulo = new JPanel();
        titulo.setBackground(Color.PINK);
        JLabel titulop = new JLabel("HORARIO");
        titulop.setFont(f);
        titulo.add(titulop);

        ArrayList<Curso> alumnosAsignatura = controlador.
        DefaultTableModel model = generarModeloTablaAlumno(alumnosAsignatura);
        jTableAlumnos = new JTable(model) {
            //private static final long serialVersionUID = 1L;
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

        general.add(titulo);
        add(general,BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);



    }



    public static void main() {
        Listas listas = new Listas();
    }
    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Alumno> nombresAlumnos) {

        String[] cols = {"Curso", "Nombre"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i).getNombre(), nombresAlumnos.get(i).getCurso()};
            model.addRow(data);
        }
        return model;
    }
}
