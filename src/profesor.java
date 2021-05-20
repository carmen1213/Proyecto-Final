
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

        JLabel titulo = new JLabel("Bienvenido");
        titulo.setFont(new Font("Script MT Bold", Font.BOLD | Font.ITALIC, 51));
        titulo.setBounds(663, 10, 278, 110);
        principal.add(titulo);

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

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(new Color(204, 255, 204));
        general.setJMenuBar(barraMenu);

        JMenu listasMenu = new JMenu("Listas");
        listasMenu.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
        barraMenu.add(listasMenu);

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
     reunionesBtn.addActionListener(new abrirCorreo());

        barraMenu.add( materialMenu);
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

   String exePath = "C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\chromedriver.exe";
   System.setProperty("webdriver.chrome.driver", exePath);

   ChromeOptions options = new ChromeOptions();
   options.addArguments("--start-maximized");

   driver = new ChromeDriver(options);
   driver.get("https://outlook.live.com/owa/");
  }}


}