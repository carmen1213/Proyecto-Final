import models.Usuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import java.awt.Toolkit;

public class alumnoGUI {

    private JFrame frmAlumnos;

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public alumnoGUI(Usuario user) {
        initialize(user);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Usuario user) {
        frmAlumnos = new JFrame();
        frmAlumnos.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\carma\\Downloads\\MicrosoftTeams-image.png"));
        frmAlumnos.setTitle("Alumnos");
        frmAlumnos.getContentPane().setBackground(new Color(250, 250, 210));

        JLayeredPane layeredPane = new JLayeredPane();
        frmAlumnos.getContentPane().add(layeredPane, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("Bienvenido");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34));
        lblNewLabel.setBounds(615, 0, 303, 184);
        layeredPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\conectar-con-los-alumnos.jpg"));
        lblNewLabel_1.setBounds(371, 158, 840, 438);
        layeredPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Notas");
        btnNewButton.setBackground(new Color(255, 222, 173));
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\icono-de-mezcla-para-port\u00E1tiles-estudiantes-y-notas-editorial-escritor-diario-papel-conocimiento-estudiante-161744179 (1).jpg"));
        btnNewButton.setFont(new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 22));
        btnNewButton.setBounds(371, 663, 216, 71);
        layeredPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Horario");
        btnNewButton_1.setBackground(new Color(255, 222, 173));
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\horario.jpg"));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setFont(new Font("Berlin Sans FB", Font.BOLD | Font.ITALIC, 22));
        btnNewButton_1.setBounds(1006, 663, 216, 71);
        layeredPane.add(btnNewButton_1);
        frmAlumnos.setBounds(100, 100, 1364, 828);
        frmAlumnos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(250, 250, 210));
        menuBar.setForeground(new Color(255, 255, 255));
        frmAlumnos.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Expedientes");
        mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
        mnNewMenu.setFont(new Font("Rockwell", Font.BOLD, 17));
        menuBar.add(mnNewMenu);

        JMenu mnNewMenu_1 = new JMenu("Quejas");
        mnNewMenu_1.setFont(new Font("Rockwell", Font.BOLD, 17));
        menuBar.add(mnNewMenu_1);

        JMenu Cuestionarios = new JMenu("Cuestionarios");
        Cuestionarios.setFont(new Font("Rockwell", Font.BOLD, 17));
        menuBar.add(Cuestionarios);

        JMenu Tareas = new JMenu("Tareas");
        Tareas.setFont(new Font("Rockwell", Font.BOLD, 17));
        menuBar.add(Tareas);

        frmAlumnos.setVisible(true);
    }


    public static void main(Usuario user) {
     alumnoGUI alumnoGUI  = new alumnoGUI(user);

    }

}

