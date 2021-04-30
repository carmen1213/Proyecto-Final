
import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class padre extends JFrame {

    private JLabel titulop;
    Font f = new Font("Monospaced", BOLD, 30);

    public padre() {
        super("padre");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel titulo= new JPanel();
        titulop=new JLabel("Bienvenido " + inicio.usuario.getText());
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);

        add(titulo);

        setSize(650, 200);
        setVisible(true);
    }

    public static void main() {
        new padre();

    }
}

