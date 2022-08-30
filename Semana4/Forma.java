package Semana4;
import java.util.ArrayList;

/*clase en la cual se van a definir vertices y lados de la figura
 * 
 */
public class Forma {
    public Puntos[]puntos;
    ArrayList<Integer> puntos = new ArrayList<Integer>()
    public Lados[]lados;
    int num_puntos,num_lados;
    int contador_puntos=0,contador_lados=0;

    /**
     * metodo para definir los puntos de la forma
     * @param num_puntos es el numero de punto que tiene 
     */
    public void set_num_puntos(int num_puntos){
        this.num_puntos=num_puntos;
        this.puntos=new Puntos[this.num_puntos];
    }

    /**
     * metodo para definir el numero de lados de la forma
     * @param num_lados numero de lados
     */
    public void set_num_lados(int num_lados){
        this.num_lados=num_lados;
        this.lados=new Lados[this.num_lados];
    }

    /**
     * metodo para añadir un punto nuevo en la forma
     * @param x coordenada x del punto 
     * @param y coordenada y del punto
     */
    public void add_point(int x,int y){
        if(contador_puntos<num_puntos)this.puntos[contador_puntos++]=new Puntos(x,y);
    }
    
    /**
     * metodo para añadir un lado nuevo en la forma 
     * @param x
     * @param y
     */
    public void add_lado(int x,int y){
        if(contador_lados<num_lados)this.lados[contador_lados++]=new Lados(x,y);
    }
    
}
