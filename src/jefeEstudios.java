import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;

public class jefeEstudios extends JFrame {
    private JLabel titulop ;
    Font f = new Font("Monospaced", BOLD, 30);

    public jefeEstudios(){
        super("jefeEstudios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.PINK);

        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        general.setBackground(Color.PINK);

        JPanel menu = new JPanel();
        menu.setBackground(new Color(227, 247, 193));

        JMenuBar barraMenu =new JMenuBar();

        menu.add(barraMenu);

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

        barraMenu.add(listas);

        listas.add(curso1);
        listas.add(curso2);
        listas.add(curso3);

        barraMenu.add(cuestionarios);

        cuestionarios.add(curso11);
        cuestionarios.add(curso21);
        cuestionarios.add(curso31);

        barraMenu.add(amonestaciones);

        amonestaciones.add(curso12);
        amonestaciones.add(curso22);
        amonestaciones.add(curso32);

        barraMenu.add(reuniones);

        reuniones.add(curso13);
        reuniones.add(curso23);
        reuniones.add(curso33);

        barraMenu.add(horarios);

        horarios.add(curso14);
        horarios.add(curso24);
        horarios.add(curso34);

        barraMenu.add(quejas);

        quejas.add(curso15);
        quejas.add(curso25);
        quejas.add(curso35);

        setJMenuBar(barraMenu);


        JPanel principal = new JPanel();
        principal.setLayout(new GridLayout(3,2));
        principal.setBackground(Color.PINK);

        JPanel titulo= new JPanel();
        titulo.setBackground(Color.PINK);
        titulop=new JLabel("Bienvenido " + inicio.usuario.getText());
        titulop.setFont(f);
        titulop.setForeground(new Color(140, 24, 82));
        titulo.add(titulop);

        principal.add(titulo);
        general.add(principal);
        add(general);
        setSize(470,520);
        setVisible(true);
    }
    public static void main() {
        jefeEstudios jefe = new jefeEstudios();
    }


    private class ListercoJe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
