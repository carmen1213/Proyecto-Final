import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;

public class jefeEstudios extends JFrame {
    private JLabel titulop ;
    private JComboBox reunion;
    private JComboBox recompensas;
    private JLabel vacio;
    private JButton cuestionario;
    Font f = new Font("fantasy", BOLD, 30);

    public jefeEstudios(){
        super("jefeEstudios");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
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




        JMenu amonestaciones = new JMenu("Amonestaciones");

        JRadioButtonMenuItem curso12 = new JRadioButtonMenuItem("DAM");

        JRadioButtonMenuItem curso22 = new JRadioButtonMenuItem("CIN");

        JRadioButtonMenuItem curso32 = new JRadioButtonMenuItem("MIP");




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


        barraMenu.add(amonestaciones);

        amonestaciones.add(curso12);
        amonestaciones.add(curso22);
        amonestaciones.add(curso32);


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
        principal.setLayout(new GridLayout(4,1));
        principal.setBackground(Color.PINK);

        JPanel titulo= new JPanel();
        titulo.setBackground(Color.PINK);
        titulop=new JLabel("Bienvenido " + inicio.usuario.getText());
        titulop.setFont(f);
        titulop.setForeground(new Color(59, 104, 252));
        titulo.add(titulop);

        JPanel primero = new JPanel();
        primero.setBackground(Color.PINK);
        vacio= new JLabel();
        vacio.setBackground(Color.PINK);
        vacio.setBounds(10,30, 200,200);

        JPanel segundo =new JPanel();
        segundo.setLayout(new GridLayout(1,2));
        segundo.setBackground(Color.PINK);


        JPanel botones = new JPanel();
       botones.setBackground(Color.PINK);
        reunion= new JComboBox();


        //disponibilidad.setBorder(new TitledBorder("Dias Disponibles"));
        reunion.addItem("-Reuniones-");
        reunion.addItem("DAM");
        reunion.addItem("CIN");
        reunion.addItem("MIP");



        cuestionario= new JButton("Cuestionario");

        JPanel tercero = new JPanel();
        tercero.setBackground(Color.PINK);

        recompensas = new JComboBox();
        recompensas.addItem("-Recompensas-");
        recompensas.addItem("DAM");
        recompensas.addItem("CIN");
        recompensas.addItem("MIP");



        primero.add(vacio);
        tercero.add(recompensas);
        botones.add(reunion);
        botones.add(cuestionario);
    segundo.add(botones);
        principal.add(titulo);
        principal.add(primero);
        principal.add(segundo);
        principal.add(tercero);
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
