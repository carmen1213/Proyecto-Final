import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class listas  extends JFrame {
    private ControladorTabla controlador = new ControladorTabla();

    static ArrayList<String> resultadosdam = new ArrayList<>();

    private JLabel titulop;
    private JComboBox asignatura;
    private JTable table;
    private DefaultTableModel model;
    private JCheckBox asistencia;
     private JButton guardar;
    private JButton modificar;
    private  JFrame f;
    String[][] data = {
            { "4031", "CSE"},
            {"Anand Jha", "6014", "IT"}
    };




    public listas()  {
        super("Listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(227, 247, 193));
        this.setResizable(false);
        setLayout(new FlowLayout()); // Cuando creas la ventana,defines la plantilla/distribucion

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(4, 1));
        general.setBackground(new Color(227, 247, 193));

        JPanel titulo = new JPanel();
        titulo.setBackground(new Color(227, 247, 193));
        titulop = new JLabel("Bienvenido");
        titulo.add(titulop);

        JPanel opciones = new JPanel();
        opciones.setBackground(new Color(227, 247, 193));
        opciones.setLayout(new GridLayout(1, 4, 12, 0));
        opciones.add(new JLabel(" "));
        opciones.add(new JLabel(" "));

        DatePicker fecha = new DatePicker(LocalDate.now());
        UtilDateModel model = new UtilDateModel();
        model.setDate(2021, 3, 23);
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        datePicker.setBackground(new Color(227, 247, 193));
        opciones.add(datePicker);
        JPanel combo = new JPanel();
        combo.setLayout(new GridLayout(3,1));
        combo.setBackground(new Color(227, 247, 193));
        asignatura = new JComboBox();
        asignatura.setBackground(new Color(227, 247, 193));
        asignatura.addItem("Programacion");
        asignatura.addItem("Bases de datos");
        combo.add(asignatura);
        opciones.add(combo);
        fecha.setEditable(false);



        JPanel primer = new JPanel();
        primer.setLayout(new GridLayout(2,1));
        primer.setBackground(new Color(227, 247, 193));
        JPanel referencia = new JPanel();
        referencia.setBackground(new Color(227, 247, 193));
       referencia.add(new JLabel(" "));


        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1,3));
        botones.setBackground(new Color(227, 247, 193));
        botones.add(new JLabel());
        botones.add(new JLabel());
        JPanel guardarm = new JPanel();
        guardarm.setBackground(new Color(227, 247, 193));
        guardar = new JButton("Guardar");
        modificar = new JButton("Modificar");


        guardarm.add(guardar);
        guardarm.add(modificar);
        botones.add(guardarm);
        primer.add(referencia);
        primer.add(botones);



        general.add(titulo);
        general.add(opciones);
       general.add(primer);

        add(general);
        setSize(860, 530);

        setVisible(true);
    }

    public static void main() throws SQLException {
        listas v1 = new listas();
    }


    public static class DatePicker {
        public DatePicker(LocalDate now) {

        }

        public DatePicker() {

        }

        public void setEditable(boolean b) {
        }
    }

    private class listenerbtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 100; i++) {

            }
        }
    }
    private int columna_patron ;

    public listas(int Colpatron) throws SQLException {
        this.columna_patron = Colpatron;
    }
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
        if( table.getValueAt(row,columna_patron).equals(false) )
        {
            setBackground(Color.red);
        }


        return this;
    }

}
