package Semana4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.GrayFilter;
import javax.swing.JFrame;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

public class Transformaciones2D extends JPanel{
    Forma form;
    public static void main(String[]args){}
    
    public Transformaciones2D(Forma Form){
        this.form=form;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        for (Lados s:Forma.lados) 
        {
            int x1 = Forma.puntos[s.a-1].x;
            int y1 = Forma.puntos[s.a-1].y;
            int x2 = Forma.puntos[s.b-1].x;
            int y2 = Forma.puntos[s.b-1].y;
            g2d.drawLine(x1,y1,x2,y2);
        }

        repaint();
    }
    
}
