
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
 * @author Carmen Mart�,Salva Blanquer,Lucia Calabrese
 */

public class padre {

    //Declaraci�n de Variables

    private final JLayeredPane principal;

    private final JLabel Titulo;
    private final JLabel imagenPadres;

    private final JButton notasBtn;
    private final JButton reunionesBtn;
    private final JButton xarxaBtn;
    private final JButton compraPapeleria;

    private final JFrame general;

    public padre(Usuario user) {

        general = new JFrame();
        principal = new JLayeredPane();

        general.getContentPane().setBackground(new Color(230, 230, 250));
        general.getContentPane().add(principal, BorderLayout.CENTER);

        Titulo = new JLabel(" Bienvenido ");
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34));
        Titulo.setBounds(555, 25, 348, 82);

        notasBtn = new JButton("Notas");
        notasBtn.setToolTipText("");
        notasBtn.setBackground(new Color(245, 255, 250));
        notasBtn.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\notasIcono.jpg"));
        notasBtn.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        notasBtn.setBounds(91, 635, 184, 77);

        imagenPadres = new JLabel("");
        imagenPadres.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\padres-mirando-sus-hijos-dibujando_13339-171519 (1).jpg"));
        imagenPadres.setBounds(523, 177, 560, 331);

        reunionesBtn = new JButton("Reuniones");
        reunionesBtn.setBackground(new Color(245, 255, 250));
        reunionesBtn.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\reuniones.jpg"));
        reunionesBtn.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        reunionesBtn.setBounds(430, 636, 234, 74);

        xarxaBtn = new JButton("Libros");
        xarxaBtn.setBackground(new Color(245, 255, 250));
        xarxaBtn.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\libros.jpg"));
        xarxaBtn.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        xarxaBtn.setBounds(827, 635, 222, 77);

        compraPapeleria = new JButton("Papeleria");
        compraPapeleria.setBackground(new Color(245, 255, 250));
        compraPapeleria.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        compraPapeleria.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\cestaCompra.jpg"));
        compraPapeleria.setBounds(1203, 635, 245, 77);

        general.setForeground(new Color(230, 230, 250));
        general.setBackground(new Color(230, 230, 250));
        general.setBounds(100, 100, 1545, 759);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setVisible(true);

        //Insercciones a la GUI
        principal.add(notasBtn);
        principal.add(Titulo);
        principal.add(imagenPadres);
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

    private class abrirCorreo implements ActionListener {
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

    private class inscripcionXarxa implements ActionListener {
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

    private class Compra implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            WebDriver driver;

            String exePath = "C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.get("https://www.abacus.coop/es/papeleria-y-manualidades");
        }}}