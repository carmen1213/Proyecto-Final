package Interfaz;

import models.Usuario;

import javax.swing.*;
import java.awt.*;

public class Metodos_repetitivos extends JFrame {

    public static Font fuenteTitulo = new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 51);
    public static Font fuenteBotones = new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22);
    private static JLabel titulo;

    public static JPanel getjPanel() {
        JPanel encabezado = new JPanel();
        encabezado.setBackground(new Color(227, 247, 193));
        titulo = new JLabel("Bienvenido");
        encabezado.add(titulo);
        return encabezado;
    }

    public static Component Titulo() {
        JLabel titulo = new JLabel("Bienvenido");
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

    public static Component Botones(JButton boton) {
        boton.setToolTipText("");
        boton.setBackground(new Color(245, 255, 250));
        boton.setFont(fuenteBotones);
        boton.setBounds(91, 635, 184, 77);
        return boton;
    }

    public static Component volverBoton(JButton volverBtn) {
        volverBtn.setBackground(new Color(204, 255, 204));
        volverBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenVolver.png"));
        volverBtn.setBounds(10, 10, 80, 49);

        volverBtn.setBorderPainted(false);
        volverBtn.setContentAreaFilled(false);
        volverBtn.setFocusPainted(false);
        volverBtn.setOpaque(false);
        return volverBtn;
    }


}
