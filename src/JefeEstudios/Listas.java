package JefeEstudios;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static java.awt.Font.BOLD;

public class Listas extends JFrame {
    private JLabel titulop;
    Font f = new Font("fantasy", BOLD, 30);

    public Listas(){
        super("Listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.PINK);

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(3, 1));
        general.setBackground(Color.PINK);

        JPanel titulo = new JPanel();
        titulo.setBackground(Color.PINK);
        JLabel titulop = new JLabel("HORARIO");
        titulop.setFont(f);
        titulo.add(titulop);


        general.add(titulo);
        add(general,BorderLayout.CENTER);


        setSize(860, 530);
        setVisible(true);



    }



    public static void main() {
        Listas listas = new Listas();
    }
}
