
//imports necesarios

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
    JFrame general;

    public static Font fuenteBotones=new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22);
    public static Font fuenteTitulo=new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34);

    public padre(Usuario user) {

        general = new JFrame();
        JLayeredPane principal = new JLayeredPane();

        general.getContentPane().setBackground(new Color(230, 230, 250));
        general.getContentPane().add(principal, BorderLayout.CENTER);

        JLabel titulo = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html>");
        titulo.setFont(fuenteTitulo);
        titulo.setBounds(567, 25, 348, 82);

        JButton notasBtn = new JButton("Notas");
        notasBtn.setToolTipText("");
        notasBtn.setBackground(new Color(245, 255, 250));
        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));
        notasBtn.setFont(fuenteBotones);
        notasBtn.setBounds(91, 635, 184, 77);

        JLabel padresImagen = new JLabel("");
        padresImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenPadres.png"));
        padresImagen.setBounds(523, 177, 560, 331);

        JButton reunionesBtn = new JButton("Reuniones");
        reunionesBtn.setBackground(new Color(245, 255, 250));
        reunionesBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenReuniones.png"));
        reunionesBtn.setFont(fuenteBotones);
        reunionesBtn.setBounds(430, 636, 234, 74);

        JButton xarxaBtn = new JButton("Libros");
        xarxaBtn.setBackground(new Color(245, 255, 250));
        xarxaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenLibros.png"));
        xarxaBtn.setFont(fuenteBotones);
        xarxaBtn.setBounds(827, 635, 222, 77);

        JButton compraPapeleriaBtn = new JButton("Papeleria");
        compraPapeleriaBtn.setBackground(new Color(245, 255, 250));
        compraPapeleriaBtn.setFont(fuenteBotones);
        compraPapeleriaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenCestaCompra.png"));
        compraPapeleriaBtn.setBounds(1203, 635, 245, 77);

        general.setForeground(new Color(230, 230, 250));
        general.setBackground(new Color(230, 230, 250));
        general.setBounds(100, 100, 1545, 759);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setVisible(true);

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

        //Insercciones a la GUI
        principal.add(notasBtn);
        principal.add(titulo);
        principal.add(padresImagen);
        principal.add(reunionesBtn);
        principal.add(xarxaBtn);
        principal.add(compraPapeleriaBtn);

        //Acciones
        reunionesBtn.addActionListener(new abrirCorreo());
        xarxaBtn.addActionListener(new inscripcionXarxa());
        compraPapeleriaBtn.addActionListener(new Compra());
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
        }}

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
        }}

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
        }}
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