import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class Jefedeestudios extends JFrame {

private JLabel titulop ;
    Font f = new Font("Monospaced", BOLD, 30);
        JButton listasBtn;
        JButton cuestionariosBtn;
        JButton amonestacionesBtn;
        JButton reunionesBtn;
        JButton horariosBtn;
        JButton quejasBtn;


        public Jefedeestudios() {
            super("jefeEstudios");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
            this.getContentPane().setBackground(Color.orange);

            JPanel general = new JPanel();
            general.setLayout(new BorderLayout());

            JPanel menu = new JPanel();
            JMenuBar mb = new JMenuBar();

            JMenu listas = new JMenu("Listas");

            JRadioButtonMenuItem curso1 = new JRadioButtonMenuItem("DAM");

            JRadioButtonMenuItem curso2 = new JRadioButtonMenuItem("CIN");

            JRadioButtonMenuItem curso3 = new JRadioButtonMenuItem("MIP");


            JMenu cuestionarios = new JMenu("Cuestionarios");

            JRadioButtonMenuItem curso11 = new JRadioButtonMenuItem("DAM");

            JRadioButtonMenuItem curso21 = new JRadioButtonMenuItem("CIN");

            JRadioButtonMenuItem curso31 = new JRadioButtonMenuItem("MIP");


            JMenu amonestaciones = new JMenu("Amonestaciones");

            JRadioButtonMenuItem curso12 = new JRadioButtonMenuItem("DAM");

            JRadioButtonMenuItem curso22 = new JRadioButtonMenuItem("CIN");

            JRadioButtonMenuItem curso32 = new JRadioButtonMenuItem("MIP");


            JMenu reuniones = new JMenu("Reuniones");

            JRadioButtonMenuItem curso13 = new JRadioButtonMenuItem("DAM");

            JRadioButtonMenuItem curso23 = new JRadioButtonMenuItem("CIN");

            JRadioButtonMenuItem curso33 = new JRadioButtonMenuItem("MIP");


            JMenu horarios = new JMenu("Horarios");

            JRadioButtonMenuItem curso14 = new JRadioButtonMenuItem("DAM");

            JRadioButtonMenuItem curso24 = new JRadioButtonMenuItem("CIN");

            JRadioButtonMenuItem curso34 = new JRadioButtonMenuItem("MIP");


            JMenu quejas = new JMenu("Quejas");



            JRadioButtonMenuItem curso15 = new JRadioButtonMenuItem("DAM");

            JRadioButtonMenuItem curso25= new JRadioButtonMenuItem("CIN");

            JRadioButtonMenuItem curso35 = new JRadioButtonMenuItem("MIP");

            mb.add(listas);

            listas.add(curso1);
            listas.add(curso2);
            listas.add(curso3);

            mb.add(cuestionarios);

            cuestionarios.add(curso11);
            cuestionarios.add(curso21);
            cuestionarios.add(curso31);

            mb.add(amonestaciones);

            amonestaciones.add(curso12);
            amonestaciones.add(curso22);
            amonestaciones.add(curso32);

            mb.add(reuniones);

            reuniones.add(curso13);
            reuniones.add(curso23);
            reuniones.add(curso33);

            mb.add(horarios);

            horarios.add(curso14);
            horarios.add(curso24);
            horarios.add(curso34);

            mb.add(quejas);

            quejas.add(curso15);
            quejas.add(curso25);
            quejas.add(curso35);


setJMenuBar(mb);
            menu.add(mb);






JPanel principal = new JPanel();
principal.setLayout(new GridLayout(3,2));

            JPanel titulo= new JPanel();
            titulop=new JLabel("Bienvenido " + inicio.usuario.getText());
            titulop.setFont(f);
            titulop.setForeground(new Color(140, 24, 82));
            titulo.add(titulop);

            principal.add(titulo);
            general.add(principal);
            general.add(menu);




            add(general);
            setSize(600, 200);
            setVisible(true);
        }

        public static void main() {
            new Jefedeestudios();

        }
    }

