
//imports necesarios

import Controladores.ControladorTablaProfesores;
import Controladores.Controlador_cursos_material_profesores;
import Controladores.Controlador_login;
import models.Asignatura;
import models.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class profesor {

    JFrame general;
    private Controlador_login control = new Controlador_login();
    private Controlador_cursos_material_profesores controlador_cursos_material_profesores = new Controlador_cursos_material_profesores();
    private String cursos = Controlador_cursos_material_profesores.getCursoProfesor(control.getIdProfesor(inicio.usuario.getText(), inicio.contraseņa.getText()).getId_profesor());


    public profesor(Usuario user) {

        general = new JFrame();
        general.setVisible(true);
        general.getContentPane().setBackground(new Color(204, 255, 204));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);

        JLabel titulo = new JLabel("Bienvenido");
        titulo.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 51));
        titulo.setBounds(640, -11, 278, 110);
        principal.add(titulo);

        JLabel nombre = new JLabel(user.getNombre());
        nombre.setForeground(new Color(199, 21, 133));
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 51));
        nombre.setBounds(111, 68, 1301, 76);
        principal.add(nombre);

        JLabel profesoresImagen = new JLabel("");
        profesoresImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenProfesores.jpg"));
        profesoresImagen.setBounds(444, 130, 704, 474);
        principal.add(profesoresImagen);

        JButton horarioBtn = new JButton("Horario");
        horarioBtn.setBackground(new Color(204, 255, 255));
        horarioBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenHorario.png"));
        horarioBtn.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
        horarioBtn.setBounds(111, 645, 247, 81);
        principal.add(horarioBtn);

        JButton reunionesBtn = new JButton("Reuniones");
        reunionesBtn.setBackground(new Color(204, 255, 255));
        reunionesBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenReuniones.png"));
        reunionesBtn.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
        reunionesBtn.setBounds(1243, 645, 247, 81);
        principal.add(reunionesBtn);
        general.setBounds(100, 100, 1554, 1140);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JMenuBar BarraMenu = new JMenuBar();
        BarraMenu.setBackground(new Color(204, 255, 204));
        general.setJMenuBar(BarraMenu);

        JButton notasBtn = new JButton("Notas");
        notasBtn.addActionListener(new agregarNotas());
        notasBtn.setBackground(new Color(204, 255, 255));
        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));
        notasBtn.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
        notasBtn.setBounds(694, 656, 247, 70);
        principal.add(notasBtn);

        JButton volverBtn = new JButton("");
        volverBtn.addMouseListener(new volverInicio());

        volverBtn.setBackground(new Color(204, 255, 204));
        volverBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenVolver.png"));
        volverBtn.setBounds(10, 10, 80, 49);

        volverBtn.setBorderPainted(false);
        volverBtn.setContentAreaFilled(false);
        volverBtn.setFocusPainted(false);
        volverBtn.setOpaque(false);
        principal.add(volverBtn);

        JMenu listasMenu = new JMenu("Listas");
        listasMenu.addMenuListener(new verasistencia());
        listasMenu.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
        BarraMenu.add(listasMenu);

        JMenu materialMenu = new JMenu("Material");
        materialMenu.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));

        JMenuItem curso;


        curso = new JMenuItem(String.valueOf(cursos));
        curso.addActionListener(new EscMaterial());


        materialMenu.add(curso);
        reunionesBtn.addActionListener(new abrirCorreo());

        BarraMenu.add(materialMenu);

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
            }}}


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
            inicio.contraseņa.setText("");

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
            if (cursos.equals("Mip")){
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
            if (cursos.equals("CIN")){
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