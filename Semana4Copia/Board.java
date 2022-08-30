package Semana4Copia;

import javax.swing.*;
import java.awt.*;


public class Board extends JPanel {

    public Shape shape;
    public Board(Shape shape){
        this.shape = shape;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        for (Edge s:shape.edges
             ) {
            int x1 = shape.points[s.a-1].x;
            int y1 = shape.points[s.a-1].y;
            int x2 = shape.points[s.b-1].x;
            int y2 = shape.points[s.b-1].y;
            g2d.drawLine(x1,y1,x2,y2);
        }
    }

    public void repaintBoard(){
        repaint();
    }

}
