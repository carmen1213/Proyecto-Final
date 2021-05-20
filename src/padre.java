
//imports necesarios

import models.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class padre {

    public padre(Usuario user) {

        JFrame general = new JFrame();
        JLayeredPane principal = new JLayeredPane();

        general.getContentPane().setBackground(new Color(230, 230, 250));
        general.getContentPane().add(principal, BorderLayout.CENTER);

        JLabel titulo = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html>");
        titulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34));
        titulo.setBounds(555, 25, 348, 82);

        JButton notasBtn = new JButton("Notas");
        notasBtn.setToolTipText("");
        notasBtn.setBackground(new Color(245, 255, 250));
        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));
        notasBtn.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        notasBtn.setBounds(91, 635, 184, 77);

        JLabel padresImagen = new JLabel("");
        padresImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\padres-mirando-sus-hijos-dibujando_13339-171519 (1).jpg"));
        padresImagen.setBounds(523, 177, 560, 331); //falta foto

        JButton reunionesBtn = new JButton("Reuniones");
        reunionesBtn.setBackground(new Color(245, 255, 250));
        reunionesBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenReuniones.png"));
        reunionesBtn.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        reunionesBtn.setBounds(430, 636, 234, 74);

        JButton xarxaBtn = new JButton("Libros");
        xarxaBtn.setBackground(new Color(245, 255, 250));
        xarxaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenLibros.png"));
        xarxaBtn.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        xarxaBtn.setBounds(827, 635, 222, 77);

        JButton compraPapeleria = new JButton("Papeleria");
        compraPapeleria.setBackground(new Color(245, 255, 250));
        compraPapeleria.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        compraPapeleria.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenCestaCompra.png"));
        compraPapeleria.setBounds(1203, 635, 245, 77);

        general.setForeground(new Color(230, 230, 250));
        general.setBackground(new Color(230, 230, 250));
        general.setBounds(100, 100, 1545, 759);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setVisible(true);

        //Insercciones a la GUI
        principal.add(notasBtn);
        principal.add(titulo);
        principal.add(padresImagen);
        principal.add(reunionesBtn);
        principal.add(xarxaBtn);
        principal.add(compraPapeleria);

        //Acciones
        reunionesBtn.addActionListener(new abrirCorreo());
        xarxaBtn.addActionListener(new inscripcionXarxa());
        compraPapeleria.addActionListener(new Compra());
    }

    public static void main(Usuario user) {
        new padre(user);
    }

    private static class abrirCorreo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WebDriver driver;

            String exePath = "C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\chromedriver.exe";
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

            String exePath = "C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\chromedriver.exe";
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

            String exePath = "C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.get("https://www.abacus.coop/es/papeleria-y-manualidades");
        }}

}