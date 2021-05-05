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
    private obtencion_datos_login control = new obtencion_datos_login();

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
               System.out.println(control.getdatosdellogin().get(0));
               System.out.println(control.getdatosdellogin().get(1));
               for (int i = 0; i < control.getdatosdellogin().size(); i++) {
                   if (usuario.getText().equals(control.getdatosdellogin().get(i)) && contraseña.getText().equals(control.getdatosdellogin().get(i+1))) {
                       confirmacion.setText("inicio correcto");
                       confirmacion.setForeground(Color.GREEN);
                       System.out.println("hola");

                       if (control.getdatosdellogin().get(i+2).equals("Profesor")){
                           profesor.main();
                       } else if (control.getdatosdellogin().get(i+2).equals("Jefedeestudios")){
                           jefeEstudios.main();
                       } else if (control.getdatosdellogin().get(i+2).equals("Alumno")){

                       } else if (control.getdatosdellogin().get(i+2).equals("Padres")){

                       } else if (control.getdatosdellogin().get(i+2).equals("Director")){
                           director.main();
                       }
                   }else{
                       confirmacion.setForeground(Color.red);
                       confirmacion.setText("<html> <div style = 'text-align: center;'> contrase�a incorrecta <br> o <br>usuario incorrecto </div></html>");
                   }
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




