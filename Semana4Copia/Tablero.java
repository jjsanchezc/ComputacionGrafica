package Semana4Copia;

import javax.swing.*;
import java.awt.*;


public class Tablero extends JPanel {

    public Forma shape;
    public Tablero(Forma shape){
        this.shape = shape;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        for (Lado s:shape.lados
             ) {
            int x1 = shape.puntos[s.a-1].x;
            int y1 = shape.puntos[s.a-1].y;
            int x2 = shape.puntos[s.b-1].x;
            int y2 = shape.puntos[s.b-1].y;
            g2d.drawLine(x1,y1,x2,y2);
        }
    }

    public void repaintBoard(){
        repaint();
    }

}
