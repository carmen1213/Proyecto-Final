import Controladores.ControladorNotasALumnos;
import Controladores.ControladorTablaNotas;
import Controladores.Controlador_login;
import Interfaz.Metodos_repetitivos;
import models.Asignatura;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class Alumnos_notas extends JFrame {

    //Variable para crear la tabla
    private final JTable jTableAlumnos;
    //llama a la clase controlador notas para poder usar a continuacion sus diferentes metodos
    private final ControladorNotasALumnos controladorTablanotasAlumnos = new ControladorNotasALumnos();
    //llama a la clase controlador del login para poder usar a continuacion sus diferentes metodos
    private final Controlador_login controllogin = new Controlador_login();
    //Crea un Arraylist de ints que obtiene los datos de las notas desde la base de datos y las va guardando en la misma
    private final ArrayList<Integer> notas = controladorTablanotasAlumnos.getNotasalumnos(controllogin.getIdalumno(inicio.usuario.getText(), inicio.contraseña.getText()).getId());
    //llama a la clase controlador notas para poder usar a continuacion sus diferentes metodos
    private ControladorTablaNotas controladorNotas = new ControladorTablaNotas();

    public Alumnos_notas() throws SQLException {
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

        //Crea un Arraylist de objetos asignatura que obtiene los datos de las asignaturas desde la base de datos y los va guardando en el mismo
        ArrayList<String> asignaturas = controladorTablanotasAlumnos.getasignaturas(inicio.usuario.getText(), inicio.contraseña.getText(), controladorNotas.getidAlumno(controllogin.getIdalumno(inicio.usuario.getText(),inicio.contraseña.getText()).getNombre()).getNombre());

        //Guarda en una variable de tipo String los diferentes nombres de los alumnos, consultandoselo a la base de datos
        String alumnosAsignatura = controllogin.getIdalumno(inicio.usuario.getText(), inicio.contraseña.getText()).getNombre();

        //Crea una variable de tipo Defaulttablemodel llamada model que genera un modelo de tabla pidiendo los datos al usuario
        DefaultTableModel model = generarModeloTablaNotasProfesor(alumnosAsignatura, asignaturas, notas);

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


        JLabel vacioaba = new JLabel(" ");
        vacioab.setBackground(new Color(227, 247, 193));


        botones.add(vacioarr);
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

    /**
     * Metodo que genera el diseño de la tabla
     * @param alumnosAsignatura String para insertar los datos de los alumnos a la tabla
     * @param asignaturas Arraylist de tipo asignatura, que obtiene los diferentes nombres de las asignaturas de la base de datos
     * @param notas Arraylist de tipo int que obtiene las diferentes notas de la base de datos
     * @return devuelve el modelo de la tabla ya con los datos
     */
    //Metodo que devuelve los datos que iran posteriormente en la tabla, obteniendo los mismos de la base de datos con los metodos que se encuentran en los controladores
    private DefaultTableModel generarModeloTablaNotasProfesor(String alumnosAsignatura, ArrayList<String> asignaturas, ArrayList<Integer> notas) {
        //Crea un array de tipo string para darle nombre a las diferentes columnas principales de la tabla
        String[] cols = {"Nombre Alumno", "Nombre Asignatura", "Notas"};

        DefaultTableModel model = new DefaultTableModel(cols, 0);

        //Ciclo para ingresar los nombres de los alumnos.
        for (int k = 0; k < notas.size(); k++) {
            System.out.println(notas.get(k).intValue());
            Object[] data = {alumnosAsignatura, asignaturas.get(k), notas.get(k).intValue()};
            model.addRow(data);
        }

        return model;
    }
}