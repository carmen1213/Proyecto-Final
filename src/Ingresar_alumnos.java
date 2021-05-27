import BDutils.conexionbasedatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ingresar_alumnos extends JFrame {
    private javax.swing.JLabel Curso;
    private javax.swing.JTextField Datos_curso;
    private javax.swing.JTextField Datos_nacimiento;
    private javax.swing.JTextField Datos_nombre;
    private javax.swing.JLabel Dni;
    private javax.swing.JButton Enviar_nuevo_alumno;
    private javax.swing.JLabel Mensaje_bienvenida;
    private javax.swing.JLabel Mensaje_informativo;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField datos_dni;
    private javax.swing.JLabel fecha_nacimiento;
    private Connection conn;

    public static Font fuenteGeneral=new Font("Tahoma", 0, 14);
    public static Font fuenteTitulo=new Font("Tahoma", 1, 24);

    private void initComponents() {

        datos_dni = new javax.swing.JTextField();
        Nombre = new javax.swing.JLabel();
        Datos_nombre = new javax.swing.JTextField();
        Dni = new javax.swing.JLabel();
        fecha_nacimiento = new javax.swing.JLabel();
        Datos_nacimiento = new javax.swing.JTextField();
        Curso = new javax.swing.JLabel();
        Datos_curso = new javax.swing.JTextField();
        Mensaje_bienvenida = new javax.swing.JLabel();
        Enviar_nuevo_alumno = new javax.swing.JButton();
        Mensaje_informativo = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        Nombre.setFont(fuenteGeneral); // NOI18N
        Nombre.setText("Nombre completo");


        Dni.setFont(fuenteGeneral); // NOI18N
        Dni.setText("DNI");

        fecha_nacimiento.setFont(fuenteGeneral); // NOI18N
        fecha_nacimiento.setText("Fecha de nacimiento");

        Curso.setFont(fuenteGeneral); // NOI18N
        Curso.setText("Curso");

        Mensaje_bienvenida.setFont(fuenteTitulo); // NOI18N
        Mensaje_bienvenida.setText("Bienvenido");

        Enviar_nuevo_alumno.setText("Enviar");
        Enviar_nuevo_alumno.addActionListener(new crearAlumno(this));

        Mensaje_informativo.setFont(fuenteGeneral); // NOI18N
        Mensaje_informativo.setText("Ingrese a continuacion los datos del alumno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Nombre)
                                        .addComponent(Curso)
                                        .addComponent(fecha_nacimiento)
                                        .addComponent(Dni, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(datos_dni, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addComponent(Datos_nombre)
                                        .addComponent(Datos_nacimiento)
                                        .addComponent(Datos_curso))
                                .addGap(55, 55, 55))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(Mensaje_bienvenida))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(Mensaje_informativo))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(355, 355, 355)
                                                .addComponent(Enviar_nuevo_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(Mensaje_bienvenida)
                                .addGap(11, 11, 11)
                                .addComponent(Mensaje_informativo)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Datos_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(datos_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Dni))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Datos_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fecha_nacimiento))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Datos_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Curso))
                                .addGap(18, 18, 18)
                                .addComponent(Enviar_nuevo_alumno, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
        );

        pack();
    }
    public Ingresar_alumnos() {
        initComponents();
    }

    public static void main()throws SQLException
    {
        new Ingresar_alumnos().setVisible(true);
    }
    public static void main(String[] args) {
        new Ingresar_alumnos().setVisible(true);
    }
    public int idAlumno_nuevo(String nombre) {
        String SQL = "SELECT id_alumno FROM alumno WHERE nombre = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(SQL);
            st.setString(1, nombre);
            ResultSet alumnosNuevos = st.executeQuery();
            while (alumnosNuevos.next()) {
                int id = alumnosNuevos.getInt(1);
                return  id;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -4;
    }
    private class crearAlumno implements ActionListener {
        private final Ingresar_alumnos datos;

        public crearAlumno(Ingresar_alumnos datos) {
            this.datos = datos;
        }

        public void actionPerformed(ActionEvent e) {
            conexionbasedatos conexion;
            conexion = new conexionbasedatos();
            datos.conn = conexion.conectarMySQL();
            Statement stmt = null;


            try {
                stmt = datos.conn.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            int numero_Curso = 0;
            if (Datos_curso.getText().equals("Dam")){
                 numero_Curso = 1;
            }
            if (Datos_curso.getText().equals("Mip")){
                 numero_Curso =2;
            }
            if (Datos_curso.getText().equals("CIN")){
                numero_Curso = 3;
            }

                try {
                    Object Datos_personales = stmt.executeUpdate("INSERT INTO alumno (nombre,DNI,fecha_nacimiento) " + "VALUES('" + Datos_nombre.getText() + "','" + datos_dni.getText() + "','" + Datos_nacimiento.getText() +  "')");
                    Object Datos_academicos = stmt.executeUpdate("INSERT INTO alumnos_curso (id_alumno,id_curso) " + "VALUES('" + idAlumno_nuevo(Datos_nombre.getText()) + "','" + numero_Curso +  "')");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

