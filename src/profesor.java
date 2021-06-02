//imports necesarios

import Controladores.Controlador_cursos_material_profesores;
import Controladores.Controlador_login;
import Interfaz.Metodos_repetitivos;
import models.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class profesor {

    public static Font fuenteBotones = new Font("Copperplate Gothic Bold", Font.PLAIN, 22);
    public static Font fuenteTitulo = new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 51);
    public static Font fuenteMenu = new Font("Rockwell Condensed", Font.BOLD, 18);
    private final Controlador_login control = new Controlador_login();
    private final Controlador_cursos_material_profesores controlador_cursos_material_profesores = new Controlador_cursos_material_profesores();
    private final String cursos = Controlador_cursos_material_profesores.getCursoProfesor(control.getIdProfesor(inicio.usuario.getText(), inicio.contraseña.getText()).getId_profesor());
    JFrame general;

    public profesor(Usuario user) {

        //Declaración de JFrame y JLayeredPane

        general = new JFrame();

        JLayeredPane principal = new JLayeredPane();

        //Declaración de JLabel

        JLabel profesoresImagen = new JLabel("");

        //Declaración de JButton

        JButton horarioBtn = new JButton("Horario");

        JButton reunionesBtn = new JButton("Reuniones");

        JButton notasBtn = new JButton("Notas");

        JButton volverBtn = new JButton("");

        //Declaración de JMenu,JMenuBar y JMenuItem

        JMenuBar BarraMenu = new JMenuBar();

        JMenu listasMenu = new JMenu("Listas");

        JMenu materialMenu = new JMenu("Material");

        JMenuItem curso;

        curso = new JMenuItem(String.valueOf(cursos));

        /* Modificaciones */

        //general

        general.getContentPane().setBackground(new Color(204, 255, 204));
        general.setVisible(true);
        general.setBounds(100, 100, 1554, 1140);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setJMenuBar(BarraMenu);

        //profesorImagen

        profesoresImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenProfesores.jpg"));
        profesoresImagen.setBounds(444, 130, 704, 474);

        //horarioBtn

        horarioBtn.setBackground(new Color(204, 255, 255));
        horarioBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenHorario.png"));
        horarioBtn.setFont(fuenteBotones);
        horarioBtn.setBounds(111, 645, 247, 81);

        //reunionesBtn

        reunionesBtn.setBackground(new Color(204, 255, 255));
        reunionesBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenReuniones.png"));
        reunionesBtn.setFont(fuenteBotones);
        reunionesBtn.setBounds(1243, 645, 247, 81);

        //notasBtn

        notasBtn.setBackground(new Color(204, 255, 255));
        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));
        notasBtn.setFont(fuenteBotones);
        notasBtn.setBounds(694, 656, 247, 70);

        //Menus

        BarraMenu.setBackground(new Color(204, 255, 204));

        listasMenu.setFont(fuenteMenu);

        materialMenu.setFont(fuenteMenu);

        //Insercciones a la GUI

        general.getContentPane().add(principal, BorderLayout.CENTER);

        principal.add(notasBtn);
        principal.add(Metodos_repetitivos.volverBoton(volverBtn));

        BarraMenu.add(listasMenu);

        materialMenu.add(curso);

        BarraMenu.add(materialMenu);

        principal.add(Metodos_repetitivos.Titulo());
        principal.add(Metodos_repetitivos.Usuario(user));
        principal.add(profesoresImagen);
        principal.add(horarioBtn);
        principal.add(reunionesBtn);

        //Acciones

        notasBtn.addActionListener(new agregarNotas());

        volverBtn.addMouseListener(new volverInicio());

        listasMenu.addMenuListener(new verasistencia());

        curso.addActionListener(new EscMaterial());

        reunionesBtn.addActionListener(new abrirCorreo());

    }

    public static void main(Usuario user) {
        new profesor(user);
    }

    private static class abrirCorreo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WebDriver driver;

            String exePath = "..\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.get("https://outlook.live.com/owa/");
        }
    }

    private class agregarNotas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new Boletin_alumnos();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    private class verasistencia implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            try {
                new tabla_profesor();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

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


    private class EscMaterial implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (cursos.equals("Dam")) {
                Scanner entrada = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\MaterialDAM"));
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
            if (cursos.equals("Mip")) {
                Scanner entrada = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\MaterialMIP"));
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
            if (cursos.equals("CIN")) {
                Scanner entrada = null;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("..\\Proyecto-Final\\MaterialCIN"));
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
    }
}