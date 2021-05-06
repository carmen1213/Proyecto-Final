import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static java.awt.Font.BOLD;

public class partes extends JFrame {
    private JLabel titulop;

    JRadioButtonMenuItem dam1m;
    JRadioButtonMenuItem CIMm;
    JRadioButtonMenuItem mip;

    JRadioButtonMenuItem dam1l;
    JRadioButtonMenuItem mip1;
    JRadioButtonMenuItem CINl;

    JRadioButtonMenuItem leve;
    JRadioButtonMenuItem grave;
    JRadioButtonMenuItem muyGrave;

    JRadioButtonMenuItem volverMenu;
    JMenu partesMenu;
    File archivo;

    Font f = new Font("Monospaced", BOLD, 30);

    public partes() {
        super("partes");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(227, 247, 193));
        setLayout(new FlowLayout());
        setBackground(new Color(227, 247, 193));

        JPanel general = new JPanel();
        general.setBackground(new Color(227, 247, 193));

        JPanel principal = new JPanel();
        principal.setLayout(new GridLayout(4, 1, 0, 15));
        principal.setBackground(new Color(227, 247, 193));

        JPanel menu = new JPanel();
        menu.setBackground(new Color(227, 247, 193));

        JMenuBar barraMenu = new JMenuBar();
        menu.add(barraMenu);

        partesMenu = new JMenu("Partes");

        dam1l = new JRadioButtonMenuItem("DAM");
        dam1l.addActionListener(new partesDam());

        CINl = new JRadioButtonMenuItem("CIN");
        CINl.addActionListener(new partesCin());

        mip1 = new JRadioButtonMenuItem("MIP");
        mip1.addActionListener(new partesMip());


        leve = new JRadioButtonMenuItem("leve");
        leve.addActionListener(new AbrirLeve());

        grave = new JRadioButtonMenuItem("grave");

        muyGrave = new JRadioButtonMenuItem("muy grave");

        volverMenu = new JRadioButtonMenuItem("volver");
        volverMenu.addActionListener(new volverMenulist());


        JPanel titulo = new JPanel();
        titulop = new JLabel("Bienvenido");
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);
        titulo.setBackground(new Color(227, 247, 193));

        principal.add(titulo);

        dam1m = new JRadioButtonMenuItem(" DAM");

        CIMm = new JRadioButtonMenuItem("CIN");

        mip = new JRadioButtonMenuItem("MIP");

        barraMenu.add(partesMenu);

        partesMenu.add(dam1l);
        partesMenu.add(CINl);
        partesMenu.add(mip1);

        partesMenu.add(leve);
        partesMenu.add(grave);
        partesMenu.add(muyGrave);
        partesMenu.add(volverMenu);

        leve.setVisible(false);
        grave.setVisible(false);
        muyGrave.setVisible(false);
        volverMenu.setVisible(false);

        setJMenuBar(barraMenu);

        general.add(menu);
        general.add(principal);

        add(general, BorderLayout.CENTER);
        setSize(400, 520);
        setVisible(true);

    }

    public static void main(String args[]) {
        new partes();
    }


    private class partesDam implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            dam1l.setSelected(false);
            volverMenu.setSelected(false);
            dam1l.setVisible(false);
            mip1.setVisible(false);
            CINl.setVisible(false);
            partesMenu.setText("Gravedad");


        }
    }

    private class partesCin implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            CINl.setSelected(false);
            volverMenu.setSelected(false);
            dam1l.setVisible(false);
            mip1.setVisible(false);
            CINl.setVisible(false);
            partesMenu.setText("Gravedad");
        }
    }

    private class partesMip implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            volverMenu.setVisible(true);
            leve.setVisible(true);
            grave.setVisible(true);
            muyGrave.setVisible(true);

            mip1.setSelected(false);
            volverMenu.setSelected(false);
            dam1l.setVisible(false);
            mip1.setVisible(false);
            CINl.setVisible(false);
            partesMenu.setText("Gravedad");
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
            dam1l.setVisible(true);
            mip1.setVisible(true);
            CINl.setVisible(true);
            partesMenu.setText("Partes");
            leve.setSelected(false);
            grave.setSelected(false);
            muyGrave.setSelected(false);
        }

    }

    private class AbrirLeve implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            leve.setSelected(false);
            try {

                archivo = new File("C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\PartesYM.deHonor\\AmonestaciónLeve.docx");
                Desktop.getDesktop().open(archivo);


            } catch (IOException ex) {

                System.out.println(ex);


            }
        }
    }
}


