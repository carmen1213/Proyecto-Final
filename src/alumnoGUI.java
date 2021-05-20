
//import necesarios

import models.Usuario;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

public class alumnoGUI {

    public alumnoGUI(Usuario user) {

         JFrame general = new JFrame();
        general.setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Proyecto-Final\\imagenes\\logoEncabezado.png"));
        general.setTitle("Alumnos");
        general.getContentPane().setBackground(new Color(250, 250, 210));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);

        JLabel titulo = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido <br>  " + user.getNombre() + " </div></html>");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34));
        titulo.setBounds(615, 0, 303, 184);
        principal.add(titulo);

        JLabel alumnosImagen = new JLabel("");
        alumnosImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenAlumnos.jpg"));
        alumnosImagen.setBounds(371, 158, 840, 438);
        principal.add(alumnosImagen);

        JButton notasBtn = new JButton("Notas");
        notasBtn.setBackground(new Color(255, 222, 173));
        notasBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenNotas.png"));
        notasBtn.setFont(new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 22));
        notasBtn.setBounds(371, 663, 216, 71);
        principal.add(notasBtn);

        JButton horarioBtn = new JButton("Horario");
        horarioBtn.setBackground(new Color(255, 222, 173));
        horarioBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenHorario.png"));
        horarioBtn.setFont(new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 22));
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
        expedientesMenu.setFont(new Font("Rockwell", Font.BOLD, 17));
        barraMenu.add(expedientesMenu);

        JMenu quejasMenu = new JMenu("Quejas");
        quejasMenu.addMenuListener(new abrirQuejas());
        quejasMenu.setFont(new Font("Rockwell", Font.BOLD, 17));
        barraMenu.add(quejasMenu);

        JMenu cuestionariosMenu = new JMenu("Cuestionarios");
        cuestionariosMenu.setFont(new Font("Rockwell", Font.BOLD, 17));
        barraMenu.add(cuestionariosMenu);

        JMenu TareasMenu = new JMenu("Tareas");
        TareasMenu.setFont(new Font("Rockwell", Font.BOLD, 17));
        barraMenu.add(TareasMenu);

        general.setVisible(true);
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
}

