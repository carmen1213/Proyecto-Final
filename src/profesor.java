import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static java.awt.Font.BOLD;

public class profesor extends JFrame {
private JLabel titulop;
private JButton horario;
private JButton Reuniones;
private JComboBox descargar;
    private JComboBox disponibilidad;
    private JComboBox horas;
    Font f = new Font("Monospaced", BOLD, 30);

    public profesor(Usuario user) {
        super("Profesores");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(227, 247, 193));
        setLayout(new FlowLayout());
        setBackground(new Color(227, 247, 193));

        JPanel general = new JPanel();
        general.setBackground(new Color(227, 247, 193));
        JPanel principal = new JPanel();
        principal.setLayout( new GridLayout(4,1, 0,15));
        principal.setBackground(new Color(227, 247, 193));
        JPanel menu = new JPanel();
        menu.setBackground(new Color(227, 247, 193));

        JMenuBar barraMenu = new JMenuBar();
        menu.add(barraMenu);
        JMenu Listas = new JMenu("Listas");
        JMenu Material = new JMenu("Material");

        JRadioButtonMenuItem dam1l = new JRadioButtonMenuItem("Pasar lista");
        dam1l.addActionListener(new Listenerco());


        JMenuItem dam1m = new JMenuItem("1º DAM");
        JMenuItem dam2m = new JMenuItem("2º DAM");
        JMenuItem CIMm = new JMenuItem("CIM");
        JMenuItem MARKETINGm = new JMenuItem("MARKETING");


        barraMenu.add(Listas);
        barraMenu.add(Material);

        Listas.add(dam1l);

        Material.add(dam1m);
        Material.add(dam2m);
        Material.add(CIMm);
        Material.add(MARKETINGm);

        setJMenuBar(barraMenu);

        JPanel titulo= new JPanel();
        titulop = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html> ");
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);
        titulo.setBackground(new Color(227, 247, 193));

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1,3,12,20));
        botones.setBackground(new Color(227, 247, 193));
        horario = new JButton("Horario");
        Reuniones = new JButton("Reuniones");
        descargar = new JComboBox();
        descargar.setBackground(new Color(227, 247, 193));
        descargar.addItem("Archivos");
        descargar.addItem("Horario");
        botones.add(horario);
        botones.add(Reuniones);
        botones.add(descargar);

        JPanel disponible =new JPanel();
        disponible.setBackground(new Color(227, 247, 193));
        disponible.setLayout(new GridLayout(4,1));
        disponible.add(new JLabel(" "));

        disponibilidad= new JComboBox();
        disponibilidad.setBackground(new Color(227, 247, 193));
        //disponibilidad.setBorder(new TitledBorder("Dias Disponibles"));
        disponibilidad.addItem("Lunes");
        disponibilidad.addItem("Martes");
        disponibilidad.addItem("Miercoles");
        disponibilidad.addItem("Jueves");
        disponibilidad.addItem("Viernes");
        disponibilidad.addActionListener(new Listenerdispo());

        horas = new JComboBox();
        horas.setBackground(new Color(227, 247, 193));
        horas.addItem("08:15-09:10");
        horas.addItem("09:10-10:05");
        horas.addItem("10:05-11:00");
        horas.addItem("11:30-12:25");
        horas.addItem("12:25-13:20");
        horas.addItem("13:20-14:15");
        horas.addActionListener(new Listenerhora());


        disponible.add(new JLabel(" "));

        disponible.add(disponibilidad);
        disponible.add(horas);


        // principal.add(menu);
        principal.add(titulo);
        principal.add(botones);
        principal.add(disponible);

        general.add(menu);
        general.add(principal);


        add(general, BorderLayout.CENTER);
        setSize(400, 520);
        setVisible(true);
    }

    public static void main(Usuario user) {
        profesor profe = new profesor(user);
    }


    public static class Listenerco implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tabla_profesor.main();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private class Listenerhora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String itemSeleecionado = (String)horas.getSelectedItem();
            if ("Lunes".equals(itemSeleecionado)) {

            }
            if ("Martes".equals(itemSeleecionado)) {

            }
            if ("Miercoles".equals(itemSeleecionado)) {

            }
            if ("Jueves".equals(itemSeleecionado)) {

            }
            if ("Viernes".equals(itemSeleecionado)) {

            }

        }
    }

    private class Listenerdispo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String itemSeleecionado = (String)horas.getSelectedItem();

            if ("08:15-09:10".equals(itemSeleecionado)) {

            }
            if ("09:10-10:05".equals(itemSeleecionado)) {

            }
            if ("10:05-11:00".equals(itemSeleecionado)) {

            }
            if ("11:30-12:25".equals(itemSeleecionado)) {

            }
            if ("13:20-14:15".equals(itemSeleecionado)) {

            }

        }
    }
}

