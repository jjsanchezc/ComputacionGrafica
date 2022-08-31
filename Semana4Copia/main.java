package Semana4Copia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static Forma shape;
    public static Tablero board;

    public static final String IMG_PATH = "src/img/";

    public static final double TRASLATION_DELTA = 10;
    public static final double SCALE_DELTA_BIG = 1.2;
    public static final double SCALE_DELTA_SMALL = 0.8;
    public static final double ROTATION_DELTA = 10;



    public static void main(String[] args) throws Exception{
        //Creamos la figura con base al txt
        shape = ReadText.read();

        // Crear un nuevo Frame
        JFrame frame = new JFrame("Transformaciones");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel principal
        JPanel panel = new JPanel();
        panel.setSize(300,300);
        panel.setLayout(null);

        //Agregar panel que servirá como tablero donde estará la figura
        board = new Tablero(shape);
        board.setBackground(Color.WHITE);
        board.setSize(600,400);
        panel.add(board);

        //Agregar panel para los botones
        JPanel nav = new JPanel();
        nav.setBackground(Color.ORANGE);
        nav.setBounds(0,400,600,200);
        nav.setLayout(null);

        //Crear y agregar los botones al nav
        JButton btn1 = new JButton();
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(1);
            }
        });
        btn1.setBounds(100,10,64,64);
        btn1.setIcon(new ImageIcon(IMG_PATH + "flecha-hacia-arriba.png"));

        JButton btn2 = new JButton();
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(2);
            }
        });
        btn2.setBounds(100,80,64,64);
        btn2.setIcon(new ImageIcon(IMG_PATH + "flecha-hacia-abajo.png"));

        JButton btn3 = new JButton();
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(3);
            }
        });
        btn3.setBounds(31,44,64,64);
        btn3.setIcon(new ImageIcon(IMG_PATH + "flecha-hacia-izq.png"));

        JButton btn4 = new JButton();
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(4);
            }
        });
        btn4.setBounds(169,44,64,64);
        btn4.setIcon(new ImageIcon(IMG_PATH + "flecha-hacia-der.png"));

        JButton btn5 = new JButton();
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(5);
            }
        });
        btn5.setBounds(270,44,64,64);
        btn5.setIcon(new ImageIcon(IMG_PATH + "atras.png"));

        JButton btn6 = new JButton();
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(6);
            }
        });
        btn6.setBounds(350,44,64,64);
        btn6.setIcon(new ImageIcon(IMG_PATH + "adelante.png"));

        JButton btn7 = new JButton();
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(7);
            }
        });
        btn7.setBounds(460,10,64,64);
        btn7.setIcon(new ImageIcon(IMG_PATH + "anadir.png"));

        JButton btn8 = new JButton();
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(8);
            }
        });
        btn8.setBounds(460,80,64,64);
        btn8.setIcon(new ImageIcon(IMG_PATH + "menos.png"));

        nav.add(btn1);
        nav.add(btn2);
        nav.add(btn3);
        nav.add(btn4);
        nav.add(btn5);
        nav.add(btn6);
        nav.add(btn7);
        nav.add(btn8);
        panel.add(nav);

        //Agregar panel general
        frame.add(panel);

        // Asignarle tamaño
        frame.setSize(600, 600);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        // Mostrar el frame
        frame.setVisible(true);
    }

    public static void move (int type) {
        for (Punto p:shape.points
        ) {
            if(type == 1) p.setYFromCart(p.getYCart()+TRASLATION_DELTA);
            if(type == 2) p.setYFromCart(p.getYCart()-1*TRASLATION_DELTA);
            if(type == 3) p.setXFromCart(p.getXCart()-1*TRASLATION_DELTA);
            if(type == 4) p.setXFromCart(p.getXCart()+TRASLATION_DELTA);
            if(type == 5) {
                double x = p.getXCart()*Math.cos(-1*ROTATION_DELTA) - p.getYCart()*Math.sin(-1*ROTATION_DELTA);
                double y = p.getXCart()*Math.sin(-1*ROTATION_DELTA) + p.getYCart()*Math.cos(-1*ROTATION_DELTA);
                p.setXFromCart(x);
                p.setYFromCart(y);
            }
            if(type == 6) {
                double x = p.getXCart()*Math.cos(ROTATION_DELTA) - p.getYCart()*Math.sin(ROTATION_DELTA);
                double y = p.getXCart()*Math.sin(ROTATION_DELTA) + p.getYCart()*Math.cos(ROTATION_DELTA);
                p.setXFromCart(x);
                p.setYFromCart(y);
            }
            if(type == 7) {
                p.setXFromCart(p.getXCart()*SCALE_DELTA_BIG);
                p.setYFromCart(p.getYCart()*SCALE_DELTA_BIG);
            }
            if(type == 8) {
                p.setXFromCart(p.getXCart()*SCALE_DELTA_SMALL);
                p.setYFromCart(p.getYCart()*SCALE_DELTA_SMALL);
            }
        }
        board.repaintBoard();
    }

}

