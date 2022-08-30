package Semana1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.JFrame;



public class Bresenham
    extends JPanel
    implements MouseListener,MouseMotionListener{

        Line2D.Double linea1;
        Line2D.Double lineax;
        Line2D.Double lineay;
        double x1;
        double y1;
        double x2;
        double y2;

        private final int pixelSize=1;
        public Bresenham(){
            linea1= new Line2D.Double();
            lineax= new Line2D.Double();
            lineay=new Line2D.Double();


            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }
        
        @Override
        public void paintComponent(Graphics g){
            Graphics2D ejex=(Graphics2D) g;
            Graphics2D ejey=(Graphics2D) g;
            //eje x 
            ejex.setColor(Color.RED);
            ejex.drawLine(0, 131, 285, 131);
            //ejey
            ejey.setColor(Color.GREEN);
            ejey.drawLine(142, 0, 142, 262);

            
            drawLine(g,(int)x1,(int)y1,(int)x2,(int)y2);
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
            
        }

        public void drawLine(Graphics g, int x1, int y1, int x2, int y2){
            // delta of exact value and rounded value of the dependent variable
            int d = 0;
            
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            int dx2 = 2 * dx; // slope scaling factors to
            int dy2 = 2 * dy; // avoid floating point

            int ix = x1 < x2 ? 1 : -1; // increment direction
            int iy = y1 < y2 ? 1 : -1;

            int x = x1;
            int y = y1;

            if (dx >= dy) {
                while (true) {
                    plot(g, x, y);
                    if (x == x2)
                        break;
                    x += ix;
                    d += dy2;
                    if (d > dx) {
                        y += iy;
                        d -= dx2;
                    }
                }
            } else {
                while (true) {
                    plot(g, x, y);
                    if (y == y2)
                        break;
                    y += iy;
                    d += dx2;
                    if (d > dy) {
                        x += ix;
                        d -= dy2;
                    }
                }
            }
        }


        private void plot(Graphics g, int x, int y) { 
            int w = (getWidth() - 1) / pixelSize;
            int h = (getHeight() - 1) / pixelSize;
            int maxX = (w - 1) / 2;
            int maxY = (h - 1) / 2;
     
            int borderX = getWidth() - ((2 * maxX + 1) * pixelSize + 1);
            int borderY = getHeight() - ((2 * maxY + 1) * pixelSize + 1);
            int left = (x + maxX) * pixelSize + borderX / 2;
            int top = (y + maxY) * pixelSize + borderY / 2;
            g.setColor(Color.black);
            g.drawOval(left-142, top-131, pixelSize, pixelSize);
        }


        @Override
        public void mousePressed(MouseEvent e) {
            linea1.x1 = e.getX();
            x1=linea1.x1;
            linea1.y1 = e.getY();
            y1=linea1.y1;

            int x1cart=(int)linea1.x1-142;
            int y1cart=131-(int)linea1.y1;
            System.out.println("coordenada cartesiana x1:"+x1cart+";   y1:"+y1cart);
            System.out.println("coordenada JFrame x1:"+linea1.x1+";   y1:" +linea1.y1+"\n");
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            linea1.x2 = e.getX();
            x2=linea1.x2;
            linea1.y2 = e.getY();  
            y2=linea1.y2;
            repaint();
            int x2cart=(int)linea1.x2-142;
            int y2cart=131-(int)linea1.y2;
            System.out.println("coordenada cartesiana x2:"+x2cart+";   y2:"+y2cart);
            System.out.println("coordenada JFrame x2:"+linea1.x2+";   y2:" +linea1.y2+"\n");
            System.out.println("-----------------");
        }
        
        public static void main(String[] args) {
            JFrame frame = new JFrame("Bresenham");
    
            // Al cerrar el frame, termina la ejecución de este programa
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Agregar un JPanel que se llama Points (esta clase)
            Bresenham br =new Bresenham();
            frame.add(br);
            // Asignarle tamaño
            frame.setSize(300, 300);
            // Poner el frame en el centro de la pantalla
            frame.setLocationRelativeTo(null);
            // Mostrar el frame
            frame.setVisible(true);
            
        }






        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

}
