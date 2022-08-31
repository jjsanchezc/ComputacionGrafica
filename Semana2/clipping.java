package Semana2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.JFrame;



public class clipping
    extends JPanel
    implements MouseListener,MouseMotionListener{
        Line2D.Double linea1;
        Line2D.Double linea2;
        Line2D.Double linea3;
        int noClick;
        int x1;
        int y1;
        int x2;
        int y2;

        boolean rect=false ;
        

        //coordenadas cartesianas para el area de clipping
        int carRecx1,carRecx2,carRecy1,carRecy2;
        //maximos y minimos del rectangulo
        int xwmax,xwmin,ywmax,ywmin;

        //coordenadas cartesianas para la recta
        int carLinex1,carLinex2,carLiney1,carLiney2;


        

        
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawRect(x1, y1, x2-x1, y2-y1);

            
            g2d.setColor(Color.RED);
            g2d.draw(linea1);
            Graphics2D b = (Graphics2D) g;
            b.setColor(Color.RED);
            b.draw(linea3);

            Graphics2D a = (Graphics2D) g;
            a.setColor(Color.BLUE);
            a.draw(linea2);


        }
        //metodo para definir los minimos y maximos del rectangulo  (Coordenadas cartesianas)
        private void defRectangleMinMax(int xa,int xb,int ya,int yb){
            xwmax=xa<xb ? xb:xa;
            xwmin=xa<xb ? xa:xb;

            ywmax=ya<yb ? yb:ya;
            ywmin=ya<yb ? ya:yb;
             
            System.out.println("clipping area Cartesiana xminima:"+xwmin+"   yminima:" +ywmin);
            System.out.println("clipping area Cartesiana xmaxima:"+xwmax+"   ymaxima:" +ywmax);  
             
        }

        // this function gives the maximum
        public double maxi(double arr[],int n) {
            double m = 0;
            for (int i = 0; i < n; ++i)
            if (m < arr[i])
                m = arr[i];
            return m;
        }
        
        // this function gives the minimum
        public double mini(double arr[], int n) {
            double m = 1;
            for (int i = 0; i < n; ++i)
            if (m > arr[i])
                m = arr[i];
            return m;
        }
        
        public void doclipping(){
            double posarr[]=new double[5];

            double negarr[]=new double[5];

            int posind = 1, negind = 1;
            posarr[0] = 1;
            negarr[0] = 0;
            //variables
            double p1 = -(carLinex2 - carLinex1); //cartesianas
            double p2 = -p1;
            double p3 = -(carLiney2 - carLiney1);
            double p4 = -p3;
        
            double q1 = carLinex1 - xwmin;
            double q2 = xwmax - carLinex1;
            double q3 = carLiney1 - ywmin;
            double q4 = ywmax - carLiney1;

            //System.out.println("p1: "+p1);
            if ((p1 == 0 && q1 < 0) || (p2 == 0 && q2 < 0) || (p3 == 0 && q3 < 0) || (p4 == 0 && q4 < 0)) {
                System.out.println("la linea es paralela al area de clipping");
                
            }
            if (p1 != 0) {
                double r1 = q1 / p1;
                double r2 = q2 / p2;
                if (p1 < 0) {
                    negarr[negind++] = r1; // for negative p1, add it to negative array
                    posarr[posind++] = r2; // and add p2 to positive array
                } else {
                    negarr[negind++] = r2;
                    posarr[posind++] = r1;
                }
            }
            if (p3 != 0) {
                double r3 = q3 / p3;
                double r4 = q4 / p4;
                if (p3 < 0) {
                    negarr[negind++] = r3;
                    posarr[posind++] = r4;
                } else {
                    negarr[negind++] = r4;
                    posarr[posind++] = r3;
                }
            }

            double xn1, yn1, xn2, yn2;
            double rn1, rn2;
            rn1 = maxi(negarr, negind); // maximum of negative array
            rn2 = mini(posarr, posind); // minimum of positive array

            if (rn1 > rn2)  { // reject
                //System.out.println("Line is outside the clipping window!");
                linea1.x1 = carLinex1+142;
                linea1.y1 = 131-carLiney1;
                linea1.x2 = carLinex2+142;
                linea1.y2 = 131-carLiney2;

                linea2.x1=0;
                linea2.x2=0;
                linea2.y1=0;
                linea2.y2=0;

                linea3.x1=0;
                linea3.x2=0;
                linea3.y1=0;
                linea3.y2=0;
                repaint();
                return;

            }
            xn1 = carLinex1 + p2 * rn1;
            yn1 = carLiney1 + p4 * rn1; // computing new puntos

            xn2 = carLinex1 + p2 * rn2;
            yn2 = carLiney1 + p4 * rn2;

            linea2.x1=(int)xn1+142;
            linea2.x2=(int)xn2+142;
            linea2.y1=131-(int)yn1;
            linea2.y2=131-(int)yn2;
            double tmpx,tmpy;
            tmpx= linea1.x2;
            tmpy=linea1.y2;
            if (p1 < 0 ||p2 < 0 || p3 < 0 || p4< 0) {
                
                linea1.x2=linea2.x1;
                linea1.y2=linea2.y1;
            
            }
            if(p1 > 0 ||p2 > 0 || p3 > 0 || p4> 0){
                linea3.x2=tmpx;
                linea3.y2=tmpy;
                linea3.x1=linea2.x2;
                linea3.y1=linea2.y2;
        }
            System.out.println("linea 2 x1:"+linea2.x1+";y1:"+linea2.y1+"\nlinea 2 x2:"+linea2.x2+"; y2:"+linea2.y2);

            repaint();

        }

        public clipping(){
            linea1= new Line2D.Double();
            linea2= new Line2D.Double();
            linea3= new Line2D.Double();
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(noClick!=0){
                x2=e.getX();
                y2=e.getY();
                repaint();
                noClick=0;
                rect=true;
                carRecx2=x2-142;
                carRecy2=131-y2;
                
                defRectangleMinMax(carRecx1,carRecx2,carRecy1,carRecy2);
            }else{
                x1=e.getX();
                y1=e.getY();
                noClick++;
                carRecx1=x1-142;
                carRecy1=131-y1;
                rect=false;
                
            }
            
            
        }


        @Override
        public void mousePressed(MouseEvent e) {
            linea1.x1 = e.getX();
            linea1.y1 = e.getY();
            carLinex1=(int)linea1.x1-142;
            carLiney1=131-(int)linea1.y1;

            System.out.println("----------------------\n------------");
            System.out.println("linea 1: x1:"+carLinex1+"   y1:" +carLiney1);
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            linea1.x2 = e.getX();
            linea1.y2 = e.getY();    
            
            carLinex2=(int)linea1.x2-142;
            carLiney2=131-(int)linea1.y2;

            System.out.println("linea 1 x2:"+carLinex2+"   y2:" +carLiney2);
            System.out.println("----------------------\n------------");
            //doclipping();
            if (rect==true){
                doclipping();
            }
        }





    public static void main(String[] args) {
        JFrame frame = new JFrame("Clipping");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        clipping br =new clipping();
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