import Controladores.Controlador_login;
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class inicio {
    public static final Controlador_login controlLogin = new Controlador_login();
    private static final Font fuenteGeneral = new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30);
    private static final Font fuenteBotones = new Font("Stencil", Font.BOLD | Font.ITALIC, 20);
    public static JPasswordField contraseña;
    public static JTextField usuario;
    public static JLabel usuarioIncorrecto;
    public static JLabel contraIncorrecta;
    public static Font fuenteTitulo = new Font("Snap ITC", Font.BOLD | Font.ITALIC, 45);
    private final JFrame general;
    public static JLabel labelUsuario;
    boolean visible = true;
    JButton verContraseñaBtn;
    private static JLabel contraseñaOlvidada;

    public inicio() {

        general = new JFrame();
        general.getContentPane().setBackground(new Color(204, 255, 255));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);
        general.addWindowListener(new cerrarVentana());



        JLabel titulo = new JLabel("Accede a tus datos!");
        titulo.setForeground(new Color(204, 0, 102));
        titulo.setFont(fuenteTitulo);
        titulo.setBounds(569, 37, 562, 163);
        principal.add(titulo);

        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setForeground(new Color(0, 51, 255));
        labelUsuario.setFont(fuenteGeneral);
        labelUsuario.setBounds(510, 250, 127, 97);
        principal.add(labelUsuario);


        usuario = new JTextField();
        usuario.setBounds(849, 278, 328, 56);
        principal.add(usuario);
        usuario.setColumns(10);

        JLabel labelContraseña = new JLabel("Contraseña:");
        labelContraseña.setForeground(new Color(0, 51, 255));
        labelContraseña.setFont(fuenteGeneral);
        labelContraseña.setBounds(510, 433, 177, 63);
        principal.add(labelContraseña);

        usuarioIncorrecto = new JLabel(" usuario incorrecto");
        usuarioIncorrecto.setForeground(Color.red);
        usuarioIncorrecto.setFont(fuenteGeneral);
        usuarioIncorrecto.setBounds(850, 314, 230, 63);
        usuarioIncorrecto.setVisible(false);
        principal.add(usuarioIncorrecto);

        contraIncorrecta = new JLabel(" contraseña incorrecta");
        contraIncorrecta.setForeground(Color.red);
        contraIncorrecta.setFont(fuenteGeneral);
        contraIncorrecta.setBounds(850, 480, 270, 63);
        contraIncorrecta.setVisible(false);
        principal.add(contraIncorrecta);


        JButton contraseñaOlvidadaBtn = new JButton("Contraseña Olvidada");
        contraseñaOlvidadaBtn.setFont(fuenteBotones);
        contraseñaOlvidadaBtn.setForeground(new Color(255, 255, 255));
        contraseñaOlvidadaBtn.setBackground(new Color(255, 0, 0));
        contraseñaOlvidadaBtn.setBounds(334, 625, 308, 63);
        principal.add(contraseñaOlvidadaBtn);

        contraseñaOlvidada = new JLabel("Contrase\u00F1a olvidada");
        contraseñaOlvidada.setForeground(new Color(0, 51, 255));
        contraseñaOlvidada.setFont(new Font("Tahoma", Font.BOLD, 15));
        contraseñaOlvidada.setBounds(344, 698, 303, 33);
        contraseñaOlvidada.setVisible(false);
        principal.add(contraseñaOlvidada);

        JButton loginBtn = new JButton("Login");
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(new Color(50, 205, 50));
        loginBtn.setFont(fuenteBotones);
        loginBtn.setBounds(953, 625, 368, 63);
        loginBtn.addActionListener(new validarLogin());
        principal.add(loginBtn);


        verContraseñaBtn = new JButton("");
        verContraseñaBtn.setBackground(Color.WHITE);

        verContraseñaBtn.setBounds(1136, 444, 41, 56);
        verContraseñaBtn.addMouseListener(new mostrarContraseña());
        principal.add(verContraseñaBtn);


        contraseña = new JPasswordField();
        contraseña.setBounds(849, 444, 289, 56);
        verContraseñaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjo.png"));
        contraseña.addKeyListener(new loginEnter());
        principal.add(contraseña);
        general.setBackground(new Color(204, 255, 255));
        general.setBounds(100, 100, 1449, 810);
        general.add(principal);
        general.setVisible(true);

        //acciones
        contraseñaOlvidadaBtn.addActionListener(new verContraseña());

    }

    public static void main() {
        new inicio();
    }

    public static class validarLogin implements ActionListener {
        //
        private static void autenticarUsuarioBD() {
            Usuario user = controlLogin.iniciarSesion(usuario.getText(), contraseña.getText());
            if (user != null) {
                switch (user.getTipoUsuario()) {
                    case "Alumno":
                        alumno.main(user);
                        break;
                    case "Profesor":
                        profesor.main(user);
                        break;
                    case "Jefedeestudios":
                        jefaEstudios.main(user);
                        break;
                    case "Padres":
                        padre.main(user);
                        break;
                    default:
                        usuarioIncorrecto.setVisible(true);
                        contraIncorrecta.setVisible(true);

                        break;
                }
            } else {


            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            autenticarUsuarioBD();

        }
    }

    private class cerrarVentana implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {

            int codigo = JOptionPane.showConfirmDialog(null, "¿Estas seguro de que quieres cerrar?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            if (codigo == JOptionPane.YES_OPTION) {
                general.dispose();
            } else {
                general.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    }

    private class mostrarContraseña implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {


            if (visible) {  // a es una variable boolean en true
                contraseña.setEchoChar((char) 0); // este método es el que hace visible el texto del jPasswordField
                visible = false;
            } else {
                char i = 0;
                contraseña.setEchoChar('•'); // i es el char
                visible = true;
            }


            if (!visible) {
                verContraseñaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjo.png"));
            } else {
                verContraseñaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjoTachado.png"));
            }
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
    KeyListener loginEnter = new KeyListener() {
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                validarLogin.autenticarUsuarioBD();
            }
        }

    KeyListener loginEnter = new KeyListener() {
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                validarLogin.autenticarUsuarioBD();
            }
        }

        public void keyReleased(KeyEvent keyEvent) {
        }
        public void keyTyped(KeyEvent keyEvent) {
        }
    };

        public void keyReleased(KeyEvent keyEvent) {

        }

        public void keyTyped(KeyEvent keyEvent) {

        }
    };


    private class loginEnter implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                validarLogin.autenticarUsuarioBD();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class verContraseña implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Muestra el label con el texto correspondiente con la informacion obtenida desde la base de datos
            contraseñaOlvidada.setVisible(true);
            contraseñaOlvidada.setText("Tu contraseña es: " + controlLogin.getContraseña(inicio.usuario.getText()));
        }
    }
}

