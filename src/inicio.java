
//imports necesarios

import Controladores.Controlador_login;
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Carmen Martí,Salva Blanquer,Lucia Calabrese
 */

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

        //Declaración de JFrame y JLayeredPane

        general = new JFrame();

        JLayeredPane principal = new JLayeredPane();

        //Declaración de JLabel

        JLabel encabezado = new JLabel("Bienvenid@,");

        JLabel titulo = new JLabel("Acceda a tus datos");

        JLabel labelUsuario = new JLabel("Usuario:");

        JLabel labelContraseña = new JLabel("Contraseña:");

        usuarioIncorrecto = new JLabel(" usuario incorrecto");

        contraIncorrecta = new JLabel(" contraseña incorrecta");

        contraseñaOlvidada = new JLabel("Contraseña olvidada");

        //Declaración de JTextField y JPasswordFIeld

        usuario = new JTextField();

        contraseña = new JPasswordField();

        //Declaración de JButton

        JButton contraseñaOlvidadaBtn = new JButton("Contraseña Olvidada");

        JButton loginBtn = new JButton("Login");

        verContraseñaBtn = new JButton("");

        /* Modificaciones */

        //general

        general.getContentPane().setBackground(new Color(204, 255, 255));
        general.setBackground(new Color(204, 255, 255));
        general.setBounds(100, 100, 1449, 810);
        general.setVisible(true);

        //encabezado

        encabezado.setForeground(new Color(204, 0, 102));
        encabezado.setFont(fuenteTitulo);
        encabezado.setBounds(654, 10, 349, 109);

        //titulo

        titulo.setForeground(new Color(204, 0, 102));
        titulo.setFont(fuenteTitulo);
        titulo.setBounds(569, 37, 562, 163);

        //labelUsuario

        labelUsuario.setForeground(new Color(0, 51, 255));
        labelUsuario.setFont(fuenteGeneral);
        labelUsuario.setBounds(510, 250, 127, 97);

        //labelContraseña

        labelContraseña.setForeground(new Color(0, 51, 255));
        labelContraseña.setFont(fuenteGeneral);
        labelContraseña.setBounds(510, 433, 177, 63);

        //usuarioIncorrecto

        usuarioIncorrecto.setForeground(Color.red);
        usuarioIncorrecto.setFont(fuenteGeneral);
        usuarioIncorrecto.setBounds(850, 314, 230, 63);
        usuarioIncorrecto.setVisible(false);

        //contraIncorrecta

        contraIncorrecta.setForeground(Color.red);
        contraIncorrecta.setFont(fuenteGeneral);
        contraIncorrecta.setBounds(850, 480, 270, 63);
        contraIncorrecta.setVisible(false);

        //contraseñaOlvidada

        contraseñaOlvidada.setForeground(new Color(0, 51, 255));
        contraseñaOlvidada.setFont(new Font("Tahoma", Font.BOLD, 15));
        contraseñaOlvidada.setBounds(344, 698, 303, 33);
        contraseñaOlvidada.setVisible(false);

        //usuario

        usuario.setBounds(849, 278, 328, 56);
        usuario.setColumns(10);

        //contraseña

        contraseña.setBounds(849, 444, 289, 56);

        //contraseñaOlvidadaBtn

        contraseñaOlvidadaBtn.setFont(fuenteBotones);
        contraseñaOlvidadaBtn.setForeground(new Color(255, 255, 255));
        contraseñaOlvidadaBtn.setBackground(new Color(255, 0, 0));
        contraseñaOlvidadaBtn.setBounds(334, 625, 308, 63);

        //loginBtn

        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(new Color(50, 205, 50));
        loginBtn.setFont(fuenteBotones);
        loginBtn.setBounds(953, 625, 368, 63);

        //verContraseñaBtn

        verContraseñaBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjo.png"));
        verContraseñaBtn.setBackground(Color.WHITE);
        verContraseñaBtn.setBounds(1136, 444, 41, 56);

        //Insercciones a la GUI

        general.add(principal);
        general.getContentPane().add(principal, BorderLayout.CENTER);

        principal.add(encabezado);
        principal.add(titulo);
        principal.add(labelUsuario);
        principal.add(usuario);
        principal.add(contraseña);
        principal.add(labelContraseña);
        principal.add(usuarioIncorrecto);
        principal.add(contraIncorrecta);
        principal.add(contraseñaOlvidadaBtn);
        principal.add(contraseñaOlvidada);
        principal.add(loginBtn);
        principal.add(verContraseñaBtn);

        //acciones

        contraseñaOlvidadaBtn.addActionListener(new verContraseña());

        general.addWindowListener(new cerrarVentana());

        contraseña.addKeyListener(new loginEnter());

        loginBtn.addActionListener(new validarLogin());

        verContraseñaBtn.addMouseListener(new mostrarContraseña());
    }

    public static void main() {
        new inicio();
    }

    public static class validarLogin implements ActionListener {

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
                general.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

            //Para que vuelva a estar en blanco
            if (inicio.usuario.getText().equals("")){
                contraseñaOlvidada.setVisible(false);
            }
        }
    }
}

