import Controladores.ControladorTablaJefeEstudios;
import models.Curso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Listas extends JFrame {

    public static Font fuenteGeneral = new Font("fantasy", Font.BOLD, 30);
    private final ControladorTablaJefeEstudios controladorJefeestudios = new ControladorTablaJefeEstudios();
    private final JComboBox asignatura;
    private JTable jTableAlumnos;


    public Listas() {
        super("Listas");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
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
        System.out.println(asignatura.getSelectedItem());

        combo.add(asignatura);

        JPanel encabezado = new JPanel();
        encabezado.setBackground(Color.PINK);
        JLabel titulo = new JLabel("LISTADO DE ALUMNOS");
        titulo.setFont(fuenteGeneral);
        encabezado.add(titulo);

        //Crea una tabla cuando el usuario hace click en Dam
        if (asignatura.getSelectedItem().equals("DAM")) {
            //Guarda en una lista con objetos de tipo curso con los datos de la base de datos correspondiente
            ArrayList<Curso> Curso_Alumnos = controladorJefeestudios.getAlumnosxCurso("DAM");
            //Crea una variable de tipo Defaulttablemodel llamada model que genera un modelo de tabla pidiendo los datos al usuario
            DefaultTableModel model = generarModeloTablaAlumno(Curso_Alumnos);

            //Asigna el tipo de variables que debe tener la tabla
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
        }


        jTableAlumnos.setBounds(30, 40, 200, 300);
        JScrollPane scrollpane = new JScrollPane(jTableAlumnos);

        general.add(encabezado);
        general.add(scrollpane, BorderLayout.SOUTH);
        // general.add(combo);
        add(general, BorderLayout.CENTER);

        setSize(860, 530);
        setVisible(true);

    }


    public static void main() {
        Listas listas = new Listas();
    }

    /**
     * Metodo que genera el diseño de la tabla
     * @param nombresAlumnos  String para insertar los datos de los alumnos a la tabla
     * @return devuelve el modelo de la tabla ya con los datos
     */
    //Metodo que devuelve los datos que iran posteriormente en la tabla, obteniendo los mismos de la base de datos con los metodos que se encuentran en los controladores
    private DefaultTableModel generarModeloTablaAlumno(ArrayList<Curso> nombresAlumnos) {
        //Crea un array de tipo string para darle nombre a las diferentes columnas principales de la tabla
        String[] cols = {"Nombre", "Curso",};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        //Ciclo para ingresar los nombres de los alumnos y el curso
        for (int i = 0; i < nombresAlumnos.size(); i++) {
            Object[] data = {nombresAlumnos.get(i).getNombre_curso(), nombresAlumnos.get(i).getNombre_alumno()};
            model.addRow(data);
        }
        return model;
    }


}
