package Semana4Copia;


public class Punto {
    public static double width = 600;
    public static double height = 400;
    public int x;
    public int y;

    /**
     * Constructor de la clase Punto
     * @param x valor de x en coordenadas cartesianas
     * @param y valor de y en coordenadas cartesianas
     */
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * metodo getter del eje x
     * @return retorna el valor de x en coordenadas cartesianas
     */
    public double getXCart(){
        return this.x - width/2;
    }

    /**
     * metodo getter del eje y
     * @return retorna el valor de y en coordenadas cartesianas
     */
    public double getYCart(){
        return height/2 - this.y;
    }

    /**
     * Setter del eje x, pasa de coordenadas cartesaianas a las coordenadas de JFrame
     * @param x valor del eje x en coordenadas cartesianas
     */
    public void setXFromCart(double x){
        this.x = (int) (x + width/2);
    }

    /**
     * Setter del eje y, pasa de coordenadas cartseaianas a coordenadas JFrame
     * @param y valor del eje y en coordenadas cartesianas
     */
    public void setYFromCart(double y){
        this.y = (int) (height/2 - y);
    }
}

