
//imports necesarios

import Controladores.Controlador_login;
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Carmen Mart�,Salva Blanquer,Lucia Calabrese
 */

public class inicio {
    public static final Controlador_login controlLogin = new Controlador_login();
    private static final Font fuenteGeneral = new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30);
    private static final Font fuenteBotones = new Font("Stencil", Font.BOLD | Font.ITALIC, 20);
    public static JPasswordField contrase�a;
    public static JTextField usuario;
    public static JLabel usuarioIncorrecto;
    public static JLabel contraIncorrecta;
    public static Font fuenteTitulo = new Font("Snap ITC", Font.BOLD | Font.ITALIC, 45);
    private final JFrame general;
    public static JLabel labelUsuario;
    boolean visible = true;
    JButton verContrase�aBtn;
    private static JLabel contrase�aOlvidada;

    public inicio() {

        //Declaraci�n de JFrame y JLayeredPane

        general = new JFrame();

        JLayeredPane principal = new JLayeredPane();

        //Declaraci�n de JLabel

        JLabel encabezado = new JLabel("Bienvenid@,");

        JLabel titulo = new JLabel("Acceda a tus datos");

        JLabel labelUsuario = new JLabel("Usuario:");

        JLabel labelContrase�a = new JLabel("Contrase�a:");

        usuarioIncorrecto = new JLabel(" usuario incorrecto");

        contraIncorrecta = new JLabel(" contrase�a incorrecta");

        contrase�aOlvidada = new JLabel("Contrase�a olvidada");

        //Declaraci�n de JTextField y JPasswordFIeld

        usuario = new JTextField();

        contrase�a = new JPasswordField();

        //Declaraci�n de JButton

        JButton contrase�aOlvidadaBtn = new JButton("Contrase�a Olvidada");

        JButton loginBtn = new JButton("Login");

        verContrase�aBtn = new JButton("");

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

        //labelContrase�a

        labelContrase�a.setForeground(new Color(0, 51, 255));
        labelContrase�a.setFont(fuenteGeneral);
        labelContrase�a.setBounds(510, 433, 177, 63);

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

        //contrase�aOlvidada

        contrase�aOlvidada.setForeground(new Color(0, 51, 255));
        contrase�aOlvidada.setFont(new Font("Tahoma", Font.BOLD, 15));
        contrase�aOlvidada.setBounds(344, 698, 303, 33);
        contrase�aOlvidada.setVisible(false);

        //usuario

        usuario.setBounds(849, 278, 328, 56);
        usuario.setColumns(10);

        //contrase�a

        contrase�a.setBounds(849, 444, 289, 56);

        //contrase�aOlvidadaBtn

        contrase�aOlvidadaBtn.setFont(fuenteBotones);
        contrase�aOlvidadaBtn.setForeground(new Color(255, 255, 255));
        contrase�aOlvidadaBtn.setBackground(new Color(255, 0, 0));
        contrase�aOlvidadaBtn.setBounds(334, 625, 308, 63);

        //loginBtn

        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(new Color(50, 205, 50));
        loginBtn.setFont(fuenteBotones);
        loginBtn.setBounds(953, 625, 368, 63);

        //verContrase�aBtn

        verContrase�aBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjo.png"));
        verContrase�aBtn.setBackground(Color.WHITE);
        verContrase�aBtn.setBounds(1136, 444, 41, 56);

        //Insercciones a la GUI

        general.add(principal);
        general.getContentPane().add(principal, BorderLayout.CENTER);

        principal.add(encabezado);
        principal.add(titulo);
        principal.add(labelUsuario);
        principal.add(usuario);
        principal.add(contrase�a);
        principal.add(labelContrase�a);
        principal.add(usuarioIncorrecto);
        principal.add(contraIncorrecta);
        principal.add(contrase�aOlvidadaBtn);
        principal.add(contrase�aOlvidada);
        principal.add(loginBtn);
        principal.add(verContrase�aBtn);

        //acciones

        contrase�aOlvidadaBtn.addActionListener(new verContrase�a());

        general.addWindowListener(new cerrarVentana());

        contrase�a.addKeyListener(new loginEnter());

        loginBtn.addActionListener(new validarLogin());

        verContrase�aBtn.addMouseListener(new mostrarContrase�a());
    }

    public static void main() {
        new inicio();
    }

    public static class validarLogin implements ActionListener {

        private static void autenticarUsuarioBD() {
            Usuario user = controlLogin.iniciarSesion(usuario.getText(), contrase�a.getText());
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

            int codigo = JOptionPane.showConfirmDialog(null, "�Estas seguro de que quieres cerrar?", "Confirmacion", JOptionPane.YES_NO_OPTION);
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

    private class mostrarContrase�a implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {


            if (visible) {  // a es una variable boolean en true
                contrase�a.setEchoChar((char) 0); // este m�todo es el que hace visible el texto del jPasswordField
                visible = false;
            } else {
                char i = 0;
                contrase�a.setEchoChar('�'); // i es el char
                visible = true;
            }


            if (!visible) {
                verContrase�aBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjo.png"));
            } else {
                verContrase�aBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjoTachado.png"));
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

    private class verContrase�a implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Muestra el label con el texto correspondiente con la informacion obtenida desde la base de datos
            contrase�aOlvidada.setVisible(true);
            contrase�aOlvidada.setText("Tu contrase�a es: " + controlLogin.getContrase�a(inicio.usuario.getText()));

            //Para que vuelva a estar en blanco
            if (inicio.usuario.getText().equals("")){
                contrase�aOlvidada.setVisible(false);
            }
        }
    }
}

