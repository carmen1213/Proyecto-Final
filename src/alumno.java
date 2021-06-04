//import necesarios

import Controladores.Controlador_cursos_material_profesores;
import Controladores.Controlador_login;
import Controladores.Controlador_recompensas_alumno;
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
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class alumno {

    public static Font fuenteGeneral = new Font("Rockwell", Font.BOLD, 17);
    public static Font fuenteTitulo = new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34);
    public static Font fuenteBotones = new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 22);
    JFrame general;
    public static Controlador_recompensas_alumno controlRecompensas = new Controlador_recompensas_alumno();
    //llama a la clase controlador del login para poder usar a continuacion sus diferentes metodos
    public static Controlador_login controllogin = new Controlador_login();
    private static String cursos;

    public alumno(Usuario user) {
        cursos = Controlador_recompensas_alumno.getCursoAlumno(controllogin.nombredelusuario(inicio.usuario.getText()));

        //Declaración de JFrame y JLayeredPane

        general = new JFrame();

        JLayeredPane principal = new JLayeredPane();

        //Declaración de JLabel

        JLabel alumnosImagen = new JLabel("");

        //Declaración de JButton

        JButton notasBtn = new JButton("Notas");
        JButton horarioBtn = new JButton("Horario");

        JButton volverBtn = new JButton("");

        //Declaración de JMenu y JMenuBar

        JMenu recompensasMenu = new JMenu("Recompensas");
        JMenu quejasMenu = new JMenu("Quejas");
        JMenu cuestionariosMenu = new JMenu("Cuestionarios");
        JMenuBar barraMenu = new JMenuBar();

        /* Modificaciones */

        //general
        general.getContentPane().setBackground(new Color(250, 250, 210));
        general.setTitle("Alumnos");
        general.setVisible(true);
        general.setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Proyecto-Final\\imagenes\\logoEncabezado.png"));
        general.setBounds(100, 100, 1364, 828);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setJMenuBar(barraMenu);

        //alumnosImagen

        alumnosImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenAlumnos.jpg"));
        alumnosImagen.setBounds(371, 158, 840, 438);

        //notasBtn

        notasBtn.setBackground(new Color(255, 222, 173));
        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));
        notasBtn.setFont(fuenteBotones);
        notasBtn.setBounds(371, 663, 216, 71);

        //horarioBtn

        horarioBtn.setBackground(new Color(255, 222, 173));
        if (inicio.usuario.getText().equals("Sblanquer")) {
            horarioBtn.addActionListener(new verhorario());
        }
        horarioBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenHorario.png"));
        horarioBtn.setFont(fuenteBotones);
        horarioBtn.setBounds(1006, 663, 216, 71);

        //Menus

        barraMenu.setBackground(new Color(250, 250, 210));
        barraMenu.setForeground(new Color(255, 255, 255));

        recompensasMenu.setHorizontalAlignment(SwingConstants.CENTER);
        recompensasMenu.setFont(fuenteGeneral);

        quejasMenu.setFont(fuenteGeneral);

        cuestionariosMenu.setFont(fuenteGeneral);


        //Insercciones a la GUI

        general.getContentPane().add(principal, BorderLayout.CENTER);
        principal.add(Metodos_repetitivos.Titulo());
        principal.add(Metodos_repetitivos.Usuario(user));
        principal.add(alumnosImagen);
        principal.add(notasBtn);
        principal.add(horarioBtn);

        barraMenu.add(recompensasMenu);

        barraMenu.add(quejasMenu);
        barraMenu.add(cuestionariosMenu);


        principal.add(Metodos_repetitivos.volverBoton(volverBtn));

        //Acciones
        quejasMenu.addMenuListener(new abrirQuejas());
        cuestionariosMenu.addMenuListener(new verFormularios());
        volverBtn.addMouseListener(new volverInicio());
        notasBtn.addActionListener(new verNotas());
        recompensasMenu.addMenuListener(new escRecompensas());



        if (inicio.usuario.getText().equals("Sblanquer")) {
            horarioBtn.addActionListener(new verhorario());
        }
    }

    public static void main(Usuario user) {
        new alumno(user);

    }

    private class abrirQuejas implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            try {

                File archivo = new File("..\\Proyecto-Final\\plantilla__Quejas\\alumnoQueja.docx");
                Desktop.getDesktop().open(archivo);

            } catch (IOException ex) {

                System.out.println(ex);
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


    private class verNotas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new Alumnos_notas();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private class verFormularios implements MenuListener {

        @Override
        public void menuSelected(MenuEvent e) {
            WebDriver driver;

            String exePath = "..\\Proyecto-Final\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", exePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://www.google.es/intl/es/forms/about/");
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }

    private class verhorario implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new horario();
        }
    }

    private class escRecompensas implements MenuListener {

        @Override
        public void menuSelected(MenuEvent e) {

            if (cursos.equals("Dam")) {
                try {

                    File archivo = new File("..\\Proyecto-Final\\m.deHonor__Rellenas\\MatrículaDeHonorDAM\\matrículaDeHonorDAM_Rellena.pdf");
                    Desktop.getDesktop().open(archivo);

                } catch (IOException ex) {

                    System.out.println(ex);
                }

            }
             if (cursos.equals("CIN"))  {
                try {

                    File archivo = new File("..\\Proyecto-Final\\m.deHonor__Rellenas\\MatrículaDeHonorCIN\\matrículaDeHonorCIN_Rellena.pdf");
                    Desktop.getDesktop().open(archivo);

                } catch (IOException ex) {

                    System.out.println(ex);
                }
            }
             if (cursos.equals("Mip"))  {

                try {

                    File archivo = new File("..\\Proyecto-Final\\m.deHonor__Rellenas\\MatrículaDeHonorMIP\\matrículaDeHonorMIP_Rellena.pdf");
                    Desktop.getDesktop().open(archivo);

                } catch (IOException ex) {

                    System.out.println(ex);
                }
            }
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }

}

