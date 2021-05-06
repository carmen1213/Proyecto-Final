
import models.Usuario;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class alumnoGUI extends JFrame {

    private JLabel titulop;
    Font f = new Font("Monospaced", BOLD, 30);


    public alumnoGUI(Usuario user) {
        super("alumno");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel titulo = new JPanel();
        titulop = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html> ");
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);

        add(titulo);

        setSize(650, 200);
        setVisible(true);
    }

    public static void main(Usuario user) {
        new alumnoGUI(user);

    }
}

