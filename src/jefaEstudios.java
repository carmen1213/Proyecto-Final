//imports necesarios

import Interfaz.Metodos_repetitivos;
import models.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class jefaEstudios {

    public static Font fuenteGeneral = new Font("Wide Latin", Font.PLAIN, 17);
    public static Font fuenteMenu = new Font("MV Boli", Font.PLAIN, 15);
    public static JMenu listasMenu;

    JComboBox recompensasComboBox;

    JFrame general;

    JRadioButtonMenuItem amonestacionesDAM;
    JRadioButtonMenuItem amonestacionesMIP;
    JRadioButtonMenuItem amonestacionesCIN;

    JRadioButtonMenuItem leve;
    JRadioButtonMenuItem grave;
    JRadioButtonMenuItem muyGrave;

    JRadioButtonMenuItem quejasDAM;
    JRadioButtonMenuItem quejasCIN;
    JRadioButtonMenuItem quejasMIP;
    JRadioButtonMenuItem listasDAM;
    JRadioButtonMenuItem volverMenu;

    JMenu amonestacionesMenu;
    File archivo;

    public jefaEstudios(Usuario user) {

        //Declaración de JFrame y JLayeredPane

        general = new JFrame();

        JLayeredPane principal = new JLayeredPane();

        //Declaración de JLabel y JComboBox

        JLabel jefaEstudiosImagen = new JLabel("");

         recompensasComboBox  = new JComboBox();

        //Declaración de JButton

        JButton reunionesBtn = new JButton("Reuniones");

        JButton cuestionariosBtn = new JButton("Cuestionarios");

        JButton crearAlumnosBtn = new JButton("Crear Alumnos");

        JButton volverBtn = new JButton("");

        //Declaración de JMenuBar y JMenu

        JMenuBar barraMenu = new JMenuBar();

        listasMenu = new JMenu("Listas");

        amonestacionesMenu = new JMenu("Amonestaciones");


        JMenu quejasMenu = new JMenu("Quejas");

        //Declaración de JRadioButtonMenuItem

        listasDAM = new JRadioButtonMenuItem("DAM");

        volverMenu = new JRadioButtonMenuItem("volver");

        quejasDAM = new JRadioButtonMenuItem("DAM");
        quejasCIN = new JRadioButtonMenuItem("CIN");
        quejasMIP = new JRadioButtonMenuItem("MIP");

        leve = new JRadioButtonMenuItem("LEVE");
        grave = new JRadioButtonMenuItem("GRAVE");
        muyGrave = new JRadioButtonMenuItem("MUY GRAVE");
        volverMenu = new JRadioButtonMenuItem("VOLVER");

        amonestacionesDAM = new JRadioButtonMenuItem("DAM");
        amonestacionesCIN = new JRadioButtonMenuItem("CIN");
        amonestacionesMIP = new JRadioButtonMenuItem("MIP");

        /* Modificaciones */

        //general

        general.getContentPane().setBackground(new Color(255, 192, 203));
        general.setVisible(true);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setBackground(new Color(255, 192, 203));
        general.setTitle("Jefa de Estudios");
        general.setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Proyecto-Final\\imagenes\\logoEncabezado.png"));
        general.setBounds(100, 100, 1503, 827);
        general.setJMenuBar(barraMenu);

        //jefaEstudiosImagen

        jefaEstudiosImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenJefaEstudios.jpg"));
        jefaEstudiosImagen.setHorizontalAlignment(SwingConstants.CENTER);
        jefaEstudiosImagen.setBounds(378, 135, 853, 399);

        //reunionesBtn

        reunionesBtn.setFont(fuenteGeneral);
        reunionesBtn.setBackground(new Color(204, 255, 255));
        reunionesBtn.setBounds(35, 555, 262, 67);

        //cuestionariosBtn

        cuestionariosBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenCuestionarios.png"));
        cuestionariosBtn.setBackground(new Color(204, 255, 255));
        cuestionariosBtn.setFont(fuenteGeneral);
        cuestionariosBtn.setBounds(815, 555, 310, 67);

        //recompensasComboBox

        recompensasComboBox.setBackground(new Color(204, 255, 255));
        recompensasComboBox.addActionListener(new escRecompensas());
        recompensasComboBox.setModel(new DefaultComboBoxModel(new String[]{"-Recompensas-", "DAM", "CIN", "MIP"}));
        recompensasComboBox.setFont(fuenteGeneral);
        recompensasComboBox.setBounds(1217, 555, 262, 67);


        //crearAlumnosBtn

        crearAlumnosBtn.setBackground(new Color(204, 255, 255));
        crearAlumnosBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenPersona.png"));
        crearAlumnosBtn.setFont(fuenteGeneral);
        crearAlumnosBtn.setBounds(378, 555, 346, 67);
        listasMenu.setBackground(new Color(102, 204, 255));


        //JMenus

        barraMenu.setBackground(new Color(255, 192, 203));
        listasMenu.setFont(fuenteMenu);
        amonestacionesMenu.setFont(fuenteMenu);
        quejasMenu.setFont(fuenteMenu);


        //leve,grave,muyGrave y volverMenu

        leve.setVisible(false);
        grave.setVisible(false);
        muyGrave.setVisible(false);
        volverMenu.setVisible(false);

        //Insercciones a la GUI

        general.getContentPane().add(principal, BorderLayout.CENTER);

        principal.add(Metodos_repetitivos.Titulo());
        principal.add(Metodos_repetitivos.Usuario(user));
        principal.add(jefaEstudiosImagen);
        principal.add(reunionesBtn);
        principal.add(cuestionariosBtn);
        principal.add(recompensasComboBox);
        principal.add(crearAlumnosBtn);

        barraMenu.add(listasMenu);
        listasMenu.add(listasDAM);

        barraMenu.add(amonestacionesMenu);
        barraMenu.add(quejasMenu);

        quejasMenu.add(quejasDAM);
        quejasMenu.add(quejasCIN);
        quejasMenu.add(quejasMIP);

        amonestacionesMenu.add(amonestacionesDAM);
        amonestacionesMenu.add(amonestacionesCIN);
        amonestacionesMenu.add(amonestacionesMIP);
        amonestacionesMenu.add(leve);
        amonestacionesMenu.add(grave);
        amonestacionesMenu.add(muyGrave);
        amonestacionesMenu.add(volverMenu);

        principal.add(Metodos_repetitivos.volverBoton(volverBtn));

        //Acciones

        reunionesBtn.addActionListener(new abrirReuniones());

        cuestionariosBtn.addActionListener(new verFormularios());

        crearAlumnosBtn.addActionListener(new añadirAlumnos());

        listasDAM.addActionListener(new verListasDAM());

        volverMenu.addActionListener(new volverMenulist());

        leve.addActionListener(new abrirLeve());

        grave.addActionListener(new abrirGrave());

        muyGrave.addActionListener(new abrirMuyGrave());

        volverMenu.addActionListener(new volverMenulist());

        amonestacionesDAM.addActionListener(new verAmonestacionesDAM());
        amonestacionesCIN.addActionListener(new verAmonestacionesCIN());
        amonestacionesMIP.addActionListener(new verAmonestacionesMIP());

        quejasDAM.addActionListener(new verQuejasDAM());

        quejasCIN.addActionListener(new verQuejasCIN());

        quejasMIP.addActionListener(new verQuejasMIP());
        volverBtn.addMouseListener(new volverInicio());
    }

    public static void main(Usuario user) {
        new jefaEstudios(user);
    }

    private class añadirAlumnos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Ingresar_alumnos().setVisible(true);
        }


    }

    private class volverInicio implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            general.dispose();
            inicio.usuario.setText("");
            inicio.contraseña.setText("");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
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

    private class abrirLeve implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            leve.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\plantilla__Amonestaciones\\AmonestacionLeve.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }

    private class abrirGrave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            grave.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\plantilla__Amonestaciones\\AmonestacionGrave.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }

    private class abrirMuyGrave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            muyGrave.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\plantilla__Amonestaciones\\AmonestacionMuyGrave.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);
            }
        }
    }

    private class verListasDAM implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            listasDAM.setSelected(false);
            new Listas();

        }
    }

    private class abrirReuniones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            WebDriver driver;

            String exePath = "..\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://outlook.office.com/mail/inbox");

        }
    }

    private class verFormularios implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WebDriver driver;

            String exePath = "..\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://www.google.es/intl/es/forms/about/");
        }
    }

    private class verQuejasDAM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            quejasDAM.setSelected(false);
            Scanner entrada = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\quejas__Rellenas\\DAM"));
            int valor = fileChooser.showOpenDialog(fileChooser);
            if (valor == JFileChooser.APPROVE_OPTION) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                    Desktop.getDesktop().open(new File(ruta));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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


    private class verQuejasMIP implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            quejasMIP.setSelected(false);
            Scanner entrada = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\quejas__Rellenas\\MIP"));
            int valor = fileChooser.showOpenDialog(fileChooser);
            if (valor == JFileChooser.APPROVE_OPTION) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                    Desktop.getDesktop().open(new File(ruta));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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



    private class verQuejasCIN implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            quejasCIN.setSelected(false);
            Scanner entrada = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\quejas__Rellenas\\CIN"));
            int valor = fileChooser.showOpenDialog(fileChooser);
            if (valor == JFileChooser.APPROVE_OPTION) {
                String ruta = fileChooser.getSelectedFile().getAbsolutePath();
                try {
                    Desktop.getDesktop().open(new File(ruta));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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


    private class escRecompensas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          if(recompensasComboBox.getSelectedItem().equals("DAM")){

                try {

                    File archivo = new File("..\\Proyecto-Final\\plantilla__M.deHonor\\DAM\\matrículaDeHonorDAM.docx");
                    Desktop.getDesktop().open(archivo);

                } catch (IOException ex) {

                    System.out.println(ex);
                }

            }
            if(recompensasComboBox.getSelectedItem().toString().equals("CIN")) {

                try {

                    File archivo = new File("..\\Proyecto-Final\\plantilla__M.deHonor\\CIN\\matrículaDeHonorCIN.docx");
                    Desktop.getDesktop().open(archivo);

                } catch (IOException ex) {

                    System.out.println(ex);
                }

            }
            if(recompensasComboBox.getSelectedItem().equals("MIP")){

                try {

                    File archivo = new File("..\\Proyecto-Final\\plantilla__M.deHonor\\MIP\\matrículaDeHonorMIP.docx");
                    Desktop.getDesktop().open(archivo);

                } catch (IOException ex) {

                    System.out.println(ex);
                }

            }

        }
    }
}
