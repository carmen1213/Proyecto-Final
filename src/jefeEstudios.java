import Interfaz.Metodos_repetitivos;
import models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class jefeEstudios {
    public static Font fuenteGeneral = new Font("Wide Latin", Font.PLAIN, 17);
    public static Font fuenteMenu = new Font("MV Boli", Font.PLAIN, 15);
    public static JMenu listasMenu;
    JFrame general;
    JRadioButtonMenuItem amonestacionesDAM;
    JRadioButtonMenuItem amonestacionesMIP;
    JRadioButtonMenuItem amonestacionesCIN;
    JRadioButtonMenuItem leve;
    JRadioButtonMenuItem grave;
    JRadioButtonMenuItem muyGrave;
    JRadioButtonMenuItem quejasDAM;
    JRadioButtonMenuItem quejasCIN;
    JRadioButtonMenuItem quejasMIP;
    JRadioButtonMenuItem listasDAM;
    JRadioButtonMenuItem volverMenu;
    JMenu amonestacionesMenu;
    File archivo;

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


        principal.add(Metodos_repetitivos.Titulo());
        principal.add(Metodos_repetitivos.Usuario(user));


        JLabel jefaEstudiosImagen = new JLabel("");
        jefaEstudiosImagen.setIcon(new ImageIcon("..\\Proyecto-Final\\imagenes\\imagenJefaEstudios.jpg"));
        jefaEstudiosImagen.setHorizontalAlignment(SwingConstants.CENTER);
        jefaEstudiosImagen.setBounds(378, 135, 853, 399);
        principal.add(jefaEstudiosImagen);

        JComboBox reunionesComboBox = new JComboBox();
        reunionesComboBox.setFont(fuenteGeneral);
        reunionesComboBox.setBackground(new Color(204, 255, 255));
        reunionesComboBox.setModel(new DefaultComboBoxModel(new String[]{"-Reuniones-", "DAM", "CIN", "MIP"}));
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
        recompensasComboBox.setModel(new DefaultComboBoxModel(new String[]{"-Recompensas-", "DAM", "CIN ", "MIP"}));
        recompensasComboBox.setFont(fuenteGeneral);
        recompensasComboBox.setBounds(1217, 555, 262, 67);
        principal.add(recompensasComboBox);
        general.setBounds(100, 100, 1503, 827);


        JButton crearAlumnosBtn = new JButton("Crear Alumnos");
        crearAlumnosBtn.addActionListener(new añadirAlumnos());
        crearAlumnosBtn.setBackground(new Color(204, 255, 255));
        crearAlumnosBtn.setIcon(new ImageIcon("C:\\Users\\carma\\Downloads\\persona.jpg"));
        crearAlumnosBtn.setFont(fuenteGeneral);
        crearAlumnosBtn.setBounds(378, 555, 346, 67);
        principal.add(crearAlumnosBtn);
        general.setBounds(100, 100, 1503, 827);

        JMenuBar barraMenu = new JMenuBar();
        barraMenu.setBackground(new Color(255, 192, 203));
        general.setJMenuBar(barraMenu);

        listasMenu = new JMenu("Listas");

        listasMenu.setBackground(new Color(102, 204, 255));
        listasMenu.setFont(fuenteMenu);
        barraMenu.add(listasMenu);

        listasDAM = new JRadioButtonMenuItem("DAM");
        listasDAM.addActionListener(new verListasDAM());
        listasMenu.add(listasDAM);

        amonestacionesMenu = new JMenu("Amonestaciones");
        amonestacionesMenu.setFont(fuenteMenu);
        barraMenu.add(amonestacionesMenu);

        volverMenu = new JRadioButtonMenuItem("volver");
        volverMenu.addActionListener(new volverMenulist());

        JMenu horariosMenu = new JMenu("Horarios");
        horariosMenu.setFont(fuenteMenu);
        barraMenu.add(horariosMenu);

        JMenu quejasMenu = new JMenu("Quejas");
        quejasMenu.setFont(fuenteMenu);
        barraMenu.add(quejasMenu);

        quejasDAM = new JRadioButtonMenuItem("DAM");

        quejasCIN = new JRadioButtonMenuItem("CIN");

        quejasMIP = new JRadioButtonMenuItem("MIP");

        quejasMenu.add(quejasDAM);
        quejasMenu.add(quejasCIN);
        quejasMenu.add(quejasMIP);

        leve = new JRadioButtonMenuItem("LEVE");
        leve.addActionListener(new abrirLeve());

        grave = new JRadioButtonMenuItem("GRAVE");
        grave.addActionListener(new abrirGrave());

        muyGrave = new JRadioButtonMenuItem("MUY GRAVE");
        muyGrave.addActionListener(new abrirMuyGrave());

        volverMenu = new JRadioButtonMenuItem("VOLVER");
        volverMenu.addActionListener(new volverMenulist());


        amonestacionesDAM = new JRadioButtonMenuItem("DAM");
        amonestacionesDAM.addActionListener(new verAmonestacionesDAM());

        amonestacionesCIN = new JRadioButtonMenuItem("CIN");
        amonestacionesCIN.addActionListener(new verAmonestacionesCIN());

        amonestacionesMIP = new JRadioButtonMenuItem("MIP");
        amonestacionesMIP.addActionListener(new verAmonestacionesMIP());

        amonestacionesMenu.add(amonestacionesDAM);
        amonestacionesMenu.add(amonestacionesCIN);
        amonestacionesMenu.add(amonestacionesMIP);

        amonestacionesMenu.add(leve);
        amonestacionesMenu.add(grave);
        amonestacionesMenu.add(muyGrave);
        amonestacionesMenu.add(volverMenu);

        leve.setVisible(false);
        grave.setVisible(false);
        muyGrave.setVisible(false);
        volverMenu.setVisible(false);


        JButton volverBtn = new JButton("");
        volverBtn.addMouseListener(new volverInicio());
        principal.add(Metodos_repetitivos.volverBoton(volverBtn));
    }

    public static void main(Usuario user) {
        new jefeEstudios(user);
        System.out.println(listasMenu.isSelected());
    }


    private class añadirAlumnos implements ActionListener {
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
            inicio.contraseña.setText("");
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


    private class verAmonestacionesDAM implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            amonestacionesDAM.setSelected(false);
            volverMenu.setSelected(false);
            amonestacionesDAM.setVisible(false);
            amonestacionesMIP.setVisible(false);
            amonestacionesCIN.setVisible(false);
            amonestacionesMenu.setText("Gravedad");
        }
    }

    private class verAmonestacionesCIN implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            amonestacionesCIN.setSelected(false);
            volverMenu.setSelected(false);
            amonestacionesDAM.setVisible(false);
            amonestacionesMIP.setVisible(false);
            amonestacionesCIN.setVisible(false);
            amonestacionesMenu.setText("Gravedad");
        }
    }

    private class verAmonestacionesMIP implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            amonestacionesMIP.setSelected(false);
            volverMenu.setSelected(false);
            amonestacionesDAM.setVisible(false);
            amonestacionesMIP.setVisible(false);
            amonestacionesCIN.setVisible(false);
            amonestacionesMenu.setText("Gravedad");
        }
    }

    private class volverMenulist implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setSelected(false);
            leve.setVisible(false);
            grave.setVisible(false);
            muyGrave.setVisible(false);
            volverMenu.setVisible(false);
            amonestacionesDAM.setVisible(true);
            amonestacionesCIN.setVisible(true);
            amonestacionesMIP.setVisible(true);
            amonestacionesMenu.setText("Amonestaciones");
            leve.setSelected(false);
            grave.setSelected(false);
            muyGrave.setSelected(false);
        }

    }

    private class abrirLeve implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            leve.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\plantilla_Amonestaciones\\AmonestacionLeve.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }

    private class abrirGrave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            grave.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\plantilla_Amonestaciones\\AmonestacionGrave.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }

    private class abrirMuyGrave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            muyGrave.setSelected(false);
            try {

                archivo = new File("..\\Proyecto-Final\\PartesYM.deHonor\\AmonestacionMuyGrave.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }


        }
    }

    private class verListasDAM implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            listasDAM.setSelected(false);
            new Listas();

        }
    }
}

