import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class pruebanotas extends JFrame {
    private float importeTotal = 0;
    public pruebanotas() {

        //Array bidimensional de objetos con los datos de la tabla
        Object[][] data = {
                {"Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false)},
                {"Lhucas", "Huml", "Patinar", new Integer(3), new Boolean(true)},
                {"Kathya", "Walrath", "Escalar", new Integer(2), new Boolean(false)},
                {"Marcus", "Andrews", "Correr", new Integer(7), new Boolean(true)},
                {"Angela", "Lalth", "Nadar", new Integer(4), new Boolean(false)}
        };

        //Array de ‘String’ con los titulos de las columnas
        String[] columnNames = {"Nombre", "Apellido", "Pasatiempo", "Años de Practica", "Soltero(a)"};

        //Creacion de la tabla
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        DefaultTableModel dtm;
        for (int i = 0; i < table.getRowCount(); i++) {
            //LLAMAMOS EL MODELO DE LA TABLA.

            //HACEMOS LA CONVERSION CON UN PARSE PARA QUE NO DE ERROR.
            // EN ESTA PARTE HAY QUE TENER CUIDADO DE QUE LA CELDA
            // NO CONTENGA LITERALES PUES NOS MANDARA ERROR.

            //ESTA ES LA NUEVA LINEA.
            String a = table.getValueAt(i, 3) + "";
            float importe = Float.parseFloat(a);
            //SUMAMOS LA FILA ACTUAL AL TOTAL GLOBAL.
            System.out.println(i);
            importeTotal+=importe;
            float importes =  importeTotal/(i+1);
            System.out.println(importes);
        }
        //Creamos un scrollpanel y se lo agregamos a la tabla
        JScrollPane scrollpane = new JScrollPane(table);

        //Agregamos el scrollpanel al contenedor
        getContentPane().add(scrollpane, BorderLayout.CENTER);

        //manejamos la salida
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public static void main(String ar[]) {
        pruebanotas frame = new pruebanotas();
        frame.pack();
        frame.setVisible(true);
    }
}

