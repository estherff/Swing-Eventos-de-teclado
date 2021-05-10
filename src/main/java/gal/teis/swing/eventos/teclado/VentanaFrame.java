package gal.teis.swing.eventos.teclado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Esther Ferreiro
 */
public class VentanaFrame extends JFrame implements KeyListener {

    JLabel labelTitulo;
    JLabel labelAreaEntrada;
    JLabel labelAreaSalida;
    JLabel labelSalida;
    JLabel labelContadorVocales;
    JTextArea areaEntradaDeTexto;
    JScrollPane scrollPaneAreaEntrada;
    JTextArea areaSalidaDeTexto;
    JScrollPane scrollPaneAreaSalida;

    int cantidadVocales = 0;
    String vocales = "";

    public VentanaFrame() {
        setLayout(null);
        //tamaño de la ventana
        setSize(550, 350);
        setTitle("Análisis de eventos de teclado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pone la ventana en el Centro de la pantalla
        setLocationRelativeTo(null);
        iniciaComponentes();
       
    }

    private void iniciaComponentes() {
        labelTitulo = new JLabel();
        labelTitulo.setFont(new java.awt.Font("Papyrus", 0, 28));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Eventos del Teclado");
        labelTitulo.setBorder(javax.swing.BorderFactory.
                createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelTitulo.setBounds(110, 20, 300, 40);

        labelAreaEntrada = new JLabel();
        labelAreaEntrada.setBounds(10, 70, 180, 40);
        labelAreaEntrada.setText("Area Entrada de Texto");

        areaEntradaDeTexto = new JTextArea();
        areaEntradaDeTexto.setLineWrap(true);
        //areaSalidaDeTexto será el componente que escucha evento
        areaEntradaDeTexto.addKeyListener(this);

        scrollPaneAreaEntrada = new JScrollPane();
        scrollPaneAreaEntrada.setBounds(10, 100, 513, 70);
        scrollPaneAreaEntrada.setViewportView(areaEntradaDeTexto);

        labelAreaSalida = new JLabel();
        labelAreaSalida.setBounds(10, 170, 180, 40);
        labelAreaSalida.setText("Area Salida de Texto");

        areaSalidaDeTexto = new JTextArea();
        areaSalidaDeTexto.setLineWrap(true);
        //areaSalidaDeTexto será el componente que escucha también eventos
        //pues ante la escritura de texto en areaEntradaDeTexto se escribirán en
        //él las vocales
        areaSalidaDeTexto.addKeyListener(this);

        scrollPaneAreaSalida = new JScrollPane();
        scrollPaneAreaSalida.setBounds(10, 200, 513, 70);
        scrollPaneAreaSalida.setViewportView(areaSalidaDeTexto);

        labelContadorVocales = new JLabel();
        labelContadorVocales.setBounds(380, 280, 190, 20);

        labelSalida = new JLabel();
        labelSalida.setText("Para salir presione la tecla Escape");
        labelSalida.setBounds(10, 280, 210, 20);

        add(labelTitulo);
        add(labelSalida);
        add(labelContadorVocales);
        add(labelAreaEntrada);
        add(labelAreaSalida);
        add(scrollPaneAreaEntrada);
        add(scrollPaneAreaSalida);
    }

    /**
     * Este metodo se ejecuta cuando se presiona una tecla
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getSource() == areaEntradaDeTexto) {
            if (e.VK_A == e.getKeyCode()) {
                vocales += "a ";
                cantidadVocales++;
            }
            if (e.VK_E == e.getKeyCode()) {
                vocales += "e ";
                cantidadVocales++;
            }
            if (e.VK_I == e.getKeyCode()) {
                vocales += "i ";
                cantidadVocales++;
            }
            if (e.VK_O == e.getKeyCode()) {
                vocales += "o ";
                cantidadVocales++;
            }
            if (e.VK_U == e.getKeyCode()) {
                vocales += "u ";
                cantidadVocales++;
            }
        }
        areaSalidaDeTexto.setText(vocales);
        labelContadorVocales.setText("Numero Vocales: " + cantidadVocales);
    }

    /**
     * Este metodo se ejecuta cuando se suelta una tecla
     */
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Soltó la tecla:  " + e.getKeyText(e.getKeyCode()));
        if (e.getSource() == areaEntradaDeTexto) {
            if (e.VK_ESCAPE == e.getKeyCode()) {
                int respuesta = JOptionPane.showConfirmDialog(this,
                        "Esta seguro que desea salir?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Este metodo funcionará solo cuando se presionan caracteres, si se
     * presionan teclas como F1, F2, inicio etc no ejecutará ningun evento
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
