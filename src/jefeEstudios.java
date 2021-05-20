import models.Usuario;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jefeEstudios {

    public jefeEstudios(Usuario user) {

       JFrame general = new JFrame();
        general.setVisible(true);
        general.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        general.setBackground(new Color(255, 192, 203));
        general.setTitle("Jefa de Estudios");
        general.setIconImage(Toolkit.getDefaultToolkit().getImage("..\\Proyecto-Final\\imagenes\\logoEncabezado.png"));
        general.getContentPane().setBackground(new Color(255, 192, 203));

        JLayeredPane principal = new JLayeredPane();
        general.getContentPane().add(principal, BorderLayout.CENTER);


        JLabel titulo = new JLabel("Bienvenido");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Kristen ITC", Font.BOLD | Font.ITALIC, 34));
        titulo.setBounds(687, -24, 298, 137);
        principal.add(titulo);

        JLabel jefaEstudiosImagen = new JLabel("");
        jefaEstudiosImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenJefaEstudios.jpg"));
        jefaEstudiosImagen.setHorizontalAlignment(SwingConstants.CENTER);
        jefaEstudiosImagen.setBounds(378, 99, 853, 399);
        principal.add(jefaEstudiosImagen);

        JComboBox reunionesComboBox = new JComboBox();
        reunionesComboBox.setFont(new Font("Wide Latin", Font.PLAIN, 17));
        reunionesComboBox.setBackground(new Color(204, 255, 255));
        reunionesComboBox.setModel(new DefaultComboBoxModel(new String[] {"-Reuniones-", "DAM", "CIN", "MIP"}));
        reunionesComboBox.setToolTipText("");
        reunionesComboBox.setBounds(162, 555, 262, 67);
        principal.add(reunionesComboBox);

        JButton cuestionariosBtn = new JButton("Cuestionarios");
       cuestionariosBtn.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenCuestionarios.png"));
        cuestionariosBtn.setBackground(new Color(204, 255, 255));
        cuestionariosBtn.setFont(new Font("Wide Latin", Font.PLAIN, 17));
        cuestionariosBtn.setBounds(675, 555, 310, 67);
        principal.add(cuestionariosBtn);

        JComboBox recompensasComboBox = new JComboBox();
        recompensasComboBox.setBackground(new Color(204, 255, 255));
        recompensasComboBox.setModel(new DefaultComboBoxModel(new String[] {"-Recompensas-", "DAM", "CIN ", "MIP"}));
        recompensasComboBox.setFont(new Font("Wide Latin", Font.PLAIN, 17));
        recompensasComboBox.setBounds(1172, 555, 262, 67);
        principal.add(recompensasComboBox);
        general.setBounds(100, 100, 1503, 827);

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(new Color(255, 192, 203));
        general.setJMenuBar(barraMenu);

        JMenu listasMenu = new JMenu("Listas");

        listasMenu.setBackground(new Color(102, 204, 255));
        listasMenu.setFont(new Font("MV Boli", Font.PLAIN, 15));
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
        amonestacionesMenu.setFont(new Font("MV Boli", Font.PLAIN, 15));
        barraMenu.add(amonestacionesMenu);

        JMenu horariosMenu = new JMenu("Horarios");
        horariosMenu.setFont(new Font("MV Boli", Font.PLAIN, 15));
        barraMenu.add(horariosMenu);

        JMenu quejasMenu = new JMenu("Quejas");
        quejasMenu.setFont(new Font("MV Boli", Font.PLAIN, 15));
        barraMenu.add(quejasMenu);
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
}