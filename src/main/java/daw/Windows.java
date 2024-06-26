/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author aiman
 */
public class Windows extends JPanel implements ActionListener {

    private static Random rd = new Random();
    private final int ANCHO = 400;
    private final int LARGO = 200;
    //boton y area de texto
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JLabel etiqueta1;
    private JLabel etiqueta2;

    /**
     * Creates new form Windows
     */
    public Windows(JFrame j) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        initsComponents();
        modificarTamaño(j);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // </editor-fold>//GEN-END:initComponents
    private void initsComponents() {

        // Borde del panel
        this.setBorder(new TitledBorder("Datos"));

        // Creamos el botón, con un texto a mostrar
        b1 = new JButton("Botón 1");
        b2 = new JButton("Botón 2");
        b3 = new JButton("Aleatorio");
        etiqueta1 = new JLabel("Etiqueta1");
        etiqueta2 = new JLabel("Etiqueta_2");
        JLabel et2 = new JLabel("Etiqueta2");
        JButton botonRaton = new JButton("Ratón");

        // Posicionamiento de componentes con FlowLayout
        this.setLayout(new FlowLayout());

        // Añadimos los componentes al panel
        this.add(b3);
        this.add(etiqueta1);
        this.add(b1);
        this.add(botonRaton);
        this.add(et2);
        this.add(b2);

        b3.addActionListener(this);
        // Añadir el controlador de eventos al botón "Aleatorio"
        agregarControladorAleatorio(b3, etiqueta1);

        // Añadir el controlador de eventos al botón "Ratón"
        agregarControladorRaton(botonRaton);

        agregarControladorRatonAction(botonRaton, etiqueta2);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //--- Si el botón pulsado es el botón para el nombre
        if (ae.getSource().equals(b3)) {
            int num = rd.nextInt(11);
            b3.setText(String.valueOf(num));
            //--- Sino es el botón para el apellido
        }
    }

    private void agregarControladorRaton(JButton botonRaton) {
        // Crear un MouseListener utilizando una clase interna anónima
        MouseListener mouseListener = new MouseListener() {
            // Método que se ejecuta cuando el ratón entra en el área del botón
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar el color del botón cuando el ratón está sobre él
                botonRaton.setBackground(Color.CYAN); // Color que te guste
            }

            // Método que se ejecuta cuando el ratón sale del área del botón
            @Override
            public void mouseExited(MouseEvent e) {
                // Volver al color gris cuando el ratón sale
                botonRaton.setBackground(Color.GRAY);
            }

            // Los demás métodos de MouseListener se dejan vacíos
            @Override
            public void mouseClicked(MouseEvent e) {
                // Método vacío
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Método vacío
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Método vacío
            }
        };

        // Añadir el MouseListener al botón "Ratón"
        botonRaton.addMouseListener(mouseListener);
    }

    private void agregarControladorAleatorio(JButton botonAleatorio, JLabel etiqueta1) {
        // Crear un ActionListener utilizando una clase interna anónima
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generar un número aleatorio entre 0 y 10
                int numeroAleatorio = new Random().nextInt(11);

                // Actualizar el texto de la etiqueta1 con el número aleatorio
                etiqueta1.setText(String.valueOf(numeroAleatorio));
            }
        };

        // Añadir el ActionListener al botón "Aleatorio"
        botonAleatorio.addActionListener(actionListener);
    }

    private void solicitarDatoYModificarLabel2(JLabel etiqueta2) {
        // Solicitar un dato de tipo texto al usuario utilizando JOptionPane
        String datoIntroducido = JOptionPane.showInputDialog("Por favor, introduce un dato de tipo texto:");

        // Verificar si el usuario ha introducido un dato (datoIntroducido no es null)
        if (datoIntroducido != null) {
            // Modificar el texto de etiqueta2 con el texto introducido por el usuario
            this.etiqueta2.setText(datoIntroducido);
        }
    }

    private void agregarControladorRatonAction(JButton botonRaton, JLabel etiqueta2) {
        // Crear un ActionListener utilizando una clase interna anónima
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al método que solicita un dato y modifica el texto de etiqueta2
                solicitarDatoYModificarLabel2(etiqueta2);
            }
        };

        // Añadir el ActionListener al botón "Ratón"
        botonRaton.addActionListener(actionListener);
    }

    public void modificarTamaño(JFrame jframe) {
        // Tamaño del panel
        this.setPreferredSize(new Dimension(ANCHO, LARGO));

        // Borde del panel
        this.setBorder(new TitledBorder("Datos"));

        // Obtenemos el tamaño de la pantalla.
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamañoFrame = jframe.getSize();

        int xPos = tamañoPantalla.width / 2 - (ANCHO / 2);
        int yPos = tamañoPantalla.height / 2 - (LARGO / 2);

        jframe.setLocation(xPos, yPos);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
