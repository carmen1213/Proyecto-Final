import Controladores.ControladorTablaProfesores;
import Controladores.Controlador_login;
import Controladores.Controlador_tabla_padres;
import Interfaz.Metodos_repetitivos;
import models.Profesor;
import models.Usuario;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Tabla_padres extends JFrame {
    private JTable jTableAlumnos;
    private Controlador_login control = new Controlador_login();
    private Usuario user = control.iniciarSesion(inicio.usuario.getText(), inicio.contraseña.getText());
    private Controlador_tabla_padres controler = new Controlador_tabla_padres();

    public Tabla_padres() throws SQLException {
        super("Notas");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(227, 247, 193));


        JPanel general = new JPanel();
        general.setLayout(new GridLayout(4, 1));
        general.setBackground(new Color(227, 247, 193));


        JPanel opciones = new JPanel();
        opciones.setBackground(new Color(227, 247, 193));
        opciones.setLayout(new GridLayout(1, 4, 12, 0));
        opciones.add(new JLabel(" "));
        opciones.add(new JLabel(" "));

        //Obtiene de la base de datos los datos correspondientes a los padres y los guarda en una variable de tipo String
        String padres = controler.getNombrepadre(inicio.usuario.getText(), inicio.contraseña.getText());
        //Obtiene de la base de datos los datos correspondientes a los alumnos y los guarda en una variable de tipo String
        String alumnos = String.valueOf(controler.getalumno(controler.getNombrepadre(inicio.usuario.getText(), inicio.contraseña.getText())));
        //Obtiene las notas de los alumnos y los guarda en una variable de tipo int
        int notas = controler.getnotas(alumnos, padres);
        //Crea un modelo de tabla con los datos obtenidos anteriormente
        DefaultTableModel model = generarModeloTablaAlumno(alumnos, padres, notas);
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


        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 3));
        botones.setBackground(new Color(227, 247, 193));
        botones.add(new JLabel());
        botones.add(new JLabel());
        JPanel guardarm = new JPanel();
        guardarm.setBackground(new Color(227, 247, 193));




        botones.add(guardarm);
        primer.add(referencia);
        primer.add(botones);


        general.add(Metodos_repetitivos.Titulo());
        general.add(opciones);
        general.add(scrollpane);
        general.add(primer);

        add(general, BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);

    }

    /**
     * Metodo que genera el diseño de la tabla
     * @param alumnos String para insertar los datos de los alumnos a la tabla
     * @param padres String para insertar los datos de los alumnos padres en la tabla
     * @return  devuelve el modelo de la tabla ya con los datos
     */
    //    //Metodo que devuelve los datos que iran posteriormente en la tabla, obteniendo los mismos de la base de datos con los metodos que se encuentran en los controladores
    private DefaultTableModel generarModeloTablaAlumno(String alumnos, String padres, int notas) {
        //Crea un array de tipo string para darle nombre a las diferentes columnas principales de la tabla
        String[] cols = {"Nombre padres", "Nombre alumno", "Notas"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
            //Crea un array para guadar la informacion en la tabla
            Object[] data = {padres,alumnos,  notas};
            model.addRow(data);

        return model;
    }


}
