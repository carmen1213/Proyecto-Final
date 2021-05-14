import Controladores.ControladorTablaJefeEstudios;
import models.Curso;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Font.BOLD;

public class Listas extends JFrame {
    private ControladorTablaJefeEstudios controladorJefeestudios = new ControladorTablaJefeEstudios();
    private JTable jTableAlumnos;
    private JLabel titulop;
    Font f = new Font("fantasy", BOLD, 30);
    private JComboBox asignatura;


    public Listas(){
        super("Listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.PINK);

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(3, 1));
        general.setBackground(Color.PINK);

        JPanel combo = new JPanel();
        combo.setLayout(new GridLayout(3, 1));
        combo.setBackground(new Color(227, 247, 193));
        asignatura = new JComboBox();
        asignatura.setBackground(new Color(227, 247, 193));
        asignatura.addItem("DAM");

        asignatura.addItem("MIP");
        asignatura.addItem("CIN");

        combo.add(asignatura);

        JPanel titulo = new JPanel();
        titulo.setBackground(Color.PINK);
        JLabel titulop = new JLabel("LISTADO DE ALUMNOS");
        titulop.setFont(f);
        titulo.add(titulop);

if (asignatura.getSelectedItem().equals("DAM")){
    ArrayList<Curso> Curso_Alumnos = controladorJefeestudios.getAlumnosxCurso("DAM");
    DefaultTableModel model = generarModeloTablaAlumno(Curso_Alumnos);
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
} else if(asignatura.getSelectedItem().equals("CIN")){
    ArrayList<Curso> Curso_Alumnos = controladorJefeestudios.getAlumnosxCurso("CIN");
    DefaultTableModel model = generarModeloTablaAlumno(Curso_Alumnos);
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

} else if(asignatura.getSelectedItem().equals("MIP")){
    ArrayList<Curso> Curso_Alumnos = controladorJefeestudios.getAlumnosxCurso("MIP");
    DefaultTableModel model = generarModeloTablaAlumno(Curso_Alumnos);
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

}

        jTableAlumnos.setBounds(30,40,200,300);
        JScrollPane scrollpane = new JScrollPane(jTableAlumnos);

        general.add(titulo);
        general.add(scrollpane,BorderLayout.SOUTH);
       // general.add(combo);
        add(general,BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);



    }




    public static void main() {
        Listas listas = new Listas();
    }
    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Curso> nombresAlumnos) {

        String[] cols = {"Curso", "Nombre"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i).getNombre_curso(), nombresAlumnos.get(i).getNombre_alumno()};
            model.addRow(data);
        }
        return model;
    }
}
