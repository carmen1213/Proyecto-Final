import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Ingresar_alumnos {

    private final JFrame general;
    private final JTextField textFieldNombre;
    private final JTextField textFieldDNI;
    private final JTextField textFieldFechaNac;
    private final JTextField textFieldCurso;

    public static void main()throws SQLException
    {
        new Ingresar_alumnos();
    }
    public static void main(String[] args) {
        new Ingresar_alumnos();
    }

    public Ingresar_alumnos() {



        general = new JFrame();
        general.setVisible(true);
        general.getContentPane().setBackground(new Color(222, 184, 135));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);

        JLabel encabezado = new JLabel("Bienvenido\r\n");
        encabezado.setHorizontalAlignment(SwingConstants.CENTER);
        encabezado.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 54));
        encabezado.setBounds(568, -37, 436, 205);
        principal.add(encabezado);

        JLabel titulo = new JLabel("Ingrese a continuacion los datos del alumno");
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Sitka Display", Font.BOLD, 30));
        titulo.setBounds(515, 126, 597, 38);
        principal.add(titulo);

        JLabel nombre = new JLabel("Nombre Completo");
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 22));
        nombre.setBounds(243, 217, 314, 58);
        principal.add(nombre);

        JLabel DNI = new JLabel("DNI");
        DNI.setForeground(new Color(0, 0, 0));
        DNI.setHorizontalAlignment(SwingConstants.CENTER);
        DNI.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 22));
        DNI.setBounds(243, 351, 314, 58);
        principal.add(DNI);

        JLabel fechaNac = new JLabel("Fecha de Nacimiento");
        fechaNac.setForeground(new Color(0, 0, 0));
        fechaNac.setHorizontalAlignment(SwingConstants.CENTER);
        fechaNac.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 22));
        fechaNac.setBounds(243, 492, 314, 58);
        principal.add(fechaNac);

        JLabel curso = new JLabel("Curso");
        curso.setForeground(new Color(0, 0, 0));
        curso.setHorizontalAlignment(SwingConstants.CENTER);
        curso.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 22));
        curso.setBounds(243, 625, 314, 58);
        principal.add(curso);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(807, 232, 339, 38);
        principal.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        textFieldDNI = new JTextField();
        textFieldDNI.setColumns(10);
        textFieldDNI.setBounds(807, 366, 339, 38);
        principal.add(textFieldDNI);

        textFieldFechaNac = new JTextField();
        textFieldFechaNac.setColumns(10);
        textFieldFechaNac.setBounds(807, 496, 339, 38);
        principal.add(textFieldFechaNac);

        textFieldCurso = new JTextField();
        textFieldCurso.setColumns(10);
        textFieldCurso.setBounds(807, 629, 339, 38);
        principal.add(textFieldCurso);

        JButton enviarBtn = new JButton("Enviar");
        enviarBtn.setBackground(new Color(255, 245, 238));
        enviarBtn.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 22));
        enviarBtn.setBounds(1309, 705, 154, 67);
        principal.add(enviarBtn);
        general.setBounds(100, 100, 1512, 842);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


    }
}