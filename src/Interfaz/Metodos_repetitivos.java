package Interfaz;

import models.Usuario;

import javax.swing.*;
import java.awt.*;

public class Metodos_repetitivos extends JFrame{

    private static JLabel titulop;
    public static Font fuenteTitulo=new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 34);

    public static JPanel getjPanel() {
        JPanel titulo = new JPanel();
        titulo.setBackground(new Color(227, 247, 193));
        titulop = new JLabel("Bienvenido");
        titulo.add(titulop);
        return titulo;
    }
    public static Component Titulo() {
        JLabel titulo = new JLabel( "Bienvenido" );
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setBounds(687, -24, 298, 137);
        return titulo;
    }

    public static Component Usuario(Usuario user) {
        JLabel nombre = new JLabel(user.getNombre());
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(fuenteTitulo);
        nombre.setBounds(468, 69, 720, 49);
        return nombre;
    }

}
