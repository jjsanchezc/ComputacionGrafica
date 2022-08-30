package Semana4;


/*clase para poder definir y obtener los
 * valores de estos
 */
public class Puntos {
    public static double ancho = 600;
    public static double altura = 400;
    int xp,yp;
    int xe,ye;
    
    /**
     * metodo constructor de la clase PuntosYLados
     * @param xp variable x del punto 
     * @param yp variable y del punto
     */
    public Puntos(int xp,int yp){
        this.xp=xp;
        this.yp=yp;
    }

    /**
     * setter de la variable xp
     * @param xp
     */
    public void set_cart_xp(double xp){
        this.xp=(int) (xp+ancho/2);
    }

    /**
     * setter de la variable yp (coordenadas cartesianas)
     * @param yp
     */
    public void set_cart_yp(double yp){
        this.yp=(int)(altura/2-yp);
    }

    /**
     * getter de la variable xp
     * @return retorna el valor de xp
     */
    public int get_cart_xp(){
        return this.xp;
    }

    /**
     * Getter de la variable yp
     * @return retorna el valor de yp
     */
    public int get_cart_yp(){
        return this.yp;
    }
}
