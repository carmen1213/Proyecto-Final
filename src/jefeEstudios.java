import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.BOLD;

public class jefeEstudios extends JFrame {
    private final JComboBox reunion;
    private final JComboBox recompensas;
    private final JLabel vacio;
    private final JButton cuestionario;

    private JLabel titulop;

    JRadioButtonMenuItem amonestacionesDAM;
    JRadioButtonMenuItem amonestacionesMIP;
    JRadioButtonMenuItem amonestacionesCIN;

    JRadioButtonMenuItem leve;
    JRadioButtonMenuItem grave;
    JRadioButtonMenuItem muyGrave;

    JRadioButtonMenuItem volverMenu;
    JMenu amonestacionesMenu;
    File archivo;


    Font f = new Font("fantasy", BOLD, 30);

    public jefeEstudios(Usuario user) {
        super("jefeEstudios");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.PINK);

        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        general.setBackground(Color.PINK);

        JPanel menu = new JPanel();
        menu.setBackground(new Color(227, 247, 193));

        JMenuBar barraMenu = new JMenuBar();

        menu.add(barraMenu);

        JMenu listas = new JMenu("Listas");

        JRadioButtonMenuItem listaAlumnos = new JRadioButtonMenuItem("VER LISTADO DE ALUMNOS");
        listaAlumnos.addActionListener(new Listado_alumnos());



        amonestacionesMenu = new JMenu("Amonestaciones");

        amonestacionesDAM = new JRadioButtonMenuItem("DAM");
        amonestacionesDAM.addActionListener(new verAmonestacionesDAM());

        amonestacionesCIN = new JRadioButtonMenuItem("CIN");
        amonestacionesCIN.addActionListener(new verAmonestacionesCIN());

        amonestacionesMIP = new JRadioButtonMenuItem("MIP");
        amonestacionesMIP.addActionListener(new verAmonestacionesMIP());


        leve = new JRadioButtonMenuItem("leve");
        leve.addActionListener(new AbrirLeve());

        grave = new JRadioButtonMenuItem("grave");
        grave.addActionListener(new AbrirGrave());

        muyGrave = new JRadioButtonMenuItem("muy grave");
        muyGrave.addActionListener(new AbrirMuyGrave());

        volverMenu = new JRadioButtonMenuItem("volver");
        volverMenu.addActionListener(new volverMenulist());


        JMenu horarios = new JMenu("Horarios");

        JRadioButtonMenuItem horarioDAM = new JRadioButtonMenuItem("DAM");

        JRadioButtonMenuItem horarioCIN = new JRadioButtonMenuItem("CIN");

        JRadioButtonMenuItem horarioMIP = new JRadioButtonMenuItem("MIP");


        JMenu quejas = new JMenu("Quejas");

        JRadioButtonMenuItem quejasDAM = new JRadioButtonMenuItem("DAM");

        JRadioButtonMenuItem quejasCIN = new JRadioButtonMenuItem("CIN");

        JRadioButtonMenuItem quejasMIP = new JRadioButtonMenuItem("MIP");

        barraMenu.add(listas);

        listas.add(listaAlumnos);



        barraMenu.add(amonestacionesMenu);

        amonestacionesMenu.add(amonestacionesDAM);
        amonestacionesMenu.add(amonestacionesCIN);
        amonestacionesMenu.add(amonestacionesMIP);

        amonestacionesMenu.add(leve);
        amonestacionesMenu.add(grave);
        amonestacionesMenu.add(muyGrave);
        amonestacionesMenu.add(volverMenu);

        leve.setVisible(false);
        grave.setVisible(false);
        muyGrave.setVisible(false);
        volverMenu.setVisible(false);

        barraMenu.add(horarios);

        horarios.add(horarioDAM);
        horarios.add(horarioCIN);
        horarios.add(horarioMIP);

        barraMenu.add(quejas);

        quejas.add(quejasDAM);
        quejas.add(quejasCIN);
        quejas.add(quejasMIP);

        setJMenuBar(barraMenu);


        JPanel principal = new JPanel();
        principal.setLayout(new GridLayout(4, 1));
        principal.setBackground(Color.PINK);

        JPanel titulo = new JPanel();
        titulo.setBackground(Color.PINK);
        JLabel titulop = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html> ");
        titulop.setFont(f);
        titulop.setForeground(new Color(59, 104, 252));
        titulo.add(titulop);

        JPanel primero = new JPanel();
        primero.setBackground(Color.PINK);
        vacio= new JLabel();
        vacio.setBackground(Color.PINK);
        vacio.setBounds(10,30, 200,200);

