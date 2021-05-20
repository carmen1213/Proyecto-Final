import Controladores.Controlador_login;
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.Font.BOLD;

public class inicio extends JFrame {
    public static JTextField usuario;
    public static JTextField contraseña;
    private static JLabel confirmacion;
    private static final Controlador_login controlLogin = new Controlador_login();
    private final JLabel denegacion;
    Font f = new Font("Monospaced", BOLD, 24);
    private final JLabel titulo;
    private final JButton login;

    public inicio() {
        super("Inicio");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setLayout(new FlowLayout());

        JPanel pricipal = new JPanel();
        pricipal.setLayout(new GridLayout(2, 1));

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BorderLayout());
        this.titulo = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido, <br> Accede a tus datos! </div></html>");
        this.titulo.setFont(f);
        this.titulo.setForeground(new Color(140, 24, 82));
        encabezado.add(this.titulo);

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(5, 2, 20, 20));

        general.add(new JLabel(" Usuario:"));
        usuario = new JTextField("");
        general.add(usuario);

        general.add(new JLabel(" Contraseña:"));
        contraseña = new JPasswordField("");
        general.add(contraseña);

        KeyListener keyListener = new KeyListener() {
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    ListenerButton.autenticarUsuarioBD();
                }
            }

            public void keyReleased(KeyEvent keyEvent) {

            }

            public void keyTyped(KeyEvent keyEvent) {

            }
        };
        contraseña.addKeyListener(keyListener);

        JButton contraOlvidada = new JButton("Contraseña olvidada");
        general.add(contraOlvidada);
        contraOlvidada.setBackground(new Color(232, 91, 74));
        contraOlvidada.addActionListener(new recuperar());

        login = new JButton("Login");
        general.add(login);
        login.setBackground(new Color(64, 199, 102));
        login.addActionListener(new ListenerButton());


        confirmacion = new JLabel("");
        general.add(confirmacion);

        denegacion = new JLabel("");
        general.add(denegacion);
        pricipal.add(encabezado);
        pricipal.add(general);


        add(encabezado, BorderLayout.NORTH);


        add(pricipal, BorderLayout.CENTER);

        setSize(500, 500);
        setVisible(true);

    }

    public static void main() {
        inicio inicios = new inicio();
    }


    private static class ListenerButton implements ActionListener {

        private static void autenticarUsuarioBD() {
            Usuario user = controlLogin.iniciarSesion(usuario.getText(), contraseña.getText());
            if (user != null) {
                switch (user.getTipoUsuario()) {
                    case "Alumno":
                        alumnoGUI.main(user);
                        break;
                    case "Profesor":
                        profesor.main(user);
                        break;
                    case "Jefedeestudios":
                        jefeEstudios.main(user);
                        break;
                    case "Padres":
                        padre.main(user);
                        break;
                    default:
                        confirmacion.setForeground(Color.red);
                        confirmacion.setText("<html> <div style = 'text-align: center;'> Tipo usuario incorrecto </div></html>");
                        break;
                }
            } else {
                confirmacion.setForeground(Color.red);
                confirmacion.setText("<html> <div style = 'text-align: center;'> contraseña incorrecta <br> o <br> usuario incorrecto </div></html>");
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            autenticarUsuarioBD();
        }
    }

    private class recuperar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            denegacion.setForeground(Color.blue);
            denegacion.setText("");
        }
    }
}


