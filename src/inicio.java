import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;

public class inicio extends JFrame {
   private JLabel logo;
   private JLabel titulop;
    private  JButton login,olvido;
    private JLabel confirmacion,denegacion;
    public static JTextField usuario;
    private JTextField contraseña;
    Font f = new Font("Monospaced", BOLD, 24);

   public inicio(){
       super("Inicio");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setResizable(false);
       setLayout(new FlowLayout());

            JPanel pricipal=new JPanel();
            pricipal.setLayout( new GridLayout(2,1));


            JPanel titulo=new JPanel();
            titulo.setLayout(new BorderLayout());
       titulop = new JLabel("<html> <div style = 'text-align: center;'> Bienvenido, <br> Accede a tus datos! </div></html>");
       titulop.setFont(f);
       titulop.setForeground(new Color(140, 24, 82));
       titulo.add(titulop);



            JPanel general= new JPanel();
           general.setLayout(new GridLayout(5,2,20,20));


           general.add(new JLabel(" Usuario:"));
           usuario=new JTextField("");
           general.add(usuario);


           general.add(new JLabel(" Contraseña:"));
           contraseña=new JPasswordField("");
           general.add(contraseña);

       olvido=new JButton("Contraseña olvidada");
       general.add(olvido);
       olvido.setBackground(new Color(232, 91, 74));
       olvido.addActionListener(new recuperar());

           login=new JButton("Login");
           general.add(login);
            login.setBackground(new Color(64, 199, 102));
           login.addActionListener(new ListenerButton());


           confirmacion=new JLabel("");
           general.add(confirmacion);

           denegacion=new JLabel("");
           general.add(denegacion);
            pricipal.add(titulo);
           pricipal.add(general);


           add(titulo,BorderLayout.NORTH);


           add(pricipal,BorderLayout.CENTER);

           setSize(500,500);
           setVisible(true);

       }
    public static void main() {
        inicio inicios = new inicio();
    }

    private class ListenerButton implements ActionListener {

           @Override
           public void actionPerformed(ActionEvent e) {
               if (usuario.getText().equals("Cristina") && contraseña.getText().equals("1")) {
                   confirmacion.setText("inicio correcto");
                   confirmacion.setForeground(Color.GREEN);
                   director.main();
                   return;
               }

               else if (usuario.getText().equals("Ivan") && contraseña.getText().equals("2")) {
                   confirmacion.setText("inicio correcto");
                   confirmacion.setForeground(Color.GREEN);
                   profesor.main();

               }

              else if (usuario.getText().equals("Neus") && contraseña.getText().equals("3")) {
                   confirmacion.setText("inicio correcto");
                   confirmacion.setForeground(Color.GREEN);
                   Jefedeestudios.main();

               }

               else if (usuario.getText().equals("padre") && contraseña.getText().equals("4")) {
                   confirmacion.setText("inicio correcto");
                   confirmacion.setForeground(Color.GREEN);
                   padre.main();

               }

               else if (usuario.getText().equals("alumno") && contraseña.getText().equals("5")) {
                   confirmacion.setText("inicio correcto");
                   confirmacion.setForeground(Color.GREEN);
                   alumnoGUI.main();

               }

               else{
                   confirmacion.setForeground(Color.red);
                   confirmacion.setText("<html> <div style = 'text-align: center;'> contraseña incorrecta <br> o <br>usuario incorrecto </div></html>");
               }
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




