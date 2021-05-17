import models.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import static java.awt.Font.BOLD;

public class profesor extends JFrame {
    private JLabel titulop;
    private JButton horario;
    private JButton Reuniones;
    private JComboBox descargar;
    private JLabel icon;
    private JComboBox disponibilidad;
    private JComboBox horas;
    File archivo;
    JMenu Material;
    JMenuItem DAM;
    JMenuItem CIN;
    JMenuItem MIP;

    Font f = new Font("Monospaced", BOLD, 30);

    public profesor(Usuario user) {
        super("Profesores");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(227, 247, 193));
        setLayout(new FlowLayout());
        setBackground(new Color(227, 247, 193));

        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        general.setBackground(new Color(227, 247, 193));


        JPanel menu = new JPanel();
        menu.setBackground(new Color(227, 247, 193));

        JMenuBar barraMenu = new JMenuBar();
        menu.add(barraMenu);
        JMenu Listas = new JMenu("Listas");
        JMenu Material = new JMenu("Material");

        JRadioButtonMenuItem dam1l = new JRadioButtonMenuItem("Pasar lista");
        dam1l.addActionListener(new Listenerco());


        DAM = new JMenuItem("DAM");
        DAM.addActionListener(new EscMaterialDAM());
        CIN = new JMenuItem("CIN");
        CIN.addActionListener(new EscMaterialCIN());
        MIP = new JMenuItem("MIP");
        MIP.addActionListener(new EscMaterialMIP());


        barraMenu.add(Listas);
        barraMenu.add(Material);

        Listas.add(dam1l);

        Material.add(DAM);
        Material.add(CIN);
        Material.add(MIP);

        setJMenuBar(barraMenu);

        JPanel principal = new JPanel();
        principal.setLayout( new GridLayout(2,1));
        principal.setBackground(new Color(227, 247, 193));

        JPanel titulo= new JPanel();
        titulop = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html> ");
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);
        titulo.setBackground(new Color(227, 247, 193));


        JPanel logo = new JPanel();
        logo.setBackground(new Color(227, 247, 193));
        icon = new JLabel();
        icon.setBackground(new Color(227, 247, 193));
        icon.setIcon(new ImageIcon("C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\imagenes\\profesores (1).jpg"));

        logo.add(icon);

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1,3,7,8));
        botones.setBackground(new Color(227, 247, 193));

        JPanel Horario = new JPanel();
        Horario.setBackground(new Color(227, 247, 193));
        Horario.setLayout(new GridLayout(3,1));
        JLabel vacioar = new JLabel();
        vacioar.setBackground(new Color(227, 247, 193));
        horario = new JButton("Horario");
        JLabel vacioab = new JLabel();
        vacioab.setBackground(new Color(227, 247, 193));

        Horario.add(vacioar);
        Horario.add(horario);
        Horario.add(vacioab);


        JPanel reuniones = new JPanel();
        reuniones.setLayout(new GridLayout(3,1));
        reuniones.setBackground(new Color(227, 247, 193));
        JLabel vacioarr = new JLabel();
        vacioarr.setBackground(new Color(227, 247, 193));
        Reuniones = new JButton("Reuniones");
        Reuniones.addActionListener( new AbrirCorreo());
        JLabel vacioaba = new JLabel();
        vacioaba.setBackground(new Color(227, 247, 193));

        reuniones.add(vacioarr);
        reuniones.add(Reuniones);
        reuniones.add(vacioaba);

        JPanel Descargar = new JPanel();
        Descargar.setLayout(new GridLayout(3,1));
        Descargar.setBackground(new Color(227, 247, 193));
        JLabel vacioarri = new JLabel();
        vacioarri.setBackground(new Color(227, 247, 193));
        descargar = new JComboBox();
        descargar.addItem("Archivos");
        descargar.addItem("Horario");

        JLabel vacioabaj = new JLabel();
        vacioabaj.setBackground(new Color(227, 247, 193));

        Descargar.add(vacioarri);
        Descargar.add(descargar);
        Descargar.add(vacioabaj);

        botones.add(Horario);
        botones.add(reuniones);
        botones.add(Descargar);



        // principal.add(menu);
        principal.add(logo);
        principal.add(botones);



        general.add(menu);
        general.add(titulo,BorderLayout.NORTH);
        general.add(principal, BorderLayout.CENTER);


        add(general);
        setSize(700, 780);
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

    private class EscMaterialDAM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Scanner entrada = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\MaterialDAM"));
            int valor = fileChooser.showOpenDialog(fileChooser);
            if (valor == JFileChooser.APPROVE_OPTION) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                    File f = new File(ruta);
                    entrada = new Scanner(f);
                    while (entrada.hasNext()) {
                        System.out.println(entrada.nextLine());
                    }
                } catch (FileNotFoundException ee) {
                    System.out.println(ee.getMessage());
                } finally {
                    if (entrada != null) {
                        entrada.close();
                    }
                }

            }
        }
    }

    private class EscMaterialCIN implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Scanner entrada = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\MaterialCIN"));
            int valor = fileChooser.showOpenDialog(fileChooser);
            if (valor == JFileChooser.APPROVE_OPTION) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                    File f = new File(ruta);
                    entrada = new Scanner(f);
                    while (entrada.hasNext()) {
                        System.out.println(entrada.nextLine());
                    }
                } catch (FileNotFoundException ee) {
                    System.out.println(ee.getMessage());
                } finally {
                    if (entrada != null) {
                        entrada.close();
                    }
                }
            }
        }
    }

    private class EscMaterialMIP implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Scanner entrada = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\MaterialMIP"));
            int valor = fileChooser.showOpenDialog(fileChooser);
            if (valor == JFileChooser.APPROVE_OPTION) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                    File f = new File(ruta);
                    entrada = new Scanner(f);
                    while (entrada.hasNext()) {
                        System.out.println(entrada.nextLine());
                    }
                } catch (FileNotFoundException ee) {
                    System.out.println(ee.getMessage());
                } finally {
                    if (entrada != null) {
                        entrada.close();
                    }
                }
            }
        }
    }


    private class AbrirCorreo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WebDriver driver;

           String exePath = "C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\chromedriver.exe";
           System.setProperty("webdriver.chrome.driver", exePath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
           driver = new ChromeDriver(options);
           driver.get("https://outlook.live.com/owa/");
        }
    }
}