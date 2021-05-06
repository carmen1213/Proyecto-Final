import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AbrirArchivo extends JFrame {

    JButton archivoBtn;

    public AbrirArchivo() {
        super("AbrirArchivo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(3, 2, 20, 1));

        archivoBtn = new JButton("pulsame :)");
        archivoBtn.addActionListener(new abrirArchivo());

        add(general);

        general.add(archivoBtn);
        setSize(650, 400);
        setVisible(true);
    }


    public static void main(String[] args) {
        new AbrirArchivo();
    }


    private class abrirArchivo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {

                File archivo = new File("C:\\Users\\Salvador\\Desktop\\Proyecto-Final\\PartesYM.deHonor\\AmonestaciónLeve.docx");
                Desktop.getDesktop().open(archivo);

            } catch (IOException ex) {

                System.out.println(ex);

            }

        }

    }
}


