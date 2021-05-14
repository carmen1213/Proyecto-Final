
import models.Usuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

public class padre {

    private JFrame frame;
    private final JButton btnNewButton_2 = new JButton("Papeleria");

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     * @param user
     */
    public padre(Usuario user) {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(230, 230, 250));

        JLayeredPane layeredPane = new JLayeredPane();
        frame.getContentPane().add(layeredPane, BorderLayout.CENTER);

        JLabel Titulo = new JLabel(" Bienvenido ");
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 34));
        Titulo.setBounds(555, 25, 348, 82);
        layeredPane.add(Titulo);

        JButton Notas = new JButton("Notas");
        Notas.setToolTipText("");
        Notas.setBackground(new Color(245, 255, 250));
        Notas.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\notasicono.jpg"));
        Notas.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        Notas.setBounds(91, 635, 184, 77);
        layeredPane.add(Notas);

        JLabel Imagenpadres = new JLabel("");
        Imagenpadres.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\padres-mirando-sus-hijos-dibujando_13339-171519 (1).jpg"));
        Imagenpadres.setBounds(523, 177, 560, 331);
        layeredPane.add(Imagenpadres);

        JButton btnNewButton = new JButton("Reuniones");
        btnNewButton.setBackground(new Color(245, 255, 250));
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\reuniones.jpg"));
        btnNewButton.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(430, 636, 234, 74);
        layeredPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Libros");
        btnNewButton_1.setBackground(new Color(245, 255, 250));
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\kisspng-clip-art-book-image-cartoon-desktop-wallpaper-fancy-reindeer-cliparts-free-download-clip-art-c-5c58934c924d13.8492565215493087485993 (1).jpg"));
        btnNewButton_1.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        btnNewButton_1.setBounds(827, 635, 222, 77);
        layeredPane.add(btnNewButton_1);
        btnNewButton_2.setBackground(new Color(245, 255, 250));
        btnNewButton_2.setFont(new Font("Matura MT Script Capitals", Font.BOLD | Font.ITALIC, 22));
        btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\cestacompra (1).jpg"));
        btnNewButton_2.setBounds(1203, 635, 245, 77);
        layeredPane.add(btnNewButton_2);
        frame.setForeground(new Color(230, 230, 250));
        frame.setBackground(new Color(230, 230, 250));
        frame.setBounds(100, 100, 1545, 759);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }


    public static void main(Usuario user) {
        new padre(user);

    }
}

