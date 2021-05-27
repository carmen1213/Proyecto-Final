import models.Usuario;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class jefeEstudios {
 JFrame general;

    public static Font fuenteGeneral=new Font("Wide Latin", Font.PLAIN, 17);
    public static Font fuenteTitulo=new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 34);
    public static Font fuenteMenu=new Font("MV Boli", Font.PLAIN, 15);

    public jefeEstudios(Usuario user) {

        general = new JFrame();
        general.setVisible(true);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setBackground(new Color(255, 192, 203));
        general.setTitle("Jefa de Estudios");
        general.setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Proyecto-Final\\imagenes\\logoEncabezado.png"));
        general.getContentPane().setBackground(new Color(255, 192, 203));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);

        JLabel titulo = new JLabel( "Bienvenida" );


        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setBounds(687, -24, 298, 137);
        principal.add(titulo);

        JLabel nombre = new JLabel( user.getNombre());
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(fuenteTitulo);
        nombre.setBounds(468, 69, 720, 49);
        principal.add(nombre);


        JLabel jefaEstudiosImagen = new JLabel("");
        jefaEstudiosImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenJefaEstudios.jpg"));
        jefaEstudiosImagen.setHorizontalAlignment(SwingConstants.CENTER);
        jefaEstudiosImagen.setBounds(378, 135, 853, 399);
        principal.add(jefaEstudiosImagen);

        JComboBox reunionesComboBox = new JComboBox();
        reunionesComboBox.setFont(fuenteGeneral);
        reunionesComboBox.setBackground(new Color(204, 255, 255));
        reunionesComboBox.setModel(new DefaultComboBoxModel(new String[] {"-Reuniones-", "DAM", "CIN", "MIP"}));
        reunionesComboBox.setToolTipText("");
        reunionesComboBox.setBounds(35, 555, 262, 67);
        principal.add(reunionesComboBox);

        JButton cuestionariosBtn = new JButton("Cuestionarios");
        cuestionariosBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenCuestionarios.png"));
        cuestionariosBtn.setBackground(new Color(204, 255, 255));
        cuestionariosBtn.setFont(fuenteGeneral);
        cuestionariosBtn.setBounds(815, 555, 310, 67);
        principal.add(cuestionariosBtn);

        JComboBox recompensasComboBox = new JComboBox();
        recompensasComboBox.setBackground(new Color(204, 255, 255));
        recompensasComboBox.setModel(new DefaultComboBoxModel(new String[] {"-Recompensas-", "DAM", "CIN ", "MIP"}));
        recompensasComboBox.setFont(fuenteGeneral);
        recompensasComboBox.setBounds(1217, 555, 262, 67);
        principal.add(recompensasComboBox);
        general.setBounds(100, 100, 1503, 827);


        JButton crearAlumnosBtn = new JButton("Crear Alumnos");
        crearAlumnosBtn.addActionListener(new aņadirAlumnos());
        crearAlumnosBtn.setBackground(new Color(204, 255, 255));
        crearAlumnosBtn.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\persona.jpg"));
        crearAlumnosBtn.setFont(fuenteGeneral);
        crearAlumnosBtn.setBounds(378, 555, 346, 67);
        principal.add(crearAlumnosBtn);
        general.setBounds(100, 100, 1503, 827);

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(new Color(255, 192, 203));
        general.setJMenuBar(barraMenu);

        JMenu listasMenu = new JMenu("Listas");

        listasMenu.setBackground(new Color(102, 204, 255));
        listasMenu.setFont(fuenteMenu);
        barraMenu.add(listasMenu);

        JCheckBoxMenuItem damCheckItem = new JCheckBoxMenuItem("DAM");
        damCheckItem.addActionListener(new verlistasDam());
        listasMenu.add(damCheckItem);

        JCheckBoxMenuItem cinCheckItem = new JCheckBoxMenuItem("CIN");
        damCheckItem.addActionListener(new verlistasCin());
        listasMenu.add(cinCheckItem);

        JCheckBoxMenuItem mipCheckItem = new JCheckBoxMenuItem("MIP");
        damCheckItem.addActionListener(new verlistasMip());
        listasMenu.add(mipCheckItem);

        JMenu amonestacionesMenu = new JMenu("Amonestaciones");
        amonestacionesMenu.setFont(fuenteMenu);
        barraMenu.add(amonestacionesMenu);

        JMenu horariosMenu = new JMenu("Horarios");
        horariosMenu.setFont(fuenteMenu);
        barraMenu.add(horariosMenu);

        JMenu quejasMenu = new JMenu("Quejas");
        quejasMenu.setFont(fuenteMenu);
        barraMenu.add(quejasMenu);

        JButton volverBtn = new JButton("");
        volverBtn.addMouseListener(new volverInicio());

        volverBtn.setBackground(new Color(204, 255, 204));
        volverBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenVolverJefeEstudios.png"));
        volverBtn.setBounds(10, 10, 80, 49);

        volverBtn.setBorderPainted(false);
        volverBtn.setContentAreaFilled(false);
        volverBtn.setFocusPainted(false);
        volverBtn.setOpaque(false);
        principal.add(volverBtn);

    }

    public static void main(Usuario user) {
        new jefeEstudios(user);
    }

 private class verlistas implements MenuListener {
  @Override
  public void menuSelected(MenuEvent e) {
  new Listas();
  }

  @Override
  public void menuDeselected(MenuEvent e) {

  }

  @Override
  public void menuCanceled(MenuEvent e) {

  }
 }

 private class verlistasDam implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   new Listas();
  }
 }

 private class verlistasMip implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   new Listas();
  }
 }

 private class verlistasCin implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   new Listas();
  }
 }

 private class aņadirAlumnos implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   new Ingresar_alumnos().setVisible(true);
  }


 }

 private class volverInicio implements MouseListener {
  @Override
  public void mouseClicked(MouseEvent e) {
   general.dispose();
   inicio.usuario.setText("");
   inicio.contraseņa.setText("");
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