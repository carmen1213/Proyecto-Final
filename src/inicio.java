import Controladores.Controlador_login;
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class inicio {
    public static final Controlador_login controlLogin = new Controlador_login();
    public static JPasswordField contrase�a;
    public static JTextField usuario;
  //  private static JLabel datosErroneos;
    private final JFrame general;
    boolean a = true;
    JOptionPane confirmacion;
    JButton verContrase�aBtn;


    public inicio() {

        general = new JFrame();
        general.getContentPane().setBackground(new Color(204, 255, 255));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);
        general.addWindowListener(new cerrarVentana());


        JLabel encabezado = new JLabel("Bienvenid@,");
        encabezado.setForeground(new Color(204, 0, 102));
        encabezado.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 45));
        encabezado.setBounds(654, 10, 349, 109);
        principal.add(encabezado);

        JLabel titulo = new JLabel("Accede a tus datos!");
        titulo.setForeground(new Color(204, 0, 102));
        titulo.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 45));
        titulo.setBounds(569, 37, 562, 163);
        principal.add(titulo);

        JLabel lblNewLabel_2 = new JLabel("Usuario:");
        lblNewLabel_2.setForeground(new Color(0, 51, 255));
        lblNewLabel_2.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_2.setBounds(510, 250, 127, 97);
        principal.add(lblNewLabel_2);

        usuario = new JTextField();
        usuario.setBounds(849, 278, 328, 56);
        principal.add(usuario);
        usuario.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Contrase�a:");
        lblNewLabel_3.setForeground(new Color(0, 51, 255));
        lblNewLabel_3.setFont(new Font("Poor Richard", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_3.setBounds(510, 433, 177, 63);
        principal.add(lblNewLabel_3);

        JButton contrase�aOlvidadaBtn = new JButton("Contrase�a olvidada");
        contrase�aOlvidadaBtn.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
        contrase�aOlvidadaBtn.setForeground(new Color(255, 255, 255));
        contrase�aOlvidadaBtn.setBackground(new Color(255, 0, 0));
        contrase�aOlvidadaBtn.setBounds(336, 661, 308, 63);
        principal.add(contrase�aOlvidadaBtn);

        JButton loginBtn = new JButton("Login");
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setBackground(new Color(50, 205, 50));
        loginBtn.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 20));
        loginBtn.setBounds(949, 661, 368, 63);
         loginBtn.addActionListener(new validarLogin());
        principal.add(loginBtn);


        verContrase�aBtn = new JButton("");
        verContrase�aBtn.setBackground(Color.WHITE);

        verContrase�aBtn.setBounds(1136, 444, 41, 56);
        verContrase�aBtn.addMouseListener(new verContrase�a());
        principal.add(verContrase�aBtn);


        contrase�a = new JPasswordField();
        contrase�a.setBounds(849, 444, 289, 56);
        verContrase�aBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenOjo.png"));
        contrase�a.addKeyListener(loginEnter);
        principal.add(contrase�a);
        general.setBackground(new Color(204, 255, 255));
        general.setBounds(100, 100, 1449, 810);
        general.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        general.add(principal);
        general.setVisible(true);
    }

    public static void main() {
        new inicio();
    }

    KeyListener loginEnter = new KeyListener() {
        public void keyPressed(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
               validarLogin.autenticarUsuarioBD();
            }}


        public void keyReleased(KeyEvent keyEvent) {

        }

        public void keyTyped(KeyEvent keyEvent) {

        }
    };

    public static class validarLogin implements ActionListener {

        private static void autenticarUsuarioBD() {
            Usuario user = controlLogin.iniciarSesion(usuario.getText(), contrase�a.getText());
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
                      //  datosErroneos.setForeground(Color.red);
                     //   datosErroneos.setText("<html> <div style = 'text-align: center;'> Tipo usuario incorrecto </div></html>");
                        break;
                }
            } else {
              //  datosErroneos.setForeground(Color.red);
              //  datosErroneos.setText("<html> <div style = 'text-align: center;'> contrase�a incorrecta <br> o <br> usuario incorrecto </div></html>");
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

            int codigo= JOptionPane.showConfirmDialog(null, "�Quieres un euro para una buena causa?", "Donacion", JOptionPane.YES_NO_OPTION);
            if (codigo== JOptionPane.YES_OPTION){
               general.dispose();
            }else{
                confirmacion.setEnabled(false);
            }}

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

    private class verContrase�a implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {


            if (a) {  // a es una variable boolean en true
                contrase�a.setEchoChar((char) 0); // este m�todo es el que hace visible el texto del jPasswordField
                a = false;
            } else {
                char i = 0;
                contrase�a.setEchoChar('�'); // i es el char
                a = true;
            }


            if (!a) {
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
}
