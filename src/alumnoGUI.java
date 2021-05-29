
//import necesarios

import Interfaz.Metodos_repetitivos;
import models.Usuario;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class alumnoGUI {

    public static Font fuenteGeneral=new Font("Rockwell", Font.BOLD, 17);
    public static Font fuenteTitulo=new Font("Segoe Script",Font.BOLD | Font.ITALIC, 34);
    public static Font fuenteBotones=new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 22);

    JFrame general;
    public alumnoGUI(Usuario user) {

        general = new JFrame();
        general.setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Proyecto-Final\\imagenes\\logoEncabezado.png"));
        general.setTitle("Alumnos");
        general.getContentPane().setBackground(new Color(250, 250, 210));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);

        principal.add(Metodos_repetitivos.Titulo());
        principal.add(Metodos_repetitivos.Usuario(user));

        JLabel alumnosImagen = new JLabel("");
        alumnosImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenAlumnos.jpg"));
        alumnosImagen.setBounds(371, 158, 840, 438);
        principal.add(alumnosImagen);

        JButton notasBtn = new JButton("Notas");
        notasBtn.setBackground(new Color(255, 222, 173));
        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));
        notasBtn.setFont(fuenteBotones);
        notasBtn.setBounds(371, 663, 216, 71);
        principal.add(notasBtn);

        JButton horarioBtn = new JButton("Horario");
        horarioBtn.setBackground(new Color(255, 222, 173));
        horarioBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenHorario.png"));
        horarioBtn.setFont(fuenteBotones);
        horarioBtn.setBounds(1006, 663, 216, 71);
        principal.add(horarioBtn);
        general.setBounds(100, 100, 1364, 828);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(new Color(250, 250, 210));
        barraMenu.setForeground(new Color(255, 255, 255));
        general.setJMenuBar(barraMenu);

        JMenu expedientesMenu = new JMenu("Expedientes");
        expedientesMenu.setHorizontalAlignment(SwingConstants.CENTER);
        expedientesMenu.setFont(fuenteGeneral);
        barraMenu.add(expedientesMenu);

        JMenu quejasMenu = new JMenu("Quejas");
        quejasMenu.addMenuListener(new abrirQuejas());
        quejasMenu.setFont(fuenteGeneral);
        barraMenu.add(quejasMenu);

        JMenu cuestionariosMenu = new JMenu("Cuestionarios");
        cuestionariosMenu.setFont(fuenteGeneral);
        barraMenu.add(cuestionariosMenu);

        JMenu TareasMenu = new JMenu("Tareas");
        TareasMenu.setFont(fuenteGeneral);
        barraMenu.add(TareasMenu);
        general.setVisible(true);

        JButton volverBtn = new JButton("");
        volverBtn.addMouseListener(new volverInicio());
        principal.add(Metodos_repetitivos.volverBoton(volverBtn));

    }


    public static void main(Usuario user) {
      new alumnoGUI(user);

    }

    private class abrirQuejas implements MenuListener {
        @Override
        public void menuSelected(MenuEvent e) {
            try {

                File archivo = new File("..\\Proyecto-Final\\Quejas\\alumnoQueja.docx");
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
}

