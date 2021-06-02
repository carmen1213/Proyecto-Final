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

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class padre {

    public static Font fuenteBotones = new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22);
    public static Font fuenteTitulo = new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34);
    JFrame general;

    public padre(Usuario user) {

        //Declaración de JFrame y JLayeredPane

        general = new JFrame();

        JLayeredPane principal = new JLayeredPane();

        //Declaración de JLabel

        JLabel padresImagen = new JLabel("");

        //Declaración de JButton

        JButton notasBtn = new JButton("Notas");

        JButton reunionesBtn = new JButton("Reuniones");

        JButton xarxaBtn = new JButton("Libros");

        JButton compraPapeleriaBtn = new JButton("Papeleria");

        JButton volverBtn = new JButton("");

        /* Modificaciones */

        //general

        general.getContentPane().setBackground(new Color(230, 230, 250));

        //notasBtn

        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));

        //reunionesBtn

        reunionesBtn.setBackground(new Color(245, 255, 250));
        reunionesBtn.setFont(fuenteBotones);
        reunionesBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenReuniones.png"));
        reunionesBtn.setBounds(430, 636, 234, 74);

        //XarxaBtn

        xarxaBtn.setBackground(new Color(245, 255, 250));
        xarxaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenLibros.png"));
        xarxaBtn.setFont(fuenteBotones);
        xarxaBtn.setBounds(827, 635, 222, 77);


        //CompraPapeleriaBtn

        compraPapeleriaBtn.setBackground(new Color(245, 255, 250));
        compraPapeleriaBtn.setFont(fuenteBotones);
        compraPapeleriaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenCestaCompra.png"));
        compraPapeleriaBtn.setBounds(1203, 635, 245, 77);

        //padresImagen

        padresImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenPadres.png"));
        padresImagen.setBounds(523, 177, 560, 331);

        //general

        general.setForeground(new Color(230, 230, 250));
        general.setBackground(new Color(230, 230, 250));
        general.setBounds(100, 100, 1545, 759);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setVisible(true);

        //Insercciones a la GUI

        general.getContentPane().add(principal, BorderLayout.CENTER);

        principal.add(Metodos_repetitivos.Botones(notasBtn));
        principal.add(Metodos_repetitivos.Titulo());
        principal.add(Metodos_repetitivos.Usuario(user));
        principal.add(padresImagen);
        principal.add(reunionesBtn);
        principal.add(xarxaBtn);
        principal.add(compraPapeleriaBtn);
        principal.add(Metodos_repetitivos.volverBoton(volverBtn));

        //Acciones

        reunionesBtn.addActionListener(new abrirCorreo());

        xarxaBtn.addActionListener(new inscripcionXarxa());

        compraPapeleriaBtn.addActionListener(new Compra());

        volverBtn.addMouseListener(new volverInicio());

    }


    public static void main(Usuario user) {
        new padre(user);
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

    private static class inscripcionXarxa implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WebDriver driver;

            String exePath = "..\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.get("https://www.gva.es/es/inicio/procedimientos?id_proc=18094");
        }
    }

    private static class Compra implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WebDriver driver;

            String exePath = "..\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.get("https://www.abacus.coop/es/papeleria-y-manualidades");
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
}