        JPanel segundo =new JPanel();
        segundo.setLayout(new GridLayout(1,2));
        segundo.setBackground(Color.PINK);


        JPanel botones = new JPanel();
        botones.setBackground(Color.PINK);
        reunion= new JComboBox();


        reunion.addItem("-Reuniones-");
        reunion.addItem("DAM");
        reunion.addItem("CIN");
        reunion.addItem("MIP");



        cuestionario = new JButton("Cuestionario");
      //  cuestionario.addActionListener(new verFomularios());

        JPanel tercero = new JPanel();
        tercero.setBackground(Color.PINK);

        recompensas = new JComboBox();
        recompensas.addItem("-Recompensas-");
        recompensas.addItem("DAM");

        recompensas.addItem("CIN");

        recompensas.addItem("MIP");
        recompensas.addActionListener(new VermdeHonor());





        primero.add(vacio);
        tercero.add(recompensas);
        botones.add(reunion);
        botones.add(cuestionario);
        segundo.add(botones);
        principal.add(titulo);
        principal.add(primero);
        principal.add(segundo);
        principal.add(tercero);
        general.add(principal);
        add(general);
        setSize(470, 520);
        setVisible(true);
    }

    public static void main(Usuario user) {
        jefeEstudios jefe = new jefeEstudios(user);
    }

    private class verAmonestacionesDAM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            amonestacionesDAM.setSelected(false);
            volverMenu.setSelected(false);
            amonestacionesDAM.setVisible(false);
            amonestacionesMIP.setVisible(false);
            amonestacionesCIN.setVisible(false);
            amonestacionesMenu.setText("Gravedad");
        }
    }

    private class verAmonestacionesCIN implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            amonestacionesCIN.setSelected(false);
            volverMenu.setSelected(false);
            amonestacionesDAM.setVisible(false);
            amonestacionesMIP.setVisible(false);
            amonestacionesCIN.setVisible(false);
            amonestacionesMenu.setText("Gravedad");
        }
    }

    private class verAmonestacionesMIP implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            amonestacionesMIP.setSelected(false);
            volverMenu.setSelected(false);
            amonestacionesDAM.setVisible(false);
            amonestacionesMIP.setVisible(false);
            amonestacionesCIN.setVisible(false);
            amonestacionesMenu.setText("Gravedad");
        }
    }

    private class volverMenulist implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setSelected(false);
            leve.setVisible(false);
            grave.setVisible(false);
            muyGrave.setVisible(false);
            volverMenu.setVisible(false);
            amonestacionesDAM.setVisible(true);
            amonestacionesCIN.setVisible(true);
            amonestacionesMIP.setVisible(true);
            amonestacionesMenu.setText("Amonestaciones");
            leve.setSelected(false);
            grave.setSelected(false);
            muyGrave.setSelected(false);
        }

    }

    private class AbrirLeve implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            leve.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\PartesYM.deHonor\\AmonestacionLeve.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }

    private class AbrirGrave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            grave.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\PartesYM.deHonor\\AmonestacionGrave.docx");
                Desktop.getDesktop().open(archivo);

            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }

    private class AbrirMuyGrave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            muyGrave.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\PartesYM.deHonor\\AmonestacionMuyGrave.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }

//    private class verFomularios implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            WebDriver driver;
//
//            String exePath = "C:\\Users\\carma\\IdeaProjects\\Trabajo final\\chromedriver.exe";
//            System.setProperty("webdriver.chrome.driver", exePath);
//
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--start-maximized");
//            driver = new ChromeDriver(options);
//            driver.get("https://www.google.es/intl/es/forms/about/");
//
//        }
//    }

    private class VermdeHonor implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (recompensas.getSelectedItem().equals("DAM")){
                archivo = new File("C:\\Users\\salva\\Desktop\\ProyectoFinal\\PartesYM.deHonor\\MatriculaDeHonorDAM.docx");
                try {
                    Desktop.getDesktop().open(archivo);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (recompensas.getSelectedItem().equals("MIP")){
                archivo = new File("C:\\Users\\salva\\Desktop\\ProyectoFinal\\PartesYM.deHonor\\MatriculaDeHonorMIP.docx");
                try {
                    Desktop.getDesktop().open(archivo);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (recompensas.getSelectedItem().equals("CIN")){
                archivo = new File("C:\\Users\\salva\\Desktop\\ProyectoFinal\\PartesYM.deHonor\\MatriculaDeHonorCIN.docx");
                try {
                    Desktop.getDesktop().open(archivo);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    private class Listado_alumnos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Listas listas = new Listas();
        }
    }
}

