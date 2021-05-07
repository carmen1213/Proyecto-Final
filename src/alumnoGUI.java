
import models.Usuario;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class alumnoGUI extends JFrame {

    private JLabel titulop;
    Font f = new Font("Monospaced", BOLD, 30);


    public alumnoGUI(Usuario user) {
        super("Alumno");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new FlowLayout());
        this.getContentPane().setBackground(new Color(179, 253, 255 ));

        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        general.setBackground(Color.PINK);

        JPanel menu = new JPanel();
        this.getContentPane().setBackground(new Color(179, 253, 255 ));

        JMenuBar barraMenu = new JMenuBar();

        menu.add(barraMenu);


        JMenu expediente = new JMenu("Expediente");
        JMenu quejas = new JMenu("Quejas");
        JMenu cuestionarios = new JMenu("Cuestioarios");
        JMenu tareas = new JMenu("Tareas");


        barraMenu.add(expediente);
        barraMenu.add(quejas);
        barraMenu.add(cuestionarios);
        barraMenu.add(tareas);
        setJMenuBar(barraMenu);

        JPanel principal = new JPanel();
        principal.setLayout(new GridLayout(4, 1));
        principal.setBackground(new Color(179, 253, 255));

        JPanel titulo = new JPanel();
        titulo.setBackground(new Color(179, 253, 255 ));
        titulop = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html> ");
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);


        principal.add(titulo);
        general.add(principal);
        add(general);

        setSize(650, 600);
        setVisible(true);
    }

    public static void main(Usuario user) {
        new alumnoGUI(user);

    }



}

