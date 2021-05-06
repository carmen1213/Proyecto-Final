


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static java.awt.Font.BOLD;


public class recompensas extends javax.swing.JFrame {
    JButton listasBtn;
    private JLabel titulop;
    Font f = new Font("Monospaced", BOLD, 30);

    public recompensas() {
        initComponents();
        miImagen.setIcon(new ImageIcon("..\\EjemploImagenJLabel\\img\\usuario.png"));


    }


    private void initComponents() {

        miImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Recompensas");

        setLayout(new FlowLayout());

        JPanel titulo = new JPanel();
        titulop = new JLabel("Bienvenida ");
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(3, 2, -150, 0));
        general.setBorder(new TitledBorder(""));

        JPanel principal = new JPanel();

        listasBtn = new JButton("Listado Alumnos");


        general.add(new JLabel(""));
        general.add(titulop);
        general.add(new JLabel(""));
        general.add(new JLabel(""));
        general.add(listasBtn);


        general.add(titulo);
        general.add(principal);
        general.add(new JLabel());

        add(general);
        setSize(650, 600);
        setVisible(true);


        miImagen.setBorder(new TitledBorder(""));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        /*
         Para Posicionar la imagen/gif a lo largo del eje x hay que modificar el ".addContainerGap()",
         solo hay que modificar el valor (max) y cuanto menor sea el valor (max) mas alta sera la imagen/gif y
         cuanto mayor sea el valor (max) mas baja sera la imagen/gif, tambien si quieres modificar el tamaño de la imagen
         tienes que modificar el ".addComponent(miImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))"
         en concreto el valor "150" y cambiar el 150 por el valor que quieras.
          */

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(0, 480)
                                .addComponent(miImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)));


        /*
         Para Posicionar la imagen/gif a lo largo del eje y hay que modificar el ".addContainerGap()",
         solo hay que modificar el valor (max) y cuanto menos (max) mas -- la imagen/gif y
         cuanto mas (max) mas -- la imagen/gif, tambien si quieres modificar el tamaño de la imagen
         tienes que modificar el ".addComponent(miImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))"
         en concreto el valor "PREFERRED_SIZE, 150" y cambiar el 150 por el valor que quieras.

       */

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(0, 10)
                                .addComponent(miImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        new recompensas().setVisible(true);


    }

    private javax.swing.JLabel miImagen;
}


