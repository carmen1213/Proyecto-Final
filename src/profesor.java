
//imports necesarios

import models.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class profesor {

    public profesor(Usuario user) {

        JFrame general = new JFrame();
        general.setVisible(true);
        general.getContentPane().setBackground(new Color(204, 255, 204));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);

        JLabel titulo = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html>");
        titulo.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 51));
        titulo.setBounds(663, 10, 278, 110);
        principal.add(titulo);

        JLabel profesoresImagen = new JLabel("");
        profesoresImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenProfesores.jpg"));
        profesoresImagen.setBounds(444, 130, 704, 474);
        principal.add(profesoresImagen);

        JButton BotonHorario = new JButton("Horario");
        BotonHorario.setBackground(new Color(204, 255, 255));
        BotonHorario.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenHorario.png"));
        BotonHorario.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 22));
        BotonHorario.setBounds(111, 645, 247, 81);
        principal.add(BotonHorario);

        JButton BotonReuniones = new JButton("Reuniones");
        BotonReuniones.setBackground(new Color(204, 255, 255));
        BotonReuniones.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenReuniones.png"));
        BotonReuniones.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
        BotonReuniones.setBounds(1243, 645, 247, 81);
        principal.add(BotonReuniones);
        general.setBounds(100, 100, 1554, 1140);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JMenuBar BarraMenu = new JMenuBar();
        BarraMenu.setBackground(new Color(204, 255, 204));
        general.setJMenuBar(BarraMenu);

        JButton BotonNotas = new JButton("Notas");
        BotonNotas.setBackground(new Color(204, 255, 255));
        BotonNotas.setIcon(new ImageIcon("..\\Trabajo final\\imagenes\\notasicono.jpg"));
        BotonNotas.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
        BotonNotas.setBounds(694, 656, 247, 70);
        principal.add(BotonNotas);


        JMenu listasMenu = new JMenu("Listas");
        listasMenu.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
        BarraMenu.add(listasMenu);

        JMenu materialMenu = new JMenu("Material");
        materialMenu.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));

        JMenuItem DAM;
        JMenuItem CIN;
        JMenuItem MIP;

        DAM = new JMenuItem("DAM");
        DAM.addActionListener(new EscMaterialDAM());
        CIN = new JMenuItem("CIN");
        CIN.addActionListener(new EscMaterialCIN());
        MIP = new JMenuItem("MIP");
        MIP.addActionListener(new EscMaterialMIP());

        materialMenu.add(DAM);
        materialMenu.add(CIN);
        materialMenu.add(MIP);
        BotonReuniones.addActionListener(new abrirCorreo());

        BarraMenu.add(materialMenu);
    }

    public static void main(Usuario user) {
        new profesor(user);
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


}