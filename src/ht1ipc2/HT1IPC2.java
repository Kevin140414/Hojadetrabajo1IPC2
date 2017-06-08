package ht1ipc2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jvnet.substance.SubstanceLookAndFeel;

public class HT1IPC2 {

    static Ventana Ventana = new Ventana();

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlackSteelSkin");
        SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBlendBiTheme");
        
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Ventana extends JFrame implements ActionListener {
    
    private JPanel contenedor = new JPanel();
    private JButton jbtHipotenusa, jbt5Vocales, jbtInvertir, jbtReglade3;
    private JTextField jtfImput1, jtfImput2, jtfImput3;
    private JLabel lblResultado, lblDatos;
    
    public Ventana() {
        setTitle("Hoja de Trabajo 1");
        setSize(450,290);
        setLocationRelativeTo(null);
        
        contenedor.setLayout(null);
        
        lblDatos = new JLabel("Ingrese los datos de forma ordenada, segun la operacion que desee realizar");
        contenedor.add(lblDatos);
        lblDatos.setFont(new java.awt.Font("Arial", 0, 11));
        lblDatos.setBounds(30,20,400,20);
        
        lblDatos = new JLabel("Dato 1:");
        contenedor.add(lblDatos);
        lblDatos.setFont(new java.awt.Font("Arial", 0, 12));
        lblDatos.setBounds(20,50,400,20);
        
        jtfImput1 = new JTextField();
        contenedor.add(jtfImput1);
        jtfImput1.setBounds(20, 70, 140, 30);
        
        jbtHipotenusa = new JButton("Calcular Hipotenusa");
        contenedor.add(jbtHipotenusa);
        jbtHipotenusa.setBounds(170,95,120,30);
        jbtHipotenusa.addActionListener(this);
        
        jbt5Vocales = new JButton("5 Vocales");
        contenedor.add(jbt5Vocales);
        jbt5Vocales.setBounds(300,95,120,30);
        jbt5Vocales.addActionListener(this);
        
        lblDatos = new JLabel("Dato 2:");
        contenedor.add(lblDatos);
        lblDatos.setFont(new java.awt.Font("Arial", 0, 12));
        lblDatos.setBounds(20,100,400,20);
        
        jbtInvertir = new JButton("Invertir Texto");
        contenedor.add(jbtInvertir);
        jbtInvertir.setBounds(170,145,120,30);
        jbtInvertir.addActionListener(this);
        
        jbtReglade3 = new JButton("Regla de 3");
        contenedor.add(jbtReglade3);
        jbtReglade3.setBounds(300,145,120,30);
        jbtReglade3.addActionListener(this);
        
        jtfImput2 = new JTextField();
        contenedor.add(jtfImput2);
        jtfImput2.setBounds(20, 120, 140, 30);
        
        lblDatos = new JLabel("Dato 3:");
        contenedor.add(lblDatos);
        lblDatos.setFont(new java.awt.Font("Arial", 0, 12));
        lblDatos.setBounds(20,150,400,20);
        
        jtfImput3 = new JTextField();
        contenedor.add(jtfImput3);
        jtfImput3.setBounds(20, 170, 140, 30);
        
        lblResultado = new JLabel("RESULTADO");
        lblResultado.setFont(new java.awt.Font("Arial Black", 0, 12));
        contenedor.add(lblResultado);
        lblResultado.setBounds(20,205,410,30);
        
        add(contenedor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbtHipotenusa) {
            float A = Float.parseFloat(jtfImput1.getText());
            float B = Float.parseFloat(jtfImput2.getText());
            float H = (float) Math.sqrt(Math.pow(A, 2) + Math.pow(B, 2));
            lblResultado.setText("RESULTADO:  " + Float.toString(H));
        }
        
        if (e.getSource() == jbt5Vocales) {
            if (jtfImput1.getText() != null) {
                String Texto = jtfImput1.getText();
                int contA = 0, contE = 0, contI = 0, contO = 0, contU = 0;
                for (int i = 0; i < Texto.length(); i++) {
                    if (String.valueOf(Texto.charAt(i)).equalsIgnoreCase("a") || String.valueOf(Texto.charAt(i)).equalsIgnoreCase("á")) {
                        contA++;
                    }
                    if (String.valueOf(Texto.charAt(i)).equalsIgnoreCase("e") || String.valueOf(Texto.charAt(i)).equalsIgnoreCase("é")) {
                        contE++;
                    }
                    if (String.valueOf(Texto.charAt(i)).equalsIgnoreCase("i") || String.valueOf(Texto.charAt(i)).equalsIgnoreCase("í")) {
                        contI++;
                    }
                    if (String.valueOf(Texto.charAt(i)).equalsIgnoreCase("o") || String.valueOf(Texto.charAt(i)).equalsIgnoreCase("ó")) {
                        contO++;
                    }
                    if (String.valueOf(Texto.charAt(i)).equalsIgnoreCase("u") || String.valueOf(Texto.charAt(i)).equalsIgnoreCase("ú")) {
                        contU++;
                    }
                }
                if (contA > 0 && contE > 0 && contI > 0 && contO > 0 && contU > 0) {
                    lblResultado.setText("RESULTADO:  CUMPLE");
                } else {
                    lblResultado.setText("RESULTADO:  NO CUMPLE");
                   
                }
            }
        }
        if (e.getSource() == jbtInvertir) {
            if (jtfImput1.getText() != null) {
                String Texto = jtfImput1.getText();
                String TextoInvertido = "";

                for (int i = Texto.length() - 1; i >= 0; i--) {
                    TextoInvertido = TextoInvertido + Texto.charAt(i);
                }
                lblResultado.setText("RESULTADO:   " + TextoInvertido + "_201612460");
            }
        }
        if (e.getSource() == jbtReglade3) {
            float A = Float.parseFloat(jtfImput1.getText());
            float X = Float.parseFloat(jtfImput2.getText());
            float B = Float.parseFloat(jtfImput3.getText());
            float Y = (B*X)/A;
            
            lblResultado.setText("RESULTADO:   " + Y);
        }
    }
}