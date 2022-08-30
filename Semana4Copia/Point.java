package Semana4Copia;

public class Point {
    public static double width = 600;
    public static double height = 400;
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double getXCart(){
        return this.x - width/2;
    }

    public double getYCart(){
        return height/2 - this.y;
    }

    public void setXFromCart(double x){
        this.x = (int) (x + width/2);
    }
    public void setYFromCart(double y){
        this.y = (int) (height/2 - y);
    }
}